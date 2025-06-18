package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.model.Indexes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Step 1: Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("enrollment_db");

        // Step 2: Access collections
        MongoCollection<Document> students = database.getCollection("students");
        MongoCollection<Document> courses = database.getCollection("courses");
        MongoCollection<Document> enrollments = database.getCollection("enrollments"); // ✅ Add this line

        // Step 4: Insert sample students and courses
        Document student1 = new Document("name", "Alice").append("age", 20);
        Document student2 = new Document("name", "Bob").append("age", 21);
        students.insertMany(Arrays.asList(student1, student2));

        Document course1 = new Document("title", "Math").append("credits", 4);
        Document course2 = new Document("title", "Physics").append("credits", 3);
        courses.insertMany(Arrays.asList(course1, course2));

        System.out.println("✅ Sample students and courses inserted successfully.");

        // Step 5: Insert Enrollments
        Document embeddedEnrollment = new Document("type", "embedded")
                .append("student", student1)
                .append("course", course1);
        enrollments.insertOne(embeddedEnrollment);

        Document referencedEnrollment = new Document("type", "referenced")
                .append("studentId", student2.getObjectId("_id"))
                .append("courseId", course2.getObjectId("_id"));
        enrollments.insertOne(referencedEnrollment);

        // Step 6: Query embedded
        FindIterable<Document> embedded = enrollments.find(eq("type", "embedded"));
        for (Document doc : embedded) {
            System.out.println("📦 Embedded: " + doc.toJson());
        }

        // Query referenced (manual join)
        FindIterable<Document> referenced = enrollments.find(eq("type", "referenced"));
        for (Document doc : referenced) {
            ObjectId sid = doc.getObjectId("studentId");
            ObjectId cid = doc.getObjectId("courseId");

            Document student = students.find(eq("_id", sid)).first();
            Document course = courses.find(eq("_id", cid)).first();

            System.out.println("🔗 Referenced: " + student.toJson() + " - " + course.toJson());
        }

        // Step 7: Update student name (only affects referenced)
        students.updateOne(eq("name", "Bob"), set("name", "Robert"));
        System.out.println("✏️ Updated 'Bob' to 'Robert' in students collection.");

        // Step 8: Create index
        students.createIndex(Indexes.ascending("name"));
        System.out.println("📊 Created index on 'name' field in students collection.");
    }
}
