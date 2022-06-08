package by.itac.mylibrary.entity;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
	private int id;
	private String author;
	private String title;
	private int year;
	

	public Book(int id, String author, String title, int year) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.year = year;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id, author, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Book book = (Book) obj;
		return id == book.id && year == book.year && Objects.equals(author, book.author)
				&& Objects.equals(title, book.title);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", year=" + year + "]";
	}
}
