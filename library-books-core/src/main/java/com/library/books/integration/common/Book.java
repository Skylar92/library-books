package com.library.books.integration.common;

import java.io.Serializable;
import java.util.Arrays;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (Float.compare(book.rating, rating) != 0) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (code != null ? !code.equals(book.code) : book.code != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (datePublication != null ? !datePublication.equals(book.datePublication) : book.datePublication != null)
            return false;
        return Arrays.equals(image, book.image);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (datePublication != null ? datePublication.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", datePublication=" + datePublication +
                ", rating=" + rating +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
