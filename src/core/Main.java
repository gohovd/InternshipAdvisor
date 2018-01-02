package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/Landing.fxml"));
        primaryStage.setTitle("Internship Advisor");
        primaryStage.setScene(new Scene(root, 1024, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //demo();
        launch(args);
    }

    /**
     * Make some dummy data.
     */
    private static void demo() {
        // Make a list of non-professional interests
        ArrayList hobbies = new ArrayList<Topic>();
        Topic npt1 = new Topic("cinema");
        Topic npt2 = new Topic("videogames");
        Topic npt3 = new Topic("meditation");
        Topic npt4 = new Topic("birdwatching");
        hobbies.add(npt1);
        hobbies.add(npt2);
        hobbies.add(npt3);
        hobbies.add(npt4);
        // Make a list of professional interests
        ArrayList subjects = new ArrayList<Topic>();
        Subject pt1 = new Subject("biology");
        Subject pt2 = new Subject("cooking");
        Subject pt3 = new Subject("programming");
        Subject pt4 = new Subject("politics");
        subjects.add(pt1);
        subjects.add(pt2);
        subjects.add(pt3);
        // Make a HashMap of the students grades in the subjects.
        HashMap grades = new HashMap<Subject, Integer>();
        grades.put(pt1, 7.5);
        grades.put(pt2, 6.0);
        grades.put(pt3, 8.5);
        grades.put(pt4, 5.5);
        // Make a student
        Student student = new Student();
        // Assign values..
        student.setAvatar_resource("user.png");
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
        Internship i1 = new Internship();
        i1.setMax_age(33);
        i1.setMin_age(16);
        i1.setCompany_name("Kentucky Fried Chicken");
        i1.setLogo_resource("kfc.png");
        i1.setInternship_location("Johan Huizingalaan 763A");
        i1.setReq_behavior(6);
        i1.setReq_independence(6);
        i1.setReq_gpa(6.5);
        i1.setReq_social(6);
        // Related topics
        ArrayList i1_topics = new ArrayList<Topic>();
        i1_topics.add(new Topic("biology"));
        i1_topics.add(new Topic("birdwatching"));
        i1.setRelated_topics(i1_topics);

        // Internship #2
        Internship i2 = new Internship();
        i2.setMax_age(33);
        i2.setMin_age(16);
        i2.setCompany_name("Apple");
        i2.setLogo_resource("apple.png");
        i2.setInternship_location("De Boelelaan 1105");
        i2.setReq_behavior(6);
        i2.setReq_independence(6);
        i2.setReq_gpa(6.5);
        i2.setReq_social(6);
        // Related topics
        ArrayList i2_topics = new ArrayList<Topic>();
        i2_topics.add(new Topic("programming"));
        i2.setRelated_topics(i2_topics);
        // Aggregate internships.
        ArrayList<Internship> internships = new ArrayList<>();
        internships.add(i1);
        internships.add(i2);

        // Make a match object.
        // Here we perform all tasks of assessment.
        Match m1 = new Match(student, internships);
    }

}
