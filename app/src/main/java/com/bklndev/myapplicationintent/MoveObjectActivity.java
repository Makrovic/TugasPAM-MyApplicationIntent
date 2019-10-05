package com.bklndev.myapplicationintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveObjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_object);

        TextView tvExname = findViewById(R.id.tv_exname);
        TextView tvEmail = findViewById(R.id.tv_email);
        TextView tvStatus = findViewById(R.id.tv_status);

        UserData userData = getIntent().getParcelableExtra("userdata");

        String exname = userData.getExname();
        String email = userData.getEmail();
        String status = userData.getStatus();

        tvExname.setText(exname);
        tvEmail.setText(email);
        tvStatus.setText(status);
    }
}
