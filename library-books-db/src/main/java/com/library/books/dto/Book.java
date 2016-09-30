package com.library.books.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@Column(name = "code", nullable = false, length = 64, updatable = false)
	private String code;
	@Column(name = "title", nullable = false, length = 128)
	private String title;
	@Column(name = "author", nullable = false, length = 128)
	private String author;
	@Column(name = "description", nullable = true, length = 1024)
	private String description;
	@Column(name = "date_release", nullable = false)
	private Date dateRelease;
	@Column(name = "date_publication", nullable = false)
	private Date datePublication;
	@Column(name = "rating")
	private float rating;
	@Column(name="image")
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

	public Date getDateRelease() {
		return dateRelease;
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

	public void setYear(Date dateRelease) {
		this.dateRelease = dateRelease;
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
