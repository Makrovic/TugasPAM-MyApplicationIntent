package com.bklndev.myapplicationintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MoveDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_data);

        //instansiasi
        TextView tvExname = findViewById(R.id.tv_exname);
        TextView tvEmail = findViewById(R.id.tv_email);
        TextView tvStatus = findViewById(R.id.tv_status);


        Intent intent = getIntent();

        //menset variabel dengan mengambil data dari intent
        String exname = intent.getStringExtra("exname");
        String email = intent.getStringExtra("email");
        String status = intent.getStringExtra("status");

        tvExname.setText(exname);
        tvEmail.setText(email);
        tvStatus.setText(status);
    }
}
