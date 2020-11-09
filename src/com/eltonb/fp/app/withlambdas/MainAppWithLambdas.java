package com.eltonb.fp.app.withlambdas;

import com.eltonb.fp.app.Utils;
import com.eltonb.fp.data.impl.StudentRepositoryFromFileImpl;
import com.eltonb.fp.data.interfaces.StudentRepository;
import com.eltonb.fp.model.Gender;
import com.eltonb.fp.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MainAppWithLambdas {

    private final StudentRepository studentRepository;

    public MainAppWithLambdas() {
        studentRepository = new StudentRepositoryFromFileImpl();
    }

    public static void main(String[] args) {
        try {
            MainAppWithLambdas app = new MainAppWithLambdas();
            app.go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void go() {
        List<Student> students = studentRepository.getAll();
        printTranscriptForFemaleUndergrads(students);
        sendNotifToCSStudentsInCreditRangeSortedByGpa(students, 2.00, 2.50);
        issueHonorsToActiveStudents(students);
    }

    private void sendNotifToCSStudentsInCreditRangeSortedByGpa(List<Student> students, double lo, double hi) {
        students.stream()
                .filter(s -> "CS".equals(s.getDepartment()))
                .filter(s -> s.getGpa() >= lo)
                .filter(s -> s.getGpa() <= hi)
                .sorted(Comparator.comparingDouble(Student::getGpa))
                .forEach(Utils::sendNotification);
    }

    private void printTranscriptForFemaleUndergrads(List<Student> students) {
        students.stream()
                .filter(s -> s.getGender() == Gender.FEMALE)
                .filter(s -> s.getLevel() == Student.Level.UNDERGRAD)
                .forEach(Utils::printTranscript);
    }

    private void issueHonorsToActiveStudents(List<Student> students) {
        students.stream()
                .filter(not(Student::isGraduated))
                .filter(s -> s.getGpa() >= 3.5)
                .forEach(Utils::issueHonors);
    }

    private <T> Predicate<T> not(Predicate<T> predicate) {
        return predicate.negate();
    }


}
