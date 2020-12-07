package com.tana.newsapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    SharedPreferences mPreferences;
    SharedPreferences.Editor mEditor;
    public static final String APP_KEY = "com.tana.newsapp.AppKey";

    public SessionManager(Context context) {
        mPreferences = context.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
        mEditor.apply();
    }

    public void setLogin(boolean login) {
        mEditor.putBoolean("KEY_LOGIN", login);
        mEditor.commit();
    }

    public boolean getLogin() {
        return mPreferences.getBoolean("KEY_LOGIN", false);
    }

    public void setUsername (String username) {
        mEditor.putString("KEY_EMAIL", username);
        mEditor.commit();
    }

    public String getUsername() {
        return mPreferences.getString("KEY_EMAIL", "");
    }

    // USER INFO

    public void setFirstName(String firstName) {
        mEditor.putString("KEY_FIRST_NAME", firstName);
        mEditor.commit();
    }

    public String getFirstName() {
        return mPreferences.getString("KEY_FIRST_NAME", "");
    }

    public void setLastName(String lastName) {
        mEditor.putString("KEY_LAST_NAME", lastName);
        mEditor.commit();
    }

    public  String getLastName() {
        return mPreferences.getString("KEY_LAST_NAME", "");
    }

    public void setEmail(String email) {
        mEditor.putString("KEY_EMAIL", email);
        mEditor.commit();
    }

    public String getEmail() {
        return mPreferences.getString("KEY_EMAIL", "");
    }

    public void setRegPassword (String password) {
        mEditor.putString("KEY_REG_PASSWORD", password);
        mEditor.commit();
    }

    public String getRegPassword() {
        return mPreferences.getString("KEY_REG_PASSWORD", "");
    }

    public void setGender(String gender) {
        mEditor.putString("KEY_GENDER", gender);
        mEditor.commit();
    }

    public String getGender() {
        return mPreferences.getString("KEY_GENDER", "");
    }
}
