/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp;

import java.util.Date;

/**
 *
 * @author allancampos
 */
public class Borrows {
    int readerId;
    private String book;
    private String date;

    public Borrows(int readerId, String book, String date) {
        this.readerId = readerId;
        this.book = book;
        this.date = date;
    }
    
    
    @Override
    public String toString(){
        return "ReaderID: "+readerId+"\n"+"Book: "+book+"\n"+"Date of return: "+date+"\n";
    }
}
