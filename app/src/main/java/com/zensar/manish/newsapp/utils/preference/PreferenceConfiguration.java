package com.zensar.manish.newsapp.utils.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.zensar.manish.newsapp.R;

/**
 * This class is used to for a configuration class that holds the preference related to constants and
 * keys.
 */
public class PreferenceConfiguration {
    /******************************************
     Declare member variables
     ******************************************/
    public static final String PREFERENCE_NAME = "news_Prefs";

    /**
     * Call this method to get the singleton instance of {@link PreferenceConfiguration} class object.
     */
    public static SharedPreferences getInstance(Context context) {
        return context.getSharedPreferences(context.getResources().getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    /**
     * Call this method to get the singleton instance of {@link PreferenceConfiguration} class object.
     */
//    public static void clear(Context context) {
//        SharedPreferences.Editor e = context.getSharedPreferences(context.getResources().getString(R.string.app_name), Context.MODE_PRIVATE).edit();
//        e.remove(context.getString(R.string.pref_access_token_key)).commit();
//        e.remove(context.getString(R.string.pref_login_status_key)).apply();
//        e.remove(context.getString(R.string.pref_user_login_model_key)).commit();
//
//        //PreferenceConfiguration.getInstance(this).edit().clear().apply();
//    }

    /**
     * Method to set access token.
     * @param context
     * @param value
     */
    public static void setCountryCodePref(Context context, String value) {
        SharedPreferences.Editor e = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        e.putString(context.getString(R.string.pref_country_code_key), value);
        e.commit();
    }

    /**
     * Method to get access token.
     * @param context
     * @param value
     * @return
     */
    public static String getCountryCodePref(Context context, String value) {
        return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
                .getString(context.getString(R.string.pref_country_code_key), value);
    }








}