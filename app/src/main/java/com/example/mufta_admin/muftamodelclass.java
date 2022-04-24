package com.example.mufta_admin;

public class muftamodelclass {
    String discountdescription, details, websitename, language, expirydate, timeduration, coursetitle, discountedprice, originalprice, Link, Rid;

    public muftamodelclass(String discountdescription, String websitename, String details, String language, String expirydate, String timeduration, String coursetitle, String discountedprice, String originalprice, String link, String Rid) {
        this.discountdescription = discountdescription;
        this.websitename = websitename;
        this.language = language;
        this.expirydate = expirydate;
        this.timeduration = timeduration;
        this.coursetitle = coursetitle;
        this.discountedprice = discountedprice;
        this.originalprice = originalprice;
        this.Link = link;
        this.details = details;
        this.Rid = Rid;
    }

    public muftamodelclass(String st1, String st2, String st3, String st4, String st5, String st6, String st7) {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getRid() {
        return Rid;
    }

    public void setRid(String rid) {
        Rid = rid;
    }

    public String getDiscountdescription() {
        return discountdescription;
    }

    public void setDiscountdescription(String discountdescription) {
        this.discountdescription = discountdescription;
    }

    public String getWebsitename() {
        return websitename;
    }

    public void setWebsitename(String websitename) {
        this.websitename = websitename;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getTimeduration() {
        return timeduration;
    }

    public void setTimeduration(String timeduration) {
        this.timeduration = timeduration;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public String getDiscountedprice() {
        return discountedprice;
    }

    public void setDiscountedprice(String discountedprice) {
        this.discountedprice = discountedprice;
    }

    public String getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(String originalprice) {
        this.originalprice = originalprice;
    }
}
