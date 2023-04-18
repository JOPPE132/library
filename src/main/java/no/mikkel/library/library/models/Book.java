package no.mikkel.library.library.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {

    private int bid;
    private String name;

    private int price;

    private String description;

    private int productionYear;


    public Book(int bid, String name, int price, String description, int productionYear){
        setBid(bid);
        setName(name);
        setPrice(price);
        setDescription(description);
        setProductionYear(productionYear);
    }

    public Book(){
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public String getDescription(){
        return this.description;
    }

    public int productionYear(){
        return this.productionYear;
    }

    public int getBid(){
        return this.bid;
    }

    public void setBid(int newBid){
        if(isBidValid(newBid)){
            this.bid = newBid;
        }
    }

    public void setName(String newName){
        if(isStringValid(newName)){
            this.name = newName;
        }
    }

    public void setPrice(int newPrice){
        if(isPriceValid(newPrice)){
            this.price = newPrice;
        }
    }

    public void setDescription(String newDescription){
        if(isStringValid(newDescription)){
            this.description = newDescription;
        }
    }

    public void setProductionYear(int newProductionYear){
        if(isProductionYearValid(newProductionYear)){
            this.productionYear = newProductionYear;
        }
    }

    private boolean isStringValid(String s){
        boolean isValid = true;

        Pattern pattern = Pattern.compile("[0123456789~#@*+%{}<>\\[\\]|\"\\_^]"); //All invalid symbols
        Matcher matcher = pattern.matcher(s);

        boolean invalidSymbols = matcher.find();

        if(s.isBlank() || invalidSymbols){
            isValid = false;
        }
        return isValid;
    }

    private boolean isPriceValid(int k){
        boolean isValid = true;

        if(k <= 0 || k > 5000){
            isValid = false;
        }
        return isValid;
    }

    private boolean isBidValid(int bid){
        boolean isvalid = true;

        if(bid < -1){
            isvalid = false;
        }
        return isvalid;
    }

    public boolean isProductionYearValid(int k){
        boolean isValid = true;

        if(k < 0){
            isValid = false;
        }
        return isValid;
    }
}