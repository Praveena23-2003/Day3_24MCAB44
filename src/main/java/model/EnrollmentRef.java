package model;

import org.bson.types.ObjectId;

public class EnrollmentRef {
    private ObjectId studentId;
    private ObjectId courseId;

    public EnrollmentRef(ObjectId studentId, ObjectId courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public ObjectId getStudentId() {
        return studentId;
    }

    public void setStudentId(ObjectId studentId) {
        this.studentId = studentId;
    }

    public ObjectId getCourseId() {
        return courseId;
    }

    public void setCourseId(ObjectId courseId) {
        this.courseId = courseId;
    }
}
