package com.mindtree.librarymanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.librarymanagement.entity.Author;
import com.mindtree.librarymanagement.entity.Book;
import com.mindtree.librarymanagement.exception.ConnectionFailedException;
//import com.mindtree.librarymanagement.exception.ConnectionFailedException;
import com.mindtree.librarymanagement.exception.LibraryManagementDaoException;
//import com.mindtree.librarymanagement.exception.LibraryManagementServiceException;
import com.mindtree.librarymanagement.utility.ConnectionUtility;
public class BookDaoImplementation {
public void addBook(Book book) throws LibraryManagementDaoException {
	String query="INSERT INTO `db`.`book` (`bookId`, `bookName`, `noOfTimesTaken`, `id`) VALUES ('"+book.getId()+"', '"+book.getName()+"', '"+book.getNoOfTimesTaken()+"', '"+book.getAuthor().getId()+"');";
	Connection con=null;PreparedStatement ps=null;
	try {
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(query);
	    ps.execute();
	} catch (SQLException e) {
		throw new LibraryManagementDaoException(e);
	}finally {
		try {
			ConnectionUtility.closeResource(ps);
			ConnectionUtility.closeResource(con);
		} catch (ConnectionFailedException e) {
			throw new LibraryManagementDaoException(e);
		}
		
	}
	}
public List<Book> getBooks(int id) throws LibraryManagementDaoException{
	List<Book> books=new ArrayList<Book>();
	String query="select * from book where id='"+id+"';";
	Connection con=null;PreparedStatement ps=null;ResultSet rs=null;
	try {
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(query);
	    rs=ps.executeQuery();
	    while(rs.next()) {
	    	Book book=new Book(rs.getInt("bookId"),rs.getString("bookName"),rs.getShort("noOfTimesTaken"));
	    	books.add(book);
	    }
	} catch (SQLException e) {
		throw new LibraryManagementDaoException(e);
	}finally {
		try {
			ConnectionUtility.closeResource(rs);
			ConnectionUtility.closeResource(ps);
			ConnectionUtility.closeResource(con);
			
		} catch (ConnectionFailedException e) {
			throw new LibraryManagementDaoException(e);
		}
		
	}
	return books;
}
public List<Book> getBooks() throws LibraryManagementDaoException{
	List<Book> books=new ArrayList<Book>();
	String query="select * from book;";
	Connection con=null;PreparedStatement ps=null;ResultSet rs=null;
	try {
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(query);
	    rs=ps.executeQuery();
	    while(rs.next()) {
	    	Book book=new Book(rs.getInt("bookId"),rs.getString("bookName"),rs.getShort("noOfTimesTaken"));
	    	Author author=new Author();
	    	author.setId(rs.getInt("id"));
	    	book.setAuthor(author);
	    	books.add(book);
	    }
	} catch (SQLException e) {
		throw new LibraryManagementDaoException(e);
	}finally {
		try {
			ConnectionUtility.closeResource(rs);
			ConnectionUtility.closeResource(ps);
			ConnectionUtility.closeResource(con);
			
		} catch (ConnectionFailedException e) {
			throw new LibraryManagementDaoException(e);
		}
		
	}
	return books;
}
public void deleteBook(int id) throws LibraryManagementDaoException {
	String query="delete from book where bookId='"+id+"';";
	Connection con=null;
	PreparedStatement ps=null;
	try {
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(query);
		ps.execute();
	} catch (SQLException e) {
		throw new LibraryManagementDaoException(e);
	}finally {
		try {
		    ConnectionUtility.closeResource(ps);
			ConnectionUtility.closeResource(con);
			
		} catch (ConnectionFailedException e) {
			throw new LibraryManagementDaoException(e);
		}
		
	}
}
}
