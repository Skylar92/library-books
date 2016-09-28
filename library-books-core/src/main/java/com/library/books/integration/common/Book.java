package com.library.books.integration.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mhalych on 9/28/2016.
 */
public class Book implements Serializable {

    private String title;
    private String author;
    private String code;
    private String description;
    private int year;
    private Date datePublication;
    private float rating;
    private byte[] image;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public float getRating() {
        return rating;
    }

    public byte[] getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


}
