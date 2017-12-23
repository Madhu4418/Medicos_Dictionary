package com.example.sundaravadivelm.medicos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Indexpage extends AppCompatActivity {
    Button dict ,contact,about,pharmacy,search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexpage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button dict=(Button)findViewById(R.id.button1);
        Button pharmacy=(Button)findViewById(R.id.button5);
        Button search=(Button)findViewById(R.id.button4);
        final Button contact=(Button)findViewById(R.id.button2);
        Button about=(Button)findViewById(R.id.button3);
        dict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1;
                intent1= new Intent(Indexpage.this, Dictionary.class);
                startActivity(intent1);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2;
                intent2=new Intent(Indexpage.this, Contactus.class);
                startActivity(intent2);
            }
        });


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3;
                intent3 = new Intent(Indexpage.this,Aboutapp.class);
                startActivity(intent3);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4;
                intent4 = new Intent(Indexpage.this,Search.class);
                startActivity(intent4);
            }
        });

        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5;
                intent5 = new Intent(Indexpage.this,MapsActivity.class);
                startActivity(intent5);
            }
        });


    }

}
