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

        //Instansiasi objek penampung untuk button
        // yang telah dibuat di halaman xml main activity
        Button btnPindah = findViewById(R.id.btn_pindah);
        Button btnPindahData = findViewById(R.id.btn_pindah_data);
        Button btnPindahObject = findViewById(R.id.btn_pindah_object);
        Button btnDial = findViewById(R.id.btn_dial);
        Button btnPindahResult = findViewById(R.id.btn_pindah_result);

        //menset event onclick listener pada setiap button
        //di sini setiap button di-set untuk memanggil fungsi yang dibuat di bawah
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

    //fungsi pindah activity dengan basic intent
    //dengan cara meninstansiasi intent baru (moveIntent) yang di dalam parameternya berisi
    //argument context, dan class activity tujuan
    //lalu dijalankan dengan startActivity
    private void intentPindah() {
        Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
        startActivity(moveIntent);
    }

    //fungsi pindah activity dengan passing data
    //menggunakan putExtra() untuk passing data / mengirim data ke activity tujuan
    private void intentPindahData() {
        Intent moveDataIntent = new Intent(MainActivity.this, MoveDataActivity.class);
        moveDataIntent.putExtra("exname", "Barka Satya");
        moveDataIntent.putExtra("email", "barka.satya@amikom.ac.id");
        moveDataIntent.putExtra("status", "active");
        startActivity(moveDataIntent);
    }

    //fungsi pindah activity dengan passing object
    //dibutuhkan satu java class baru (UserData.java) yang mengimplement Parcelable
    //Konsep parcelable memungkinkan activity untuk parcing data berupa object
    //https://developer.android.com/reference/android/os/Parcelable
    private void intentPindahObject() {
        Intent moveObjectIntent = new Intent(MainActivity.this, MoveObjectActivity.class);
        UserData userData = new UserData("Barka Satya", "barka.satya@amikom.ac.id", "active");
        moveObjectIntent.putExtra("userdata", userData);
        startActivity(moveObjectIntent);
    }

    //fungsi pindah activity ke dial number
    private void intentDial() {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(dialIntent);
    }

    //fungsi pindah activity ke ResultActivity.java
    //dengan membawa data berupa result intent dan request code : 1
    //yang nantinya akan dikembalikan lagi ke main activity
    private void intentResult() {
        Intent resultIntent = new Intent(this, ResultActivity.class);
        startActivityForResult(resultIntent, 1);
    }

    //fungsi onActivity result untuk menangkap data dari ResultActivity.java
    //lalu ditampilkan ke textview tvResult
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
