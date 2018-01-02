package core;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Landing screen is divided into a profile- and an internship- pane.
 * Here we populate those, and register and act on events.
 */
public class LandingController implements Initializable {

    // Dummy data
    ArrayList hobbies;
    ArrayList subjects;
    HashMap grades;
    Student student;
    Internship i1, i2;
    ArrayList i1_topics, i2_topics;
    ArrayList<Internship> internships;
    Match m1;

    // Chart dummy data
    static String behavior = "Behavior";
    static String independence = "Indendence";
    static String motivation = "Motivation";
    static String social = "Social";
    static String gpa = "GPA";
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    StackedBarChart<String, Number> sbc =
            new StackedBarChart<String, Number>(xAxis, yAxis);
    XYChart.Series<String, Number> series1 =
            new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> series2 =
            new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> series3 =
            new XYChart.Series<String, Number>();

    @FXML
    AnchorPane internship_pane, profile_pane; // INT (W): 300px PROF (W): 724px
    @FXML
    VBox internship_vbox;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        demo();

        System.out.println("**Initializing Landing**");

        //TODO Populate Profile GridPane
        populateProfilePane();
        //TODO Populate Internship GridPane
        populateInternshipPane();
        // TODO Build charts

        sbc.setAnimated(false);
        sbc.layout();

    }

    private void populateProfilePane() {
        // Depending on who has been authenticated, we collect their avatar and display it.
        // Next to some user details, first- and last- name.

        ImageView avatar_holder = new ImageView(); // Need students profile pic
        String imagePath = Main.class.getResource("../resources/graphics/").toString() + student.getAvatar_resource();
        try {
            Image avatar = new Image(new URL(imagePath).toString());
            avatar_holder.setImage(avatar);
            avatar_holder.setId("avatarHolder"); // CSS ID
        } catch (MalformedURLException e) {
            System.out.println(e);
        }

        VBox profile_holder = new VBox();
        profile_holder.setMaxWidth(256);
        profile_holder.setId("profileHolder"); // CSS ID
        profile_holder.setAlignment(Pos.CENTER);

        Label username = new Label();
        username.setText("Username: " + student.getName());
        username.setContentDisplay(ContentDisplay.LEFT);
        username.setId("usernameHolder"); // CSS ID

        profile_holder.getChildren().addAll(avatar_holder, username);
        profile_pane.getChildren().add(profile_holder);
        AnchorPane.setLeftAnchor(profile_holder, 44.0);
    }

    private void populateInternshipPane() {
        // Three columns: 1. Company Logo, 2. Position/Location/Company, 3. Charts
        GridPane internship_grid = new GridPane();
        RowConstraints rc = new RowConstraints();
        ColumnConstraints cc = new ColumnConstraints();
        rc.setMinHeight(256);
        cc.setMinWidth(256);
        internship_grid.setGridLinesVisible(true);

        VBox company_details = new VBox(); // Each entry in the VBOX is one 1x3 GridPane
        // LOGO     // CHARTS       // ?????
        // LOGO
//        ImageView logo_holder = new ImageView(); // Need students profile pic
//        Image logo = new Image(Main.class.getResourceAsStream("../resources/graphics/apple.png"));
//        logo_holder.setImage(logo);

        ImageView logo_holder = new ImageView(); // Need students profile pic
        String logoPath = Main.class.getResource("../resources/graphics/").toString() + internships.get(1)
                .getLogo_resource();
        try {
            Image logo = new Image(new URL(logoPath).toString());
            logo_holder.setImage(logo);
            logo_holder.setId("logoHolder"); // CSS ID
        } catch (MalformedURLException e) {
            System.out.println(e);
        }

        internship_grid.add(logo_holder,0, 0);

        // CHARTS
//        Label lab1 = new Label();
//        lab1.setText("Graphs here!");
//        internship_grid.add(lab1, 1, 0);
        internship_grid.add(sbc, 1, 0);


        // ?????
        Label lab2 = new Label();
        lab2.setText("Button maybe?");
        internship_grid.add(lab2, 2, 0);



        internship_grid.getColumnConstraints().add(cc);
        internship_grid.getRowConstraints().add(rc);
        internship_grid.setMinSize(256, 256);


        internship_pane.getChildren().add(internship_grid);
        AnchorPane.setLeftAnchor(internship_grid, 25.0);
    }

    private void demo() {
        // Make a list of non-professional interests
        hobbies = new ArrayList<Topic>();
        Topic npt1 = new Topic("cinema");
        Topic npt2 = new Topic("videogames");
        Topic npt3 = new Topic("meditation");
        Topic npt4 = new Topic("birdwatching");
        hobbies.add(npt1);
        hobbies.add(npt2);
        hobbies.add(npt3);
        hobbies.add(npt4);
        // Make a list of professional interests
        subjects = new ArrayList<Topic>();
        Subject pt1 = new Subject("biology");
        Subject pt2 = new Subject("cooking");
        Subject pt3 = new Subject("programming");
        Subject pt4 = new Subject("politics");
        subjects.add(pt1);
        subjects.add(pt2);
        subjects.add(pt3);
        // Make a HashMap of the students grades in the subjects.
        grades = new HashMap<Subject, Integer>();
        grades.put(pt1, 7.5);
        grades.put(pt2, 6.0);
        grades.put(pt3, 8.5);
        grades.put(pt4, 5.5);
        // Make a student
        student = new Student();
        // Assign values..
        student.setAvatar_resource("kfc.png");
        student.setAge(17);
        student.setBehavior_rating(8);
        student.setIndependence(4);
        student.setTime_absent(24);
        student.setSocial_ability(3);
        student.setIq(110);
        student.setHobbies(hobbies);
        student.setSubjects(subjects);
        student.setGrades(grades);
        student.setName("Kjetil");

        // Make a few internships!
        // Internship #1
        i1 = new Internship();
        i1.setMax_age(33);
        i1.setMin_age(16);
        i1.setCompany_name("Kentucky Fried Chicken");
        i1.setLogo_resource("kfc.png");
        i1.setInternship_location("Johan Huizingalaan 763A");
        i1.setReq_behavior(6);
        i1.setReq_independence(6);
        i1.setReq_gpa(6.5);
        i1.setReq_social(6);
        i1.setReq_motivation(5);
        // Related topics
        i1_topics = new ArrayList<Topic>();
        i1_topics.add(new Topic("biology"));
        i1_topics.add(new Topic("birdwatching"));
        i1.setRelated_topics(i1_topics);

        // Internship #2
        i2 = new Internship();
        i2.setMax_age(33);
        i2.setMin_age(16);
        i2.setCompany_name("Apple");
        i2.setLogo_resource("apple.png");
        i2.setInternship_location("De Boelelaan 1105");
        i2.setReq_behavior(6);
        i2.setReq_independence(6);
        i2.setReq_gpa(6.5);
        i2.setReq_social(6);
        i2.setReq_motivation(4);
        // Related topics
        i2_topics = new ArrayList<Topic>();
        i2_topics.add(new Topic("programming"));
        i2_topics.add(new Topic("electronics"));
        i2.setRelated_topics(i2_topics);
        // Aggregate internships.
        internships = new ArrayList<>();
        internships.add(i1);
        internships.add(i2);

        // Make a match object.
        // Here we perform all tasks of assessment.
        m1 = new Match(student, internships);

        buildChart();
    }

    private void buildChart() {
        sbc.setTitle("Assessment Summary");
        xAxis.setLabel("Category");
        xAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(behavior, independence, motivation, social, gpa)));
        yAxis.setLabel("Value");
        series1.setName("Required");
        // Collect required values for the categories from internship
        int rBehavior = internships.get(0).getReq_behavior();
        int rIndependence = internships.get(0).getReq_independence();
        int rMotivation = internships.get(0).getReq_motivation();
        int rSocial = internships.get(0).getReq_social();
        double rGPA = internships.get(0).getReq_gpa();
        series1.getData().add(new XYChart.Data<String, Number>(behavior, rBehavior));
        series1.getData().add(new XYChart.Data<String, Number>(independence, rIndependence));
        series1.getData().add(new XYChart.Data<String, Number>(motivation, rMotivation));
        series1.getData().add(new XYChart.Data<String, Number>(social, rSocial));
        series1.getData().add(new XYChart.Data<String, Number>(gpa, rGPA));
        series2.setName("Actual");
        // Collect actual values from student in question
        int aBehavior = student.getBehavior_rating();
        int aIndependence = student.getIndependence();
        int aMotivation = student.getMotivation();
        int aSocial = student.getSocial_ability();
        double aGPA = calculateGPA(student.getGrades());
        series2.getData().add(new XYChart.Data<String, Number>(behavior, aBehavior));
        series2.getData().add(new XYChart.Data<String, Number>(independence, aIndependence));
        series2.getData().add(new XYChart.Data<String, Number>(motivation, aMotivation));
        series2.getData().add(new XYChart.Data<String, Number>(social, aSocial));
        series2.getData().add(new XYChart.Data<String, Number>(gpa, aGPA));
    }

    private double calculateGPA(HashMap<Subject, Double> grades) {
        double gpa = 0.0;

        for(Double i : grades.values()) {
            gpa += i;
        }
        gpa = gpa/grades.size();

        return gpa;
    }

}
