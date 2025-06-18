package model;

import org.bson.Document;

public class Enrollment {
    private String id;
    private Document student; // embedded student
    private Document course;  // embedded course

    public Enrollment(Document student, Document course) {
        this.student = student;
        this.course = course;
    }

    public Document getStudent() {
        return student;
    }

    public Document getCourse() {
        return course;
    }

    public void setStudent(Document student) {
        this.student = student;
    }

    public void setCourse(Document course) {
        this.course = course;
    }
}
