package com.example.sundaravadivelm.medicos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contactus extends AppCompatActivity {
    Button submit;
    EditText name, subject, message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void send_click(View v) {
        EditText name = (EditText) findViewById(R.id.editText1);
        EditText subject = (EditText) findViewById(R.id.editText2);
        EditText message = (EditText) findViewById(R.id.editText3);

        if (name.getText().toString().equals(""))
            name.setError("Mandatory field");

        else if (subject.getText().toString().equals(""))
            subject.setError("Mandatory field");
        else if (message.getText().toString().equals(""))
            message.setError("Mandatory field");
        else {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:"));
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"madhu.miley@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            i.putExtra(Intent.EXTRA_TEXT, "Dear Madhu, \n" + message.getText().toString() + "\n regards, " + name.getText().toString());
            try {

                startActivity(Intent.createChooser(i, "send mail"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this, "no mail app found", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(this, "unexpected error" + ex.toString(), Toast.LENGTH_SHORT).show();
            }


        }
    }
}
