package com.kasimkartal866.mybookmedia;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "users")
public class User {
    @PrimaryKey (autoGenerate = true)
    Integer id;

    @ColumnInfo (name = "bookName")
    String bookName;

    @ColumnInfo (name = "explanation")
    String explanation;

    public User() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @ColumnInfo (name = "authorName")
    String authorName;


    @ColumnInfo (name = "email")
    String email;

    @ColumnInfo (name = "phone")
    String phone;

    @ColumnInfo (name = "password")
    String password;

    @ColumnInfo (name = "password2")
    String password2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public int bookName() {
        return 0;
    }
}