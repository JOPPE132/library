package no.mikkel.library.library.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Schema(description = "Represents an author")
@Entity
@Table(name = "author")
public class Author {

    @Id
    @NotNull
    @Column(name = "aid")
    private Integer aid;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "description")
    private String description;

    @ManyToMany
    @NotNull
    @Column(nullable = false)
    private Set<Book> books = new HashSet<>();

    /**
     * Constructor for Author
     *
     * @param name author name
     */
    public Author(String name){
        setName(name);
    }

    /**
     * Empty constructor for Author
     */
    public Author() {
    }

    /**
     * Returns author id
     *
     * @return author id
     */
    public int getAid(){
        return this.aid;
    }

    /**
     * Returns author name
     *
     * @return author name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns author age
     *
     * @return
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Set a new author name
     *
     * @param name to update
     */
    public void setName(String name){
        if(isStringValid(name)){
            this.name = name;
        }
    }

    /**
     * Set a new author age
     *
     * @param age to update
     */
    public void setAge(int age){
        if(isAgeValid(age)){
            this.age = age;
        }
    }

    /**
     * Check if age is valid or not
     *
     * @param age incoming age to check if valid or not
     * @return true if valid, false if invalid
     */
    private boolean isAgeValid(int age){
        boolean isValid = true;

        if(age <= 0 || age >= 120){
            isValid = false;
        }
        return isValid;
    }

    /**
     * Check if a string is valid
     *
     * @param string incoming string to check if valid or not
     * @return true if valid, false if invalid
     */
    private boolean isStringValid(String string){
        boolean isValid = true;

        Pattern pattern = Pattern.compile("[0123456789~#@*+%{}<>\\[\\]|\"\\_^]"); //All invalid symbols
        Matcher matcher = pattern.matcher(string);

        boolean invalidSymbols = matcher.find();

        if(string.isBlank() || invalidSymbols){
            isValid = false;
        }
        return isValid;
    }
}