package com.kasimkartal866.mybookmedia;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface UserDao {
    @Query("SELECT * FROM users WHERE email =(:email) and password = (:password)")
    User login(String email ,String password);

    @Insert
    void addUser(User user);

    @Delete
    void deleteUser(User user);
}