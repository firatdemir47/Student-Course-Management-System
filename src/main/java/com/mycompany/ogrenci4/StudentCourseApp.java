/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ogrenci4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentCourseApp extends JFrame {

    private StudentList studentList = new StudentList();
    private JTextField studentNameField, courseNameField;
    private JTextArea displayArea;

    public StudentCourseApp() {
        setTitle("Öğrenci ve Ders Yönetimi");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Giriş Paneli
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Öğrenci Adı:"));
        studentNameField = new JTextField();
        inputPanel.add(studentNameField);

        inputPanel.add(new JLabel("Ders Adı:"));
        courseNameField = new JTextField();
        inputPanel.add(courseNameField);

        // Butonlar
        JButton addStudentButton = new JButton("Öğrenci Ekle");
        JButton removeStudentButton = new JButton("Öğrenci Sil");
        JButton addCourseButton = new JButton("Ders Ekle");
        JButton removeCourseButton = new JButton("Ders Sil");
        JButton mostCoursesButton = new JButton("En Fazla Dersi Alan Öğrenci");
        JButton listCoursesButton = new JButton("Dersleri Listele");

        inputPanel.add(addStudentButton);
        inputPanel.add(removeStudentButton);
        inputPanel.add(addCourseButton);
        inputPanel.add(removeCourseButton);
        inputPanel.add(mostCoursesButton);
        inputPanel.add(listCoursesButton);

        // Gösterim Alanı
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Öğrenci Ekleme Butonu
        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = studentNameField.getText();
                if (!studentName.isEmpty()) {
                    studentList.addStudent(studentName);
                    displayArea.append("Öğrenci Eklendi: " + studentName + "\n");
                    studentNameField.setText("");
                } else {
                    displayArea.append("Öğrenci adı boş olamaz!\n");
                }
            }
        });

        // Öğrenci Silme Butonu
        removeStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = studentNameField.getText();
                if (!studentName.isEmpty()) {
                    studentList.removeStudent(studentName);
                    displayArea.append("Öğrenci Silindi: " + studentName + "\n");
                    studentNameField.setText("");
                } else {
                    displayArea.append("Öğrenci adı boş olamaz!\n");
                }
            }
        });

        // Ders Ekleme Butonu
        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = studentNameField.getText();
                String courseName = courseNameField.getText();
                Student student = studentList.findStudent(studentName);

                if (student != null && !courseName.isEmpty()) {
                    student.addCourse(courseName);
                    displayArea.append("Ders Eklendi: " + courseName + " - " + studentName + "\n");
                    courseNameField.setText("");
                } else {
                    displayArea.append("Öğrenci bulunamadı veya ders adı boş.\n");
                }
            }
        });

        // Ders Silme Butonu
        removeCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = studentNameField.getText();
                String courseName = courseNameField.getText();
                Student student = studentList.findStudent(studentName);

                if (student != null && !courseName.isEmpty()) {
                    studentList.removeCourse(studentName, courseName);
                    displayArea.append("Ders Silindi: " + courseName + " - " + studentName + "\n");
                    courseNameField.setText("");
                } else {
                    displayArea.append("Öğrenci bulunamadı veya ders adı boş.\n");
                }
            }
        });

        // En Fazla Dersi Alan Öğrenci Butonu
        mostCoursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student student = studentList.getStudentWithMostCourses();
                if (student != null) {
                    int courseCount = studentList.countCourses(student);
                    displayArea.append("En Fazla Dersi Alan Öğrenci: " + student.studentName + " - " + courseCount + " ders\n");
                } else {
                    displayArea.append("Henüz öğrenci yok.\n");
                }
            }
        });

        // Seçilen Öğrencinin Derslerini Listeleme Butonu
        listCoursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = studentNameField.getText();
                Student student = studentList.findStudent(studentName);
                if (student != null) {
                    String courses = listCourses(student);
                    displayArea.append(studentName + " öğrencisinin dersleri:\n" + courses + "\n");
                } else {
                    displayArea.append("Öğrenci bulunamadı.\n");
                }
            }
        });
    }

    // Belirli bir öğrencinin derslerini listeleyen yardımcı metod
    private String listCourses(Student student) {
        StringBuilder coursesList = new StringBuilder();
        Course currentCourse = student.firstCourse;

        if (currentCourse == null) {
            coursesList.append("Ders yok.");
        } else {
            while (currentCourse != null) {
                coursesList.append("- ").append(currentCourse.courseName).append("\n");
                currentCourse = currentCourse.nextCourse;
            }
        }
        return coursesList.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentCourseApp app = new StudentCourseApp();
            app.setVisible(true);
        });
    }
}
