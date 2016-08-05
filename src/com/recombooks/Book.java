package com.recombooks;

public class Book {

    private int bookID;
    
    private String title;
    
    private String author;
    
    private String ASIN;
    
    private String largeImageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getASIN() {
        return ASIN;
    }

    public void setASIN(String aSIN) {
        ASIN = aSIN;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    public Book(String title, String author, String aSIN, String largeImageUrl) {
        super();
        this.title = title;
        this.author = author;
        ASIN = aSIN;
        this.largeImageUrl = largeImageUrl;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public Book(int bookID, String title, String author, String aSIN,
            String largeImageUrl) {
        super();
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        ASIN = aSIN;
        this.largeImageUrl = largeImageUrl;
    }


}
