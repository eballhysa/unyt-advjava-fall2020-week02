package com.eltonb.fp.app.manually.predicates;

import com.eltonb.fp.model.Gender;
import com.eltonb.fp.model.Student;

public class StudentCheckerByLevel implements StudentChecker {
    private final Student.Level level;

    public StudentCheckerByLevel(Student.Level level) {
        this.level = level;
    }

    @Override
    public boolean check(Student s) {
        return this.level.equals(s.getLevel());
    }
}
