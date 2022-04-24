package com.example.mufta_admin;

public class foodmodelclass {

    String Title, Description, Category, StartingDate, EndingDate, Discount, Location, Image, Upvote, Link,Id, Contact;

    public foodmodelclass(String title, String description, String category, String startingDate, String endingDate, String discount, String location, String upvote, String link, String contact,String id, String image) {
        Title = title;
        Description = description;
        Category = category;
        StartingDate = startingDate;
        EndingDate = endingDate;
        Discount = discount;
        Location = location;
        Upvote = upvote;
        Link = link;
        Id = id;
        Contact = contact;
        Image = image;
    }

    public foodmodelclass(String st1, String st2, String st3, String st4, String st5, String st6, String st7, String st8, String st9) {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getUpvote() {
        return Upvote;
    }

    public void setUpvote(String upvote) {
        Upvote = upvote;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getStartingDate() {
        return StartingDate;
    }

    public void setStartingDate(String startingDate) {
        StartingDate = startingDate;
    }

    public String getEndingDate() {
        return EndingDate;
    }

    public void setEndingDate(String endingDate) {
        EndingDate = endingDate;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
