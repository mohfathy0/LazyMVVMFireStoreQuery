package com.example.lazymvvmfirestorequery;

public class UsersModel {
    private String FirstName;
    private String LastName;
    private String Email;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public UsersModel() {
    }

    public UsersModel(String firstName, String lastName, String email, int id) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        this.id = id;
    }
}
