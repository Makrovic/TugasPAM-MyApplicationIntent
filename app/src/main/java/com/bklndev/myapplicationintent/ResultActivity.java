package com.bklndev.myapplicationintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set string result menjadi "berhasil"
        String result = "Berhasil";

        Intent returnIntent = getIntent();
        //mengembalikan data result ke main activity
        returnIntent.putExtra("result",result);
        setResult(RESULT_OK,returnIntent);
        finish(); //finish untuk mengakhiri activity
    }
}
