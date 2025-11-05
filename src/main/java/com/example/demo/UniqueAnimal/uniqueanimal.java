package com.example.demo.UniqueAnimal;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "uniqueanimal")
public class uniqueanimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 2000)
    private String description;

    private String imageUrl;

    private String summary;

    @CreationTimestamp
    private Date dateAdded;

    private double lifeSpan;

    private String region;

    
    public long getId() {
        return Id;
    }
    
    public uniqueanimal(){
        
    }
    public uniqueanimal(long id, String name, String description, String summary, Date dateAdded, double lifeSpan) {
        Id = id;
        this.name = name;
        this.description = description;
        this.summary = summary;
        this.dateAdded = dateAdded;
        this.lifeSpan = lifeSpan;
    }

    

    public uniqueanimal(String name, String description, String summary, Date dateAdded, double lifeSpan) {
        this.name = name;
        this.description = description;
        this.summary = summary;
        this.dateAdded = dateAdded;
        this.lifeSpan = lifeSpan;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public double getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(double lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
}
