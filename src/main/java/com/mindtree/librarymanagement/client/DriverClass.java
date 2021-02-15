package com.mindtree.librarymanagement.client;
/*import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.mindtree.librarymanagement.entity.Author;
import com.mindtree.librarymanagement.entity.Book;
import com.mindtree.librarymanagement.exception.LibraryManagementServiceException;
import com.mindtree.librarymanagement.service.AuthorServiceImplementation;
import com.mindtree.librarymanagement.service.BookServiceImplementation;
public class DriverClass {
	static AuthorServiceImplementation authorService=new AuthorServiceImplementation();
	static BookServiceImplementation bookService=new BookServiceImplementation();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
    byte choice=0;
    boolean runLoop=true;
    do {
    	displayMenu();
    	choice=scanByte(input);
    	switch(choice) {
    	case 1:boolean isadded=addBook(input);
    	       if(isadded==true) {System.out.println("inserted sucessfully");}
    	       else {System.out.println("cannot add");}
    	       break;
    	case 2:booksByAuthor(input);
    	       break;
    	case 3:maxBooks();
    		   break;
    	case 4:authorMaxBooksWritten();
    		   break;
    	case 5:deleteBook(input);
    		  break;
    	case 6:deleteAuthor(input);
    		break;
    	case 7:runLoop=false;
    		break;
        default:System.out.println("invalid choice");
    	}
    }while(runLoop);
    input.close();
	}
private static void deleteAuthor(Scanner input) {
	System.out.println("enter the author id");
	input.nextLine();
		int id=scanInt(input);
		try {
			authorService.deleteAuthor(id);
			System.out.println("deleted author and his respective books");
		} catch (LibraryManagementServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
private static void deleteBook(Scanner input) {
	System.out.println("enter the book id");
	input.nextLine();
		int id=scanInt(input);
		try {
			bookService.delete(id);
			System.out.println("deleted sucessfully");
		} catch (LibraryManagementServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
private static void authorMaxBooksWritten() {
		Author author=new Author();
		try {
			author=authorService.maxBooks();
		} catch (LibraryManagementServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println(author);
	}
private static void maxBooks() {
		Book book=new Book();
		try {
			book=bookService.maxBook();
		} catch (LibraryManagementServiceException e) {
		    e.printStackTrace();
		}
		System.out.println(book);
	}
private static void booksByAuthor(Scanner input) {
		// TODO Auto-generated method stub
		System.out.println("enter the author id");
		//input.nextLine();
		int id=input.nextInt();
		List<Book> books=new ArrayList<Book>();
		try {
			books=bookService.getBooks(id);
		} catch (LibraryManagementServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(books.size()==0) {System.out.println("books are not available");}
		else {
		for(int i=0;i<books.size();i++) {
			System.out.println(books.get(i));
		}}
	}

	private static boolean  addBook(Scanner input) {
		System.out.println("enter the book id");
		input.nextLine();
		int id=scanInt(input);
		System.out.println("enter the book name");
		input.nextLine();
		String name=scanString(input);
		System.out.println("enter no of times taken");
		//input.nextLine();
		short times=scanShort(input);
		System.out.println("enter the author id");
		input.nextLine();
		int authorId=scanInt(input);
		Author author=new Author();
		author.setId(authorId);
		Book book =new Book(id,name,times);
		book.setAuthor(author);
		try {
			bookService.addBook(book);
			return true;
		} catch (LibraryManagementServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private static void displayMenu() {
		System.out.println("1.add book 2.books of particular author 3.book with Max Number of times 4.author written max books"
				+ "5.delete book 6.delete author 7.exit");
	}
	private static int scanInt( Scanner input) {
		boolean valid=true;
		int value=0;
		do {
			try {
			value=input.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("enter again");
				valid=false;
				if(input.hasNextLine()) {
					input.nextLine();
				}
			}
		}while(!valid);
		return value;
	}
	private static byte scanByte( Scanner input) {
		boolean valid=true;
		byte value=0;
		do {
			try {
			value=input.nextByte();
			}catch(InputMismatchException e) {
				System.out.println("enter again");
				valid=false;
				if(input.hasNextLine()) {
					input.nextLine();
				}
			}
		}while(!valid);
		return value;
	}
	private static String scanString( Scanner input) {
		boolean valid=true;
		String value="";
		do {
			try {
			value=""+input.nextLine();
			}catch(NullPointerException e) {
				System.out.println("enter again");
				valid=false;
				if(input.hasNextLine()) {
					input.nextLine();
				}
			}
		}while(!valid);
		return value;
	}
	private static short scanShort( Scanner input) {
		boolean valid=true;
		short value=0;
		do {
			try {
			value=input.nextShort();
			}catch(InputMismatchException e) {
				System.out.println("enter again");
				valid=false;
				if(input.hasNextLine()) {
					input.nextLine();
				}
			}
		}while(!valid);
		return value;
	}
}*/
public class DriverClass {
	 public static void main(String[] args) {
		 for(int i=0;i<args.length;i++) {
			System.out.println("hello world");
		 }
	 }
}
