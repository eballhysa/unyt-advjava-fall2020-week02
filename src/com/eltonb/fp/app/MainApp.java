package com.eltonb.fp.app;

import com.eltonb.fp.data.StudentRepository;
import com.eltonb.fp.data.StudentRepositoryFromFileImpl;
import com.eltonb.fp.model.Student;
import java.util.List;

public class MainApp {

    private StudentRepository studentRepository;

    public MainApp() {
        studentRepository = new StudentRepositoryFromFileImpl();
    }

    public static void main(String[] args) {
        try {
            MainApp app = new MainApp();
            app.go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void go() {
        List<Student> students = studentRepository.getAll();
        students.forEach(System.out::println);
    }


}
