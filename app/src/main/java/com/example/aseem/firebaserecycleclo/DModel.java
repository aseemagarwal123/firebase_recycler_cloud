package com.example.aseem.firebaserecycleclo;

class DModel {
    public String name_;
    public String age_;

    public DModel() {
    }

    public DModel(String name_, String age_) {
        this.name_ = name_;
        this.age_ = age_;
    }

    public String getName() {
        return name_;
    }

    public void setUserName(String name_) {
        this.name_ = name_;
    }

    public String getAge() {
        return age_;
    }

    public void setUserAge(String age_) {
        this.age_ = age_;
    }
}
