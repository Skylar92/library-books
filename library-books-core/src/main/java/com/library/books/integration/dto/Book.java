package com.library.books.integration.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by skylar on 19.07.16.
 */
public interface Book extends Serializable {

    /**
     * @return
     */
    String getTitle();

    /**
     * @return
     */
    String getAuthor();

    /**
     * @return
     */
    String getCode();

    /**
     * @return
     */
    String getDescription();

    /**
     * @return
     */
    int getYear();

    /**
     * @return
     */
    Date getDatePublication();

    /**
     * @return
     */
    float getRating();

    /**
     * @return
     */
    byte[] getImage();

    /**
     *
     */
    class DefaultBook implements Book {

        private String title;
        private String author;
        private String code;
        private String description;
        private int year;
        private Date datePublication;
        private float rating;
        private byte[] image;

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getAuthor() {
            return author;
        }

        @Override
        public String getCode() {
            return code;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public int getYear() {
            return year;
        }

        @Override
        public Date getDatePublication() {
            return datePublication;
        }

        @Override
        public float getRating() {
            return rating;
        }

        @Override
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

    /**
     *
     */
     class BookBuilder {

        private DefaultBook defaultBook;

        public static BookBuilder builder() {
            return new BookBuilder();
        }

        public DefaultBook create() {
            return defaultBook;
        }

        public BookBuilder setTitle(String title) {
            this.defaultBook.title = title;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.defaultBook.author = author;
            return this;
        }

        public BookBuilder setCode(String code) {
            this.defaultBook.code = code;
            return this;
        }

        public BookBuilder setDescription(String description) {
            this.defaultBook.description = description;
            return this;
        }

        public BookBuilder setYear(int year) {
            this.defaultBook.year = year;
            return this;
        }

        public BookBuilder setDatePublication(Date datePublication) {
            this.defaultBook.datePublication = datePublication;
            return this;
        }

        public BookBuilder setRating(float rating) {
            this.defaultBook.rating = rating;
            return this;
        }

        public BookBuilder setImage(byte[] image) {
            this.defaultBook.image = image;
            return this;
        }

    }
}
