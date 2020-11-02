/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author allancampos
 */
public class BookData {
    
    
    // Load All Books from the text file
    public static ArrayList<Books> loadBookDataFile() throws FileNotFoundException{
        
        ArrayList<Books> books =  new ArrayList<Books>();
        FileInputStream bookDataFile = new FileInputStream("bookdatafile.txt");
        String line = "";
        
        try(BufferedReader breader = new BufferedReader(new InputStreamReader(bookDataFile))){
            line =  breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
            
            books.add(new Books(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3])));
            System.out.println(line);
            line = breader.readLine();
            }
            
        }catch(IOException e){
            
        }
        return books;
    }
    
    // Load All Readers from the text file
    public ArrayList<Readers> loadReaders() throws FileNotFoundException{
        
        ArrayList<Readers> readers =  new ArrayList<Readers>();
        FileInputStream bookDataFile = new FileInputStream("readersdata.txt");
        String line = "";
        
        try(BufferedReader breader = new BufferedReader(new InputStreamReader(bookDataFile))){
            line =  breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
            
            readers.add(new Readers(Integer.parseInt(parts[0]), parts[1], parts[2]));
            System.out.println(line);
            line = breader.readLine();
            }
            
        }catch(IOException e){
            
        }
        return readers;
     
    }
    
    // Search a book by title
    public void getBookTitle(ArrayList<Books> book, String title){
        boolean result = false; 
        for(Books bk: book){
            if(bk.getTitle().contains(title)){
                System.out.println(bk.toString());
                result = true;
                
            }
        }
        
         if(result == false){
            System.out.println("Title not found.");
        }
        
    }
    
    // Search Book by Author
    public void getBookAuthor(ArrayList<Books> book, String author){
        boolean result = false;
        for(Books bk: book){
            if(bk.getAuthor().contains(author)){
                System.out.println(bk.toString());
                result = true;
            }
        }
        
        if(result == false){
            System.out.println("Author not found.");
        }
        
     
    }
    
}
