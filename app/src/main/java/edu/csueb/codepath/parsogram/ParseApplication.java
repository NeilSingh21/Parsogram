package edu.csueb.codepath.parsogram;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Register your parse models
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("vT0o3kLtV3f7Ijs1T6mODAs5Yyail2OEBVXmsf7X")
                .clientKey("GuEOEGhyZWPubEacOCB44njxKKrvsILpJKuK6HzT")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
