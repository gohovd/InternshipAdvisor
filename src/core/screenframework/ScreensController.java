package no.offsimcentre.ProjectorControl.screenframework;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by gohovd on Jun 09 08:14 2016
 *
 * This class serves as the root framework for working with several screens in this project.
 * If you want to use another screen, simply make a FXML document, and a controller class for that FXML document -
 * then go to GUI.java and declare an ID for the screen, and it's resource (the fxml document) - then use the loadScreen
 * method in this class to prepare the application for using the screen.
 *
 * Whenever you want to change/swap screens, simply call the setScreen(ID, STACK) method here.
 */
public class ScreensController extends StackPane {

    private HashMap<String, Node> screens = new HashMap<>();
    private HashMap<Node, ControlledScreen> controllerMap = new HashMap<>();

    public ScreensController() {
        super();
    }

    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    public Node getScreen(String name) {
        return screens.get(name);
    }

    private int previousStack;

    /**
     * Screens you know for sure you want to use can be loaded here, and put in a HashMap for later reference.
     * @param name - Name of the screen (ID) you want to load.
     * @param resource - Relative path to the FXML resource of the screen.
     * @return boolean - True successful, false unsuccessful.
     */
    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) loader.load();
            ControlledScreen screenController = ((ControlledScreen) loader.getController());

            //The next line is essential if the scene is to be drawn.
            screenController.setScreenParent(this);
            addScreen(name, loadScreen);

            controllerMap.put(loadScreen, screenController);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Bring a specific screen into focus, by referencing its ID and whether or not to stack it ontop of another screen.
     * If stack is set to 0, only the referenced screen will be displayed. If stack is more than 0, the screen will be
     * showed on-top of the screen already being displayed.
     * @param name - Name (ID) of the screen you want to display.
     * @param stack - Whether or not to stack this screen on top of another.
     * @return boolean - True successful, false unsuccessful.
     */
    public boolean setScreen(final String name, int stack) {
        if (screens.get(name) != null) {
            if (stack == 0) {
                getChildren().clear();
                getChildren().add(0, screens.get(name));
            } else {
                while (previousStack >= stack) {
                    getChildren().remove(previousStack);
                    previousStack--;
                }
                getChildren().add(stack, screens.get(name));
            }
            previousStack = stack;
            updateController(screens.get(name));
            System.err.println("Updating " + name);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for updating a screen.
     * @param node - Some screen to update.
     */
    private void updateController(Node node) {
        controllerMap.get(node).update();
    }

    /**
     * Remove some screen from the HashMap of loaded screens.
     * @param name - ID of the screen to remove.
     * @return - True successful, false unsuccessful.
     */
    public boolean unloadScreen(String name) {
        if (screens.remove(name) == null) {
            System.out.println("Screen does not exist.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Changes to a another screen, and does so with a fancy fade transition.
     * @param name - Name (ID) of screen you want to display.
     * @param stack - Whether or not to stack this new screen on-top of the one already being displayed.
     * @return - True successful, false unsuccessful.
     */
    public boolean setScreenFancy(final String name, boolean stack) {
        if (screens.get(name) != null) {
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(500), new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                getChildren().remove(0);
                                getChildren().add(0, screens.get(name));
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(400), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(1250), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("Screen has not been loaded.");
            return false;
        }
    }


}
