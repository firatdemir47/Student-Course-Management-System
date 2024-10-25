/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ogrenci4;

/**
 *
 * @author firat
 */
public class StudentList {

    Student firstStudent; // Listedeki ilk öğrenciyi gösterir

    public void addStudent(String studentName) {
        Student newStudent = new Student(studentName);
        if (firstStudent == null) {
            firstStudent = newStudent;
        } else {
            Student temp = firstStudent;
            while (temp.nextStudent != null) {
                temp = temp.nextStudent;
            }
            temp.nextStudent = newStudent;
        }
    }

    public void removeStudent(String studentName) {
        if (firstStudent == null) {
            return;
        }

        if (firstStudent.studentName.equals(studentName)) {
            firstStudent = firstStudent.nextStudent;
            return;
        }

        Student temp = firstStudent;
        while (temp.nextStudent != null && !temp.nextStudent.studentName.equals(studentName)) {
            temp = temp.nextStudent;
        }

        if (temp.nextStudent != null) {
            temp.nextStudent = temp.nextStudent.nextStudent;
        }
    }

    public Student findStudent(String studentName) {
        Student temp = firstStudent;
        while (temp != null) {
            if (temp.studentName.equals(studentName)) {
                return temp;
            }
            temp = temp.nextStudent;
        }
        return null;
    }

    public void removeCourse(String studentName, String courseName) {
        Student student = findStudent(studentName);
        if (student == null) {
            return;
        }

        Course currentCourse = student.firstCourse;
        Course previousCourse = null;

        // İlk dersi silme durumu
        if (currentCourse != null && currentCourse.courseName.equals(courseName)) {
            student.firstCourse = currentCourse.nextCourse;
            return;
        }

        // Diğer dersleri arayarak silme
        while (currentCourse != null && !currentCourse.courseName.equals(courseName)) {
            previousCourse = currentCourse;
            currentCourse = currentCourse.nextCourse;
        }

        // Ders bulunduysa bağlantıyı güncelle
        if (currentCourse != null) {
            previousCourse.nextCourse = currentCourse.nextCourse;
        }
    }

    public Student getStudentWithMostCourses() {
        Student maxStudent = null;
        int maxCourses = 0;

        Student temp = firstStudent;
        while (temp != null) {
            int courseCount = countCourses(temp);
            if (courseCount > maxCourses) {
                maxCourses = courseCount;
                maxStudent = temp;
            }
            temp = temp.nextStudent;
        }
        return maxStudent;
    }

    int countCourses(Student student) {
        int count = 0;
        Course course = student.firstCourse;
        while (course != null) {
            count++;
            course = course.nextCourse;
        }
        return count;
    }
}
