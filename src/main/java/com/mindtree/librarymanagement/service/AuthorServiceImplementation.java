package com.mindtree.librarymanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mindtree.librarymanagement.dao.AuthorDaoImplementation;
import com.mindtree.librarymanagement.dao.BookDaoImplementation;
import com.mindtree.librarymanagement.entity.Author;
import com.mindtree.librarymanagement.entity.Book;
import com.mindtree.librarymanagement.exception.LibraryManagementDaoException;
import com.mindtree.librarymanagement.exception.LibraryManagementServiceException;

public class AuthorServiceImplementation {
	BookDaoImplementation bookDao=new BookDaoImplementation();
	AuthorDaoImplementation authorDao=new AuthorDaoImplementation();
	public Author maxBooks() throws LibraryManagementServiceException {
		List<Book> books=new ArrayList<Book>();
		Map<Integer,Integer> authorList=new HashMap<Integer,Integer>(); 
		try {
			books=bookDao.getBooks();
		} catch (LibraryManagementDaoException e) {
			throw new LibraryManagementServiceException(e);
		}
		for(int i=0;i<books.size();i++) {
			//System.out.println(books.get(i));
			int count=0;
			if(books.get(i).getAuthor().getId()!=0) {
			for(int j=0;j<books.size();j++) {
				if(books.get(i).getId()==books.get(j).getId())
					count++;
			}
			authorList.put(books.get(i).getAuthor().getId(),count);
			}
		}
		//System.out.println(authorList);
		int max=0;
		int id=0;
		for(int i:authorList.keySet()) {
		 if(authorList.get(i)>max) {
			 max=authorList.get(i);id=i;
		 }
	  }
		//System.out.println(id);
		try {
			return authorDao.getAuthor(id);
		} catch (LibraryManagementDaoException e) {
			throw new LibraryManagementServiceException(e);
		}
	}
    public void deleteAuthor(int id) throws LibraryManagementServiceException {
    	try {
			authorDao.deleteAuthor(id);
		} catch (LibraryManagementDaoException e) {
			throw new LibraryManagementServiceException(e);
		}
    }
}
