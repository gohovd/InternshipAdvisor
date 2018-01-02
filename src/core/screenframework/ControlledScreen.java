package core.screenframework;

/**
 * Created by gohovd on 08/06/2016
 *
 */
public interface ControlledScreen {

    //Inject parent.
    public void setScreenParent(ScreensController screenParent);

    public void update();

}
