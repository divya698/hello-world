package com.mindtree.librarymanagement.entity;

public class Author {
private int id;
private String authorName;
private boolean isDeleted;
public Author(int id, String authorName, boolean isDeleted) {
	super();
	this.id = id;
	this.authorName = authorName;
	this.isDeleted = isDeleted;
}
public Author() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAuthorName() {
	return authorName;
}
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}
@Override
public String toString() {
	return "Author [id=" + id + ", authorName=" + authorName + "]";
}
public Author(int id, String authorName) {
	super();
	this.id = id;
	this.authorName = authorName;
}
public boolean isDeleted() {
	return isDeleted;
}
public void setDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
}
}
