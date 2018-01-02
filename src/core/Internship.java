package core;

import java.util.ArrayList;

/**
 * Internships have several attributes.
 * https://trello.com/b/bv58vPAl/knowledge-application
 * - Minimum/maximum age
 * - Nature/type of work (via tags)
 * - Level of indendence required in the work (1-10)
 * - Behavioral requirements (1-10)
 * - Physical requirements (standing, sitting, lifting, bearing)
 * - Logistics (level of ease to go there via. public transport?)
 * .. some of these qualitative requirements may be aggregated
 * .. (e.g.) "level of control over student/worker"
 */

public class Internship {

    int min_age; // Minimum age requirement for the internship.
    int max_age; // Maximum age requirement for the internship.
    int req_independence; // Level from 1-10 indicating to what degree the company expects the worker to work independently.
    int req_behavior; // Level from 1-10 indicating the behavioral requirements posed by the company.
    int req_motivation; // Level from 1-10.
    String company_name; // Name of the company issuing the position.
    String internship_location; // The location of the internship.
    String internship_position; // The title of the worker (CEO, Emergency Aid, ..)
    String logo_resource;
    ArrayList related_topics = new ArrayList<Topic>();
    int req_social;
    double req_gpa;

    public Internship() {
        // TODO launch prompt upon creating a new internship.
    }

    public String getLogo_resource() {
        return logo_resource;
    }

    public void setLogo_resource(String logo_resource) {
        this.logo_resource = logo_resource;
    }

    public ArrayList getRelated_topics() {
        return related_topics;
    }

    public void setRelated_topics(ArrayList related_topics) {
        this.related_topics = related_topics;
    }

    public int getReq_social() {
        return req_social;
    }

    public void setReq_social(int req_social) {
        this.req_social = req_social;
    }

    public double getReq_gpa() {
        return req_gpa;
    }

    public void setReq_gpa(double req_gpa) {
        this.req_gpa = req_gpa;
    }

    public int getMin_age() {
        return min_age;
    }

    public void setMin_age(int min_age) {
        this.min_age = min_age;
    }

    public int getMax_age() {
        return max_age;
    }

    public void setMax_age(int max_age) {
        this.max_age = max_age;
    }

    public int getReq_independence() {
        return req_independence;
    }

    public void setReq_independence(int req_independence) {
        this.req_independence = req_independence;
    }

    public int getReq_behavior() {
        return req_behavior;
    }

    public void setReq_behavior(int req_behavior) {
        this.req_behavior = req_behavior;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getInternship_location() {
        return internship_location;
    }

    public void setInternship_location(String internship_location) {
        this.internship_location = internship_location;
    }

    public String getInternship_position() {
        return internship_position;
    }

    public void setInternship_position(String internship_position) {
        this.internship_position = internship_position;
    }

    public int getReq_motivation() {
        return req_motivation;
    }

    public void setReq_motivation(int req_motivation) {
        this.req_motivation = req_motivation;
    }
}

