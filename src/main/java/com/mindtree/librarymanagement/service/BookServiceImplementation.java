package com.mindtree.librarymanagement.service;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.librarymanagement.dao.BookDaoImplementation;
import com.mindtree.librarymanagement.entity.Book;
import com.mindtree.librarymanagement.exception.LibraryManagementDaoException;
import com.mindtree.librarymanagement.exception.LibraryManagementServiceException;
public class BookServiceImplementation {
	BookDaoImplementation bookDao=new BookDaoImplementation();
public void addBook(Book book) throws LibraryManagementServiceException {
	try {
		bookDao.addBook(book);
	} catch (LibraryManagementDaoException e) {
		throw new LibraryManagementServiceException(e);
	}
}
public List<Book> getBooks(int id) throws LibraryManagementServiceException{
	List<Book> books=new ArrayList<Book>();
	try {
		books=bookDao.getBooks(id);
	} catch (LibraryManagementDaoException e) {
		throw new LibraryManagementServiceException(e);
	}
	return books;
}
public Book maxBook() throws LibraryManagementServiceException {
	List<Book> books=new ArrayList<Book>();
	try {
		books=bookDao.getBooks();
	} catch (LibraryManagementDaoException e) {
		throw new LibraryManagementServiceException(e);
	}
	Book book=new Book();
	book=books.get(0);
	for(int i=0;i<books.size();i++) {
		if(book.getNoOfTimesTaken()<books.get(i).getNoOfTimesTaken()) {
				book=books.get(i);
			}
		}
	return book;
}
public void delete(int id) throws LibraryManagementServiceException {
	try {
		bookDao.deleteBook(id);
	} catch (LibraryManagementDaoException e) {
		throw new LibraryManagementServiceException(e);
	}
}
}
