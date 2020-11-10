package com.eltonb.fp.app;

import com.eltonb.fp.model.Student;

public class Utils {
    private Utils() {

    }

    public static void sendNotification(Student s) {
        System.out.println("sending notification email to " + s.email());
    }

    public static void printTranscript(Student s) {
        System.out.println("printing transcript for " + s.name() + " " + s.surname());
    }

    public static void issueHonors(Student s) {
        System.out.println("issuing honors degree for " + s.name() + " " + s.surname() + " [gpa: " + s.gpa() + "]");
    }
}
