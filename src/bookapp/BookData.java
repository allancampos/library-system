/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author allancampos
 */
public class BookData implements BookDataInterface{

    // Load all books from the text file
    /**
     *
     * @return @throws FileNotFoundException
     */
    public ArrayList<Books> loadBookDataFile() throws FileNotFoundException {

        ArrayList<Books> books = new ArrayList<Books>();
        FileInputStream bookDataFile = new FileInputStream("bookdatafile.txt");
        String line;

        try (BufferedReader breader = new BufferedReader(new InputStreamReader(bookDataFile))) {
            line = breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                books.add(new Books(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3])));
                line = breader.readLine();
            }

        } catch (IOException e) {

        }
        return books;
    }

    // Load all readers from the text file
    public ArrayList<Readers> loadReaders() throws FileNotFoundException {

        ArrayList<Readers> readers = new ArrayList<Readers>();
        FileInputStream bookDataFile = new FileInputStream("readersdata.txt");
        String line = "";

        try (BufferedReader breader = new BufferedReader(new InputStreamReader(bookDataFile))) {
            line = breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                readers.add(new Readers(Integer.parseInt(parts[0]), parts[1], parts[2]));
                line = breader.readLine();
            }

        } catch (IOException e) {

        }
        return readers;

    }
    
    
    // 1 - Get a book by title
    public void getBookTitle(ArrayList<Books> book, String title) {
        boolean result = false;
        for (Books bk : book) {
            if (bk.getTitle().contains(title)) {
                System.out.println(bk.toString());
                result = true;

            }
        }

        if (result == false) {
            System.out.println("Title not found.");
        }

    }
    
      // 2 - Get a book by Author
    public void getBookAuthor(ArrayList<Books> book, String author) {
        boolean result = false;
        for (Books bk : book) {
            if (bk.getAuthor().contains(author)) {
                System.out.println(bk.toString());
                result = true;
            }
        }

        if (result == false) {
            System.out.println("Author not found.");
        }

    }

    
    // 3 - sort books by title
     public void sortBooksByTitle(ArrayList<Books> books) {

        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() -1; j++) {
                if ( books.get(j).getTitle().compareTo(books.get(j+1).getTitle())>0 ) {
                    Books b = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, b);
                }
            }
        }
        
        System.out.println(books);
        
    }
    
    // 4 - sort books by Author 
    public void sortBooksByAuthor(ArrayList<Books> books) {

        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() -1; j++) {
                if ( books.get(j).getAuthor().compareTo(books.get(j+1).getAuthor())>0 ) {
                    Books b = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, b);
                }
            }
        }
        
        System.out.println(books);
        
    }
    
   
    // 5- Get a reader by name
    public void getReaderName(ArrayList<Readers> reader, String name) {
        boolean result = false;
        for (Readers rd : reader) {
            if (rd.getName().contains(name)) {
                System.out.println(rd.toString());
                result = true;
            }
        }

        if (result == false) {
            System.out.println("Name not found.");
        }

    }

    // 6 - Get a reader by ID
    public void getReaderId(ArrayList<Readers> reader, int id) {
        boolean result = false;
        for (Readers rd : reader) {
            if (rd.getId() == id) {
                System.out.println(rd.toString());
                result = true;
            }
        }

        if (result == false) {
            System.out.println("ID not found.");
        }

    }
    // 7 - sort readers by name
    public void sortReadersByName(ArrayList<Readers> readers) {

        for (int i = 0; i < readers.size(); i++) {
            for (int j = 0; j < readers.size() -1; j++) {
                if ( readers.get(j).getName().compareTo(readers.get(j+1).getName())>0 ) {
                    Readers r = readers.get(j);
                    readers.set(j, readers.get(j + 1));
                    readers.set(j + 1, r);
                }
            }
        }
        
        System.out.println(readers);
        
    }
    
    // 8 - sort readers by id
    public void sortReadersById(ArrayList<Readers> readers) {

        for (int i = 0; i < readers.size(); i++) {
            for (int j = 0; j < readers.size() -1; j++) {
                if(readers.get(j).getId() > readers.get(j+1).getId()) {
                    Readers r = readers.get(j);
                    readers.set(j, readers.get(j + 1));
                    readers.set(j + 1, r);
                }
            }
        }
        
        System.out.println(readers);
        
    }
    
    // 9 - Register that a reader has borrowed a book
    public  void borrowBook(String[] borrows) throws IOException{
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("borrows.txt", true));
            bw.write(borrows[0] +","+borrows[1]+","+borrows[2]+"\n");
            bw.close();
        }catch(IOException e){
            System.out.println("Error!");
        }
        System.out.println("Book borrowed!");
    }
    // 10 - Register that a reader has returned a book
     public  void returnBook(String[] returns) throws IOException{
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("returns.txt", true));
            bw.write(returns[0] +","+returns[1]+","+returns[2]+"\n");
            bw.close();
        }catch(IOException e){
            System.out.println("Error!");
        }
        System.out.println("Book returned!");
    }
    // 11 - For a specific reader, list  the books that they have borrowed
    public void listBooksBorrowed(int id) throws FileNotFoundException {

        ArrayList<Borrows> bw = new ArrayList<Borrows>();
        ArrayList<Borrows> array = new ArrayList<Borrows>();
        FileInputStream borrowsFile = new FileInputStream("borrows.txt");
        String line = "";

        try (BufferedReader breader = new BufferedReader(new InputStreamReader(borrowsFile))) {
            line = breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                bw.add(new Borrows(Integer.parseInt(parts[0]), parts[1], parts[2]));
                line = breader.readLine();
            }
            
            for(int i = 0; i < bw.size(); i++){
                if( id == bw.get(i).readerId){
                    array.add(bw.get(i));
                }
            }

        } catch (IOException e) {

        }
        System.out.println(array);

    }

}
