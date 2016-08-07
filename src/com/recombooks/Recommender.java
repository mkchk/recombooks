package com.recombooks;


import com.recombooks.util.IntMap;

public class Recommender {

    private int recommenderID;

    private IntMap<Recommendation> recommendations;

    public IntMap<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(IntMap<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public Recommender(int recommenderID, String name, String description,
            String focus, String imageLink) {
        super();
        this.recommenderID = recommenderID;
        Name = name;
        Description = description;
        Focus = focus;
        ImageLink = imageLink;
        recommendations = new IntMap<Recommendation>();
    }

    public void addRecommendation(Recommendation recommendation){
        recommendations.put(recommendation.getBookID(), recommendation);
    }

    public int getRecommenderID() {
        return recommenderID;
    }

    public void setRecommenderID(int recommenderID) {
        this.recommenderID = recommenderID;
    }

    private String Name;

    private String Description;

    private String Focus;

    private String ImageLink;

    public Recommender(String name, String description, String focus,
            String imageLink) {
        super();
        Name = name;
        Description = description;
        Focus = focus;
        ImageLink = imageLink;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getFocus() {
        return Focus;
    }

    public void setFocus(String focus) {
        Focus = focus;
    }

    public String getImageUrl() {
        return "/images/" +  getName().replace(" ", "-").toLowerCase() + ".jpg";
    }


}
