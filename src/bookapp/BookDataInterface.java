/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author allancampos
 */
public interface BookDataInterface {
    
    // Load all books from the text file
    public ArrayList<Books> loadBookDataFile() throws FileNotFoundException;
    
    // Load all readers from the text file
    public ArrayList<Readers> loadReaders() throws FileNotFoundException;
    
    // 1 - Get a book by title
    public void getBookTitle(ArrayList<Books> book, String title);
    
    // 2 - Get a book by Author
    public void getBookAuthor(ArrayList<Books> book, String author);
    
    // 3 - sort books by title
     public void sortBooksByTitle(ArrayList<Books> books);
     
     // 4 - sort books by Author 
    public void sortBooksByAuthor(ArrayList<Books> books);
    
    // 5- Get a reader by name
    public void getReaderName(ArrayList<Readers> reader, String name);
    
    // 6 - Get a reader by ID
    public void getReaderId(ArrayList<Readers> reader, int id);
    
    // 7 - sort readers by name
    public void sortReadersByName(ArrayList<Readers> readers);
    
    // 8 - sort readers by id
    public void sortReadersById(ArrayList<Readers> readers);
    
    // 9 - Register that a reader has borrowed a book
    public  void borrowBook(String[] borrows) throws IOException;
    
    // 10 - Register that a reader has returned a book
     public  void returnBook(String[] returns) throws IOException;
     
     // 11 - For a specific reader, list  the books that they have borrowed
    public void listBooksBorrowed(int id) throws FileNotFoundException;   
     
}
