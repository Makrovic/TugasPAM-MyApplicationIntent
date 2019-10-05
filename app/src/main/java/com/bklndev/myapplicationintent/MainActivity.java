package com.bklndev.myapplicationintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPindah = findViewById(R.id.btn_pindah);
        Button btnPindahData = findViewById(R.id.btn_pindah_data);
        Button btnPindahObject = findViewById(R.id.btn_pindah_object);
        Button btnDial = findViewById(R.id.btn_dial);
        Button btnPindahResult = findViewById(R.id.btn_pindah_result);


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
                intentPindahObject();
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
                intentResult();
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

    private void intentPindahObject() {
        Intent moveObjectIntent = new Intent(MainActivity.this, MoveObjectActivity.class);
        UserData userData = new UserData("Barka Satya", "barka.satya@amikom.ac.id", "active");
        moveObjectIntent.putExtra("userdata", userData);
        startActivity(moveObjectIntent);
    }

    private void intentDial() {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(dialIntent);
    }

    private void intentResult() {
        Intent resultIntent = new Intent(this, ResultActivity.class);
        startActivityForResult(resultIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView tvResult = findViewById(R.id.tv_result);

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                tvResult.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                String result = "Gagal";
                tvResult.setText(result);
            }
        }
    }
}
