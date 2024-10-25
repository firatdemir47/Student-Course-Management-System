/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ogrenci4;

public class Course {

    String courseName;
    Course nextCourse; // Tek yönlü bağlantı için sonraki dersi gösterir

    public Course(String courseName) {
        this.courseName = courseName;
        this.nextCourse = null;
    }

}

class Student {

    String studentName;
    Course firstCourse; // Öğrencinin ilk dersini gösterir
    Student nextStudent; // Bir sonraki öğrenciyi gösterir

    public Student(String studentName) {
        this.studentName = studentName;
        this.firstCourse = null;
        this.nextStudent = null;
    }

    public void addCourse(String courseName) {
        Course newCourse = new Course(courseName);
        if (firstCourse == null) {
            firstCourse = newCourse;
        } else {
            Course temp = firstCourse;
            while (temp.nextCourse != null) {
                temp = temp.nextCourse;
            }
            temp.nextCourse = newCourse;
        }
    }
}
