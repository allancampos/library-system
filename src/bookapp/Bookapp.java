/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author allancampos
 */
public class Bookapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        BookData books = new BookData();
        ArrayList<Books> book = books.loadBookDataFile();
        
        // Load the books from the file
        //books.loadBookDataFile();
        // Load the readers from the file
        //books.loadReaders();
        
       books.getBookTitle(book, "Game of Thrones");
       books.getBookAuthor(book, "George");
    }
    
}
