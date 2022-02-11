package com.abdul.cogapp2;

public class Student {

    String studentName;
    int age;
    int phoneNum;

    public Student(String studentName, int age, int phoneNum) {
        this.studentName = studentName;
        this.age = age;
        this.phoneNum = phoneNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
}
