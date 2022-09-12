package com.kasimkartal866.mybookmedia;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class App extends Application{
    private static UserDatabase userDatabase;
    public static UserDao dao;
    private static SharedPreferences pref;
    private static SharedPreferences.Editor prefEditor;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        dao = userDatabase.userDao();


    }

    public static Context getContext() {
        return context;
    }
}
