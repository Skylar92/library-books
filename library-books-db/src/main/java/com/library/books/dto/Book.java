package com.library.books.dto;

import java.util.Arrays;
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
	@Column(name = "date_release")
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Book book = (Book) o;

		if (Float.compare(book.rating, rating) != 0) return false;
		if (code != null ? !code.equals(book.code) : book.code != null) return false;
		if (title != null ? !title.equals(book.title) : book.title != null) return false;
		if (author != null ? !author.equals(book.author) : book.author != null) return false;
		if (description != null ? !description.equals(book.description) : book.description != null) return false;
		if (dateRelease != null ? !dateRelease.equals(book.dateRelease) : book.dateRelease != null) return false;
		if (datePublication != null ? !datePublication.equals(book.datePublication) : book.datePublication != null)
			return false;
		if (!Arrays.equals(image, book.image)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = code != null ? code.hashCode() : 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (author != null ? author.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (dateRelease != null ? dateRelease.hashCode() : 0);
		result = 31 * result + (datePublication != null ? datePublication.hashCode() : 0);
		result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
		result = 31 * result + Arrays.hashCode(image);
		return result;
	}

	@Override
	public String toString() {
		return "Book{" +
				"code='" + code + '\'' +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", description='" + description + '\'' +
				", dateRelease=" + dateRelease +
				", datePublication=" + datePublication +
				", rating=" + rating +
				", image=" + Arrays.toString(image) +
				'}';
	}
}
