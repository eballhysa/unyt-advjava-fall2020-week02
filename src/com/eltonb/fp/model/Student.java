package com.eltonb.fp.model;

import java.util.Objects;

public class Student {

    public enum Level {UNDERGRAD, MASTERS, PHD};

    private int id;
    private String name;
    private String surname;
    private Level level;
    private String email;
    private boolean graduated;
    private Gender gender;
    private double gpa;
    private int earnedCredits;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getEarnedCredits() {
        return earnedCredits;
    }

    public void setEarnedCredits(int earnedCredits) {
        this.earnedCredits = earnedCredits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                graduated == student.graduated &&
                Double.compare(student.gpa, gpa) == 0 &&
                earnedCredits == student.earnedCredits &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                level == student.level &&
                Objects.equals(email, student.email) &&
                gender == student.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, level, email, graduated, gender, gpa, earnedCredits);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", level=" + level +
                ", email='" + email + '\'' +
                ", graduated=" + graduated +
                ", gender=" + gender +
                ", gpa=" + gpa +
                ", earnedCredits=" + earnedCredits +
                '}';
    }
}
