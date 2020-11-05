package com.eltonb.fp.data;

import com.eltonb.fp.model.Gender;
import com.eltonb.fp.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryFromFileImpl implements StudentRepository {

    @Override
    public List<Student> getAll() {
        try {
            return retrieveStudents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Student> retrieveStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = newStudent(line);
                students.add(student);
            }
        }
        return students;
    }

    private Student newStudent(String dataLine) {
        String[] data = dataLine.split(" ");
        Student student = new Student();
        student.setId(Integer.parseInt(data[0]));
        student.setName(data[1]);
        student.setSurname(data[2]);
        student.setLevel(Student.Level.valueOf(data[3]));
        student.setEmail(data[4]);
        student.setGraduated("YES".equals(data[5]));
        student.setGender(Gender.fromCode(data[6]));
        student.setGpa(Double.parseDouble(data[7]));
        student.setEarnedCredits(Integer.parseInt(data[8]));
        return student;
    }

}
