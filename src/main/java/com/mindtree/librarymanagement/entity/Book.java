package com.mindtree.librarymanagement.entity;
public class Book {
public Book(int id, String name, short noOfTimesTaken) {
		super();
		this.id = id;
		this.name = name;
		this.noOfTimesTaken = noOfTimesTaken;
	}
public Book() {
		super();
	}
@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", noOfTimesTaken=" + noOfTimesTaken + "]"+author.toString();
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getNoOfTimesTaken() {
		return noOfTimesTaken;
	}
	public void setNoOfTimesTaken(short noOfTimesTaken) {
		this.noOfTimesTaken = noOfTimesTaken;
	}
public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
private int id;
private String name;
private short noOfTimesTaken;
private Author author;
private boolean isDeleted;
public Book(int id, String name, short noOfTimesTaken, boolean isDeleted) {
	super();
	this.id = id;
	this.name = name;
	this.noOfTimesTaken = noOfTimesTaken;
	this.isDeleted = isDeleted;
}
}
