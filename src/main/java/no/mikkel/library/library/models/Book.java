package no.mikkel.library.library.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Schema(description = "Represents a book")
@Entity
@Table(name = "book")
public class Book {

    @Id
    @NotNull
    @Column(name = "bid")
    private Integer bid;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "price")
    private int price;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "productionYear")
    private int productionYear;

    @ManyToMany
    @NotNull
    @Column(nullable = false)
    private Set<Author> authors = new HashSet<>();

    /**
     * Constructor for Book
     *
     * @param name book name
     * @param price book price
     * @param description book description
     * @param productionYear book production year
     */
    public Book(String name, int price, String description, int productionYear){
        setName(name);
        setPrice(price);
        setDescription(description);
        setProductionYear(productionYear);
    }

    /**
     * Empty constructor for Book
     */
    public Book(){
    }

    /**
     * Return book id
     *
     * @return book id
     */
    public int getBid(){
        return this.bid;
    }

    /**
     * Return book name
     *
     * @return book name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Return book price
     *
     * @return book price
     */
    public int getPrice(){
        return this.price;
    }

    /**
     * Return book description
     *
     * @return book description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Return book production year
     *
     * @return book production year
     */
    public int getProductionYear(){
        return this.productionYear;
    }

    /**
     * Set a new book id
     *
     * @param bid to update
     */
    public void setBid(int bid){
        if(isBidValid(bid)){
            this.bid = bid;
        }
    }

    /**
     * Set a new book name
     *
     * @param name to update
     */
    public void setName(String name){
        if(isStringValid(name)){
            this.name = name;
        }
    }

    /**
     * Set a new book price
     *
     * @param price to update
     */
    public void setPrice(int price){
        if(isPriceValid(price)){
            this.price = price;
        }
    }

    /**
     * Set a new book description
     *
     * @param description to update
     */
    public void setDescription(String description){
        if(isStringValid(description)){
            this.description = description;
        }
    }

    /**
     * Set a new book production year
     *
     * @param productionYear to update
     */
    public void setProductionYear(int productionYear) {
        if (isProductionYearValid(productionYear)) {
            this.productionYear = productionYear;
        }
    }

    /**
     * Check if a string is valid
     *
     * @param string incoming string to check if valid or not
     * @return true if valid, false if invalid
     */
    private boolean isStringValid(String string){
        boolean isValid = true;

        Pattern pattern = Pattern.compile("[~#@*+%{}<>\\[\\]|\"\\_^]"); //All invalid symbols
        Matcher matcher = pattern.matcher(string);

        boolean invalidSymbols = matcher.find();

        if(string.isBlank() || invalidSymbols){
            isValid = false;
        }
        return isValid;
    }

    /**
     * Check if price is valid
     *
     * @param price incoming price to check if valid or not
     * @return true of valid, false if invalid
     */
    private boolean isPriceValid(int price){
        boolean isValid = true;

        if(price <= 0 || price > 5000){
            isValid = false;
        }
        return isValid;
    }

    /**
     * Check if bid is valid
     *
     * @param bid incoming bid to check if valid or not
     * @return true if valid, false if invalid
     */
    private boolean isBidValid(int bid){
        boolean isvalid = true;

        if(bid < -1){
            isvalid = false;
        }
        return isvalid;
    }

    /**
     * Check if production year is valid
     *
     * @param productionYear incoming productionyear to check if valid or not
     * @return true if valid, false if invalid
     */
    public boolean isProductionYearValid(int productionYear){
        boolean isValid = true;

        if(productionYear < 0){
            isValid = false;
        }
        return isValid;
    }
}