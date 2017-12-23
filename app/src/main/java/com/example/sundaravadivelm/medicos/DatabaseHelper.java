package com.example.sundaravadivelm.medicos;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.util.Log;


import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.SQLException;



public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "Dict22222";//the extension may be .sqlite or .db
    private AssetManager assetManager;
    private Context mycontext;
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null,1);
        mycontext=context;
        assetManager = context.getAssets();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("myTag", "This is my message");
        Toast.makeText(mycontext,"create Called",Toast.LENGTH_LONG).show();
        try {
            String[] files = assetManager.list("");

            for(int i=0;i<files.length;i++){
                Toast.makeText(mycontext,files[i],Toast.LENGTH_LONG).show();
                if(files[i].contains("mydic.sql")) {
                    InputStream input = assetManager.open(files[i]);
                    BufferedReader insertReader = new BufferedReader(new InputStreamReader(input));

                    // Iterate through lines (assuming each insert has its own line and theres no other stuff)
                    while (insertReader.ready()) {
                        String insertStmt = insertReader.readLine();
                        db.execSQL(insertStmt);
                    }
                    Toast.makeText(mycontext,"file will be loaded",Toast.LENGTH_LONG).show();
                    insertReader.close();
                    break;
                }
            }

        }
        catch(Exception e)
        {
            Log.e("Dv helpder",e.toString());
            Toast.makeText(mycontext,"error in db helper" + e.toString(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}


