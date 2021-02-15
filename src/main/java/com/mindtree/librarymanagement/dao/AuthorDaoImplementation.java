package com.mindtree.librarymanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;


import com.mindtree.librarymanagement.entity.Author;
//import com.mindtree.librarymanagement.entity.Book;
import com.mindtree.librarymanagement.exception.ConnectionFailedException;
import com.mindtree.librarymanagement.exception.LibraryManagementDaoException;
//import com.mindtree.librarymanagement.entity.Author;
//import com.mindtree.librarymanagement.entity.Book;
//import com.mindtree.librarymanagement.exception.LibraryManagementDaoException;
//import com.mindtree.librarymanagement.exception.LibraryManagementServiceException;
import com.mindtree.librarymanagement.utility.ConnectionUtility;

public class AuthorDaoImplementation {
	public void deleteAuthor(int id) throws LibraryManagementDaoException {
		String query="delete from author where id='"+id+"';";
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
    public Author getAuthor(int id) throws LibraryManagementDaoException {
    	String query="select * from author where id='"+id+"';";
    	Connection con=null;PreparedStatement ps=null;ResultSet rs=null;
    	try {
    		con=ConnectionUtility.getConnection();
    		ps=con.prepareStatement(query);
    	    rs=ps.executeQuery();
    	    while(rs.next()) {
    	    	Author author=new Author(rs.getInt("id"),rs.getString("authorName"));
    	    	return author;
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
		return null;
    	
    }
}
