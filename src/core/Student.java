package core;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * As with internship, students also have a number of attributes.
 * - Age*
 * - Grades (in various subjects, see 'Topics')
 * - Time absent
 * - Hobbies (see 'Topics')
 * - IQ
 * - Behavioral rating (1-10)
 * - Independent worker? (1-10)
 * - Motivation
 * - Size of setting (small or large environemnt)???
 * - Background (narrative? family situation?)
 * - Social abilities (1-10)?
 * - Logistics (can the student get there?)
 * - Professional Interests (****merged with subjects)
 */
public class Student {

    int age; // The age of the student.
    int social_ability; // Indicating social ability of the student.
    int behavior_rating; // Indicating behavioral abilities of the student.
    int motivation; // Student's motivation.
    int independence; // Ability of the student to work independently.
    int iq; // Intelligence points.
    int time_absent; // Hours absent.
    ArrayList hobbies = new ArrayList<Topic>(); // Collection of topics that the student favors (non-professional).
    ArrayList subjects = new ArrayList<Topic>(); // Collection of topics that the student favors (professional).
    HashMap grades = new HashMap<Subject, Double>(); // Map subjects to grades.
    String background; // Short story on the student's background.
    String name;
    String avatar_resource;


    public Student() {
        //TODO Open prompt, input everything..
    }

    public String getAvatar_resource() {
        return avatar_resource;
    }

    public void setAvatar_resource(String avatar_resource) {
        this.avatar_resource = avatar_resource;
    }

    public Student(int age, int social_ability, int behavior_rating, int motivation, int independence,
                   String background, int iq, int time_absent) {
        // TODO need guards! NULL allowed?
        this.age = age;
        this.social_ability = social_ability;
        this.behavior_rating = behavior_rating;
        this.motivation = motivation;
        this.independence = independence;
        this.background = background;
        this.iq = iq;
        this.time_absent = time_absent;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSocial_ability() {
        return social_ability;
    }

    public void setSocial_ability(int social_ability) {
        this.social_ability = social_ability;
    }

    public int getMotivation() {
        return motivation;
    }

    public void setMotivation(int motivation) {
        this.motivation = motivation;
    }

    public int getIndependence() {
        return independence;
    }

    public void setIndependence(int independence) {
        this.independence = independence;
    }

    public ArrayList getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList hobbies) {
        this.hobbies = hobbies;
    }

    public ArrayList getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList subjects) {
        this.subjects = subjects;
    }

    public HashMap getGrades() {
        return grades;
    }

    public void setGrades(HashMap grades) {
        this.grades = grades;
    }

    public int getBehavior_rating() {
        return behavior_rating;
    }

    public void setBehavior_rating(int behavior_rating) {
        this.behavior_rating = behavior_rating;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public int getTime_absent() {
        return time_absent;
    }

    public void setTime_absent(int time_absent) {
        this.time_absent = time_absent;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}


