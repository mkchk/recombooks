package com.recombooks;

public class Recommendation {

    private int recommendationID;

    private int bookID;

    private Book book;

    private String review;

    private Recommender recommender;
    
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRecommendationID() {
        return recommendationID;
    }

    public void setRecommendationID(int recommendationID) {
        this.recommendationID = recommendationID;
    }

    public Recommendation(int recommendationID, int bookID, Book book, String review, Recommender recommender) {
        super();
        this.setRecommendationID(recommendationID);
        this.bookID = bookID;
        this.book = book;
        this.review = review;
        this.recommender = recommender;
    }

    public Recommender getRecommender() {
        return recommender;
    }

    public void setRecommender(Recommender recommender) {
        this.recommender = recommender;
    }

}
