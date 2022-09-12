package com.kasimkartal866.mybookmedia;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.core.view.accessibility.AccessibilityEventCompat;

public class MyPref {
    private static MyPref instance;
    Context context = App.getContext();
    private static final String PREF_USER_NAME = "username";

    private SharedPreferences pref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    private SharedPreferences.Editor editor = pref.edit();

    public static MyPref getInstance() {
        if (instance == null)
            instance = new MyPref();
        return instance;
    }

    public void saveUserName(String userName) {
        editor.putString(PREF_USER_NAME, userName).apply();
    }

    public String getUserName() {
        return pref.getString(PREF_USER_NAME, "");
    }

    public void clearUserDate() {
        editor.putString(PREF_USER_NAME, "").apply();
    }

}
