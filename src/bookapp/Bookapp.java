/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author allancampos
 */
public class Bookapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BookData data = new BookData();
        ArrayList<Books> books = data.loadBookDataFile();
        ArrayList<Readers> readers = data.loadReaders();
        Scanner sc = new Scanner(System.in);
       
       do{
           System.out.println("###### BOOK APP MENU ######");
           System.out.println("1 - Search for a specific book by title");
           System.out.println("2 - Search for a specific book by author name");
           System.out.println("3 - List all books by title");
           System.out.println("4 - List all books by author");
           System.out.println("5 - Search for a specific reader by name");
           System.out.println("6 - Search for a specific reader by ID");
           System.out.println("7 - List all readers by name");
           System.out.println("8 - List all readers by ID");
           System.out.println("9 - Register borrow");
           System.out.println("10 - Register return");
           System.out.println("11 - Books borrowed for a specific reader by IDs");
           System.out.println("12 - Exit");
           System.out.println("Option: ");
           
           try{
               int option = Integer.parseInt(sc.nextLine());
               switch(option){
                   case 1:
                       System.out.println("Title: ");
                       String title = sc.nextLine();
                       data.getBookTitle(books, title);
                       break;
                   case 2:
                       System.out.println("Author name: ");
                       String author = sc.nextLine();
                       data.getBookAuthor(books, author);
                       break;
                   case 3:
                       System.out.println("All books by title: \n");
                       data.sortBooksByTitle(books);
                       break;
                   case 4:
                       System.out.println("All books by author: \n");
                       data.sortBooksByAuthor(books);
                       break;
                   case 5:
                       System.out.println("Reader name: ");
                       String reader = sc.nextLine();
                       data.getReaderName(readers, reader);
                       break;
                   case 6:
                       System.out.println("Reader ID: ");
                       String id = sc.nextLine();
                       data.getReaderId(readers, Integer.parseInt(id));
                       break;
                   case 7:
                       System.out.println("All readers by name: \n");
                       data.sortReadersByName(readers);
                       break;
                   case 8:
                       System.out.println("All readers by ID: \n");
                       data.sortReadersById(readers);
                       break;
                   case 9:
                       System.out.println("ReaderID: ");
                       String readerId = sc.nextLine();
                       System.out.println("Book name: ");
                       String book = sc.nextLine();
                       DateTimeFormatter datetf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                       LocalDateTime localdt = LocalDateTime.now();
                       String date = datetf.format(localdt);
                       String [] borrow = {readerId,book,date};
                       data.borrowBook(borrow);
                       break;
                   case 10:
                       System.out.println("ReaderID: ");
                       String readerId2 = sc.nextLine();
                       System.out.println("Book name: ");
                       String bookName = sc.nextLine();
                       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                       LocalDateTime ldt = LocalDateTime.now();
                       String date2 = dtf.format(ldt);
                       String [] returnBook = {readerId2,bookName,date2};
                       data.returnBook(returnBook);
                       break;
                   case 11:
                       System.out.println("ReaderID: ");
                       String rId = sc.nextLine();
                       data.listBooksBorrowed(Integer.parseInt(rId));
                       break;
                   case 12:
                       exit();
                   default:
                       System.out.println("Wrong Option!");
                       break;
                       
               }
           }catch(NumberFormatException e){
               System.out.println(e);
           }
       }while(true);
    }
    
}
