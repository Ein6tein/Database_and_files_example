package com.example.databasefilesexample.model;

import org.parceler.Parcel;

@Parcel
public class Employee {

    private int mId;
    private String mName;
    private int mAge;
    private int mSalary;
    private String mPicture;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public int getSalary() {
        return mSalary;
    }

    public void setSalary(int salary) {
        mSalary = salary;
    }

    public String getPicture() {
        return mPicture;
    }

    public void setPicture(String picture) {
        mPicture = picture;
    }
}
