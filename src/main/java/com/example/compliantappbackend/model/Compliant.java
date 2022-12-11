package com.example.compliantappbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "compliants")
public class Compliant {


    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private String compliant;

    public Compliant() {
    }

    public Compliant(int id, int userId, String compliant) {
        this.id = id;
        this.userId = userId;
        this.compliant = compliant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCompliant() {
        return compliant;
    }

    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }
}
