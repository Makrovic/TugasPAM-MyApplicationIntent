package com.bklndev.myapplicationintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnPindah;
    Button btnPindahData;
    Button btnPindahObject;
    Button btnDial;
    Button btnPindahResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindah = findViewById(R.id.btn_pindah);
        btnPindahData = findViewById(R.id.btn_pindah_data);
        btnPindahObject = findViewById(R.id.btn_pindah_object);
        btnDial = findViewById(R.id.btn_dial);
        btnPindahResult = findViewById(R.id.btn_pindah_result);

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentPindah();
            }
        });

        btnPindahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentPindahData();
            }
        });

        btnPindahObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 10/4/2019
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentDial();
            }
        });

        btnPindahResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 10/4/2019  
            }
        });
    }

    private void intentPindah() {
        Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
        startActivity(moveIntent);
    }

    private void intentPindahData() {
        Intent moveDataIntent = new Intent(MainActivity.this, MoveDataActivity.class);
        moveDataIntent.putExtra("exname", "Barka Satya");
        moveDataIntent.putExtra("email", "barka.satya@amikom.ac.id");
        moveDataIntent.putExtra("status", "active");
        startActivity(moveDataIntent);
    }

    private void intentDial() {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(dialIntent);
    }
}
