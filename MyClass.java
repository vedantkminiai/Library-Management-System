import java.util.*;
import java.time.LocalTime;
public class MyClass {
public static int sessionCount = 0;//Variable initialised for user sessions

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    Random rand = new Random();
	    
	    //Adding books
	    Book firstBook = new Book("1984", "George Orwell", 1942, 5, LocalTime.now(), true);
	    Book.addBook(firstBook);
	    Book secondBook = new Book("The Maze Runner", "James Dashner", 2009, 5, LocalTime.now(), true);
	    Book.addBook(secondBook);
        Book thirdBook = new Book("The Handmaid's Tale", "Margaret Atwood", 1985, 3, LocalTime.now(), true);
	    Book.addBook(thirdBook);	    
	    Book fourthBook = new Book("The Kiss", "Polly Dunbar", 2020, 4, LocalTime.now(), true);
	    Book.addBook(fourthBook);
	    Book fifthBook = new Book("Fallen", "George Brown", 2007, 2, LocalTime.now(), true);
	    Book.addBook(fifthBook);
	    Book sixthBook = new Book("Diary of a Wimpy Kid", "Jeff Kinney", 2007, 1, LocalTime.now(), true);
	    Book.addBook(sixthBook);
	    Book seventhBook = new Book("The Da Vinci Code", "Dan Brown", 2003, 2, LocalTime.now(), true);
	    Book.addBook(seventhBook);
	    Book eigthBook = new Book("Dreamer My Life on the Edge", "Nazem Kadri", 2020, 1, LocalTime.now(), true);
	    Book.addBook(eigthBook);
	    Book ninthBook = new Book("Angels and Demons", "Dan Brown", 2000, 2, LocalTime.now(), true);
	    Book.addBook(ninthBook);
	    
	    //Adding members
	    Member firstMember = new Member("Srigan", 2007);
	    Member.addMember(firstMember);
	    Member secondMember = new Member("Vedant", 2007);
	    Member.addMember(secondMember);
	    Member mapleLeafsDieHard = new Member("Ali Wadee", 1989);
	    Member.addMember(mapleLeafsDieHard);
	    
	    boolean x = true;
	    LocalTime borrowTime = LocalTime.now();//usage of computer's real time
	    
	    //Main loop running the program
	    while (x) {
	        //Home Page Landing Section
	        System.out.println("\n\tHOME PAGE\n----------------------------");
    		System.out.print("Welcome to the NHSS Library, Would you like to create a membership (1) or log in (2): ");
    		int choice = in.nextInt();
    		//Sign Up Page
    		if (choice==1) {
    		    System.out.println("\n\tSIGN UP PAGE\n----------------------------");
    		    String userName = "";
    		    System.out.print("What is your name?: ");
    		    in.nextLine();
    		    userName = in.nextLine();
    		    while (checkAlpha(userName)) {
    		        System.out.print("\nInput must be all letters.\n");
    		        System.out.print("What is your name?: ");
    		        userName = in.nextLine();
    		    }
    		    int userID = rand.nextInt(1000)+1000;
    		    Member newMember = new Member(userName, userID);
    		    Member.addMember(newMember);
    		    System.out.println("\nCongratulations! You've now created your account and your user ID is " + userID + ". You can now login from the home screen. \n");
    		}
    		//Log In Page
    		else if (choice==2) {
    		    System.out.print("\nWhat is your name?: ");
    		    in.nextLine();
    		    String loginName = in.nextLine();
    		    
    		    System.out.print("What is your user ID?: ");
    		    int loginUserID = in.nextInt();
    		    int memberPosition = Member.findMember(loginName, loginUserID);
    		    if (memberPosition<0) {
    		        System.out.println("User not found");
    		    }
    		    else { 
    		        boolean z = true;
    		        Member loggedIn = Member.returnMember(memberPosition);
    		        sessionCount++;
    		        System.out.print("\nWelcome " + loggedIn.getMemberName() + "!");
    		        
    		        //Selection Loop for Library Operations
    		        while (z) {
        		        System.out.print("\n\n\tMAIN MENU\n----------------------------\n -- Add Book (1)\n -- Search Book (2)\n -- Borrow Book (3)\n -- Return Book (4)\n -- Generate Report (5)\n -- Logout (6)\n----------------------------\nEnter Option: ");
        		        int select = in.nextInt();
    		                
    		                //Add book selection section
    		                if (select==1) {
    		                    System.out.print("\n\tADD BOOK\n----------------------------");
    		                    System.out.print("\nEnter book title: ");
    		                    in.nextLine();
    		                    String bookTitle = in.nextLine();
    		                    System.out.print("Enter book author: ");
    		                    String bookAuthor = in.nextLine();
    		                    System.out.print("Enter book publishing year: ");
    		                    int bookYear = in.nextInt();
    		                    String[] genresDisplay = {"Drama (1)", "Mystery (2)", "Thriller (3)", "Romance (4)", "Science Fiction (5)"}; // usage of arrays 
    		                    System.out.println();
    		                    for (int i=0; i<genresDisplay.length; i++) {
    		                        if (i==4) {
    		                            System.out.print(genresDisplay[i]);
    		                        }
    		                        else {
        		                        System.out.print(genresDisplay[i] + ", ");
    		                        }
    		                    }
    		                    System.out.print("\nSelect book genre: ");
    		                    int bookGenre = in.nextInt();
    		                    Book newBook = new Book(bookTitle, bookAuthor, bookYear, bookGenre, LocalTime.now(), true);
    		                    Book.addBook(newBook);
    		                    System.out.println("\n" + newBook.getTitle() + " has succesfully been added to the library");
    		                }
    		                
    		                //Search book selection section
    		                else if (select==2) {
    		                    System.out.print("\n\tSEARCH BOOK\n----------------------------");
    		                    System.out.print("\n -- Search Title (1)\n -- Search Author (2)\n -- Search Genre (3)\n----------------------------\nEnter Option: ");
    		                    int option = in.nextInt();
    		                    //Search by Title
    		                    if (option==1) {
    		                        System.out.print("\nWhat title would you like to search for?: ");
    		                        in.nextLine();
    		                        String userSearchTitle = in.nextLine();
    		                        ArrayList<Book> titles = Book.findAllTitles(userSearchTitle);
    		                        if (titles.size()>0) {
        		                        System.out.println("\nResults: ");
        		                        for (int i=0; i<titles.size(); i++) {
        		                            System.out.println("Book: " + titles.get(i).getTitle() + ", Author: " + titles.get(i).getAuthor() + ", Year Published: " + titles.get(i).getYear()+ " Genre Number: "+ titles.get(i).getGenre());        		                        
        		                        }
    		                        }
    		                        else {
    		                            System.out.println("There are no results.");
    		                        }
    		                    }
    		                    //Search by Author
    		                    else if (option==2) {
    		                        System.out.print("\nWhat author would you like to search for?: ");
    		                        in.nextLine();
    		                        String userSearchAuthor = in.nextLine();
    		                        ArrayList<Book> authors = Book.findAll(userSearchAuthor);
    		                        if (authors.size()>0) {
        		                        System.out.println("\nResults: ");
        		                        for (int i=0; i<authors.size(); i++) {
        		                            System.out.println("Book: " + authors.get(i).getTitle() + ", Author: " + authors.get(i).getAuthor() + ", Year Published: " + authors.get(i).getYear()+ " Genre Number: "+ authors.get(i).getGenre());
        		                        }
    		                        }
    		                        else {
    		                            System.out.println("\nThere are no results.");
    		                        }
    		                    }
    		                   //Search by Genre
    		                    else if (option==3) {
    		                        String[] genresDisplay = {"Drama (1)", "Mystery (2)", "Thriller (3)", "Romance (4)", "Science Fiction (5)"};
    		                        System.out.println();
        		                    for (int i=0; i<genresDisplay.length; i++) {
        		                        if (i==4) {
        		                            System.out.print(genresDisplay[i]);
        		                        }
        		                        else {
            		                        System.out.print(genresDisplay[i] + ", ");
        		                        }
        		                    }
    		                        System.out.print("\nWhat genre would you like to search for?: ");
    		                        int userSearchGenre = in.nextInt();
    		                        ArrayList<Book> genres = Book.findAll(userSearchGenre);
    		                        if (genres.size()>0) {
        		                        System.out.println("\nResults: ");
        		                        for (int i=0; i<genres.size(); i++) {
        		                            System.out.println("Book: " + genres.get(i).getTitle() + ", Author: " + genres.get(i).getAuthor() + ", Year Published: " + genres.get(i).getYear()+ ", Genre Number: "+ genres.get(i).getGenre());
        		                        }
    		                        }
    		                        else {
    		                            System.out.println("\nThere are no results.");
    		                        }
    		                    }
    		                    else {
    		                        System.out.println("\nIvalid option number\n");
    		                    }
    		                }
    		                //Borrow book selection section
    		                else if (select==3) {
    		                    System.out.print("Every membership is only allowed to borrow 3 books at a time.\n");
    		                    if (loggedIn.getBorrowedBooks().size() >= 3) {
    		                        System.out.println(loggedIn.getMemberName() + ", you already have 3 books taken out and cannot take anymore");
    		                    }
    		                    else {
    		                        System.out.print("\n\tBOOK BORROW\n----------------------------\n");
        		                    System.out.print("What is the book's title: ");
        		                    in.nextLine();
        		                    String searchBookTitle = in.nextLine();
        		                    System.out.print("Who is the book's author: ");
        		                    String searchBookAuthor = in.nextLine();
        		                    System.out.print("What year was the book published: ");
        		                    int searchBookYear = in.nextInt();
        		                    String[] genres = {"Drama (1)", "Mystery (2)", "Thriller (3)", "Romance (4)", "Science Fiction (5)"};
        		                    for (int i=0; i<genres.length; i++) {
        		                        System.out.print(genres[i] + ", ");
        		                    }
        		                    System.out.print("\nWhat is the genre of the book: ");
        		                    int searchBookGenre = in.nextInt();
        		                    int bookPosition = Book.findBook(searchBookTitle, searchBookAuthor, searchBookYear, searchBookGenre);
        		                    if (bookPosition<0) {
        		                        System.out.println("We're sorry, this book does not belong to the NHSS library.");
        		                    }
        		                    else {
        		                        Book searchBook = Book.returnBook(bookPosition);
        		                        if (searchBook.getAvailable()==false) {
        		                            System.out.println("We're sorry, this book is currently taken out by another member right now.");
        		                        }
        		                        else {
        		                            loggedIn.popularGenres(searchBook.getGenre());
		                                    searchBook.changeTime(LocalTime.now());
            		                        loggedIn.borrowBook(searchBook);
            		                        searchBook.setAvailability(false);
            		                        System.out.println("Please return " + searchBook.getTitle() + " to the library in 1 minute. Have fun reading!");
        		                        }
        		                    }
    		                    }
    		                }
    		                
    		                //Return book selection section
    		                else if (select==4) {
    		                    System.out.print("\n\n\tBOOK RETURN\n----------------------------\n");
    		                    System.out.print("Enter book title: ");
    		                    in.nextLine();
    		                    String returnBookTitle = in.nextLine();
    		                    System.out.print("Enter book author: ");
    		                    String returnBookAuthor = in.nextLine();
    		                    System.out.print("Enter book publishing year: ");
    		                    int returnBookYear = in.nextInt();
    		                    String[] genres = {"Drama (1)", "Mystery (2)", "Thriller (3)", "Romance (4)", "Science Fiction (5)"};
    		                    for (int i=0; i<genres.length; i++) {
    		                        System.out.print(genres[i] + ", ");
    		                    }
    		                    System.out.print("\nEnter book genre: ");
    		                    int returnBookGenre = in.nextInt();
    		                    int borrowedBookPosition = loggedIn.findBorrowedBook(returnBookTitle, returnBookAuthor, returnBookYear, returnBookGenre);
    		                    if (borrowedBookPosition<0) {
    		                        System.out.println("We're sorry, you don't have this book borrowed");
    		                    }
    		                    else {
        		                    Book returnBook = loggedIn.returnBorrowedBook(borrowedBookPosition);
        		                    loggedIn.removeBorrowedBook(returnBook);
        		                    returnBook.setAvailability(true);
        		                    loggedIn.returnBookTime(returnBook.getTitle(), returnBook.getTime());
        		                    System.out.println("Thank you for returning " + returnBook.getTitle());
    		                    }
    		                    
    		                }
    		                
    		                //Report selection section
    		                else if (select==5) {
    		                    //Calls appropirate methods located in Report Class
    		                    System.out.print(loggedIn.getUserHistory()); 
    		                    Report.userAverageBooks(loggedIn); 
    		                    System.out.print(Report.findPopularGenre(loggedIn.getDrama(), loggedIn.getMystery(), loggedIn.getThriller(), loggedIn.getRomance(), loggedIn.getSci()));
    		                    //Called in Member.java
    		                    Member.overdueBooks(Member.dueBooks, Member.dueBooksTime);
    		                }
    		                
    		                //Log Out selection section
    		                else if (select==6) {
    		                    System.out.println("\nUser logged out\n");
    		                    z=false;
    		                }
    		                else {
    		                    System.out.println("\nInvalid option number");
    		                }
    		                
    		                
    		        
    		        }
    		    }
    		}
    		else {
    		    System.out.println("\nInvalid option number");
    		}
	    }
		
	}
	
	//appplied onto user name to make sure user doesn't enter a number for name
	public static boolean checkAlpha(String input) {
	    boolean x = true;
	    int i = 0;
	    while (i<input.length() && x) {
	        if (!(Character.isLetter(input.charAt(i)))) {
	            x = false;
	        } 
	        i++;
	    }
	    if (x) {
	        return false;
	    }
	    else {
	        return true;
	    }
	}
	
}