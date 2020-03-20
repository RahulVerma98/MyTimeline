package com.example.twitter;


import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(! Python.isStarted())
            Python.start(new AndroidPlatform(this));

        Python py = Python.getInstance();

        PyObject pyf = py.getModule("myscript"); // here we write the python file

        PyObject obj = pyf.callAttr("twitterTl"); // here you should write the definition name

        textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        String message = obj.toString()
                .replace("[", "\n\n")
                .replace(",", "\n\n")
                .replace("]", "\n\n")  //remove the left bracket
                .trim();

        textView.setText(message);
        //textView.setText(obj.toString());

    }






























}