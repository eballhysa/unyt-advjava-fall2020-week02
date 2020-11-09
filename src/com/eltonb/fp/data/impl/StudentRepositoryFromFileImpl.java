package com.eltonb.fp.data.impl;

import com.eltonb.fp.data.interfaces.StudentRepository;
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
        student.setDepartment(data[3]);
        student.setLevel(Student.Level.valueOf(data[4]));
        student.setEmail(data[5]);
        student.setGraduated("YES".equals(data[6]));
        student.setGender(Gender.fromCode(data[7]));
        student.setGpa(Double.parseDouble(data[8]));
        student.setEarnedCredits(Integer.parseInt(data[9]));
        return student;
    }

}
