/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp;

/**
 *
 * @author allancampos
 */
public class Books {
    private int id = 0;
    private String title;
    private String author;
    private int year;
    
    public Books(int id, String title, String author, int year){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
   

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    
     @Override
    public String toString(){
        return "# BOOK # \nID: "+getId()+", Title: "+getTitle()+", Author: "+getAuthor()+", Year: "+getYear();
    }
    
    
}
