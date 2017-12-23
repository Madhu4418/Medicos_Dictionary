package com.example.sundaravadivelm.medicos;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;



import android.widget.Toast;

import com.example.sundaravadivelm.medicos.CustomAdapter;
import com.example.sundaravadivelm.medicos.DatabaseHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Dictionary extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    public static ArrayList<DictObjectModel> data;
    private DatabaseHelper db;


    SearchView searchView;
    ArrayList<String> disease;
    ArrayList<String> description;
    ArrayList<String> symptoms;
    ArrayList<String> causes;
    ArrayList<String> diagnosis;
    ArrayList<String> treatment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        data = new ArrayList<DictObjectModel>();
        disease = new ArrayList<String>();
        description = new ArrayList<String>();
        symptoms = new ArrayList<String>();
        causes = new ArrayList<String>();
        diagnosis = new ArrayList<String>();
        treatment = new ArrayList<String>();
       // Toast.makeText(Dictionary.this,"Loading Complete",Toast.LENGTH_LONG).show();
        try{

            setContentView(R.layout.content_dictionary);
            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            recyclerView.setHasFixedSize(true);
            searchView = (SearchView)findViewById(R.id.searchView);
            searchView.setQueryHint("Search Here");
            searchView.setQueryRefinementEnabled(true);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            fetchData();
         }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(Dictionary.this,e.toString(),Toast.LENGTH_LONG).show();
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {return  false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                final ArrayList<DictObjectModel> data = new ArrayList<DictObjectModel>();
                SQLiteDatabase sd = db.getReadableDatabase();


                Cursor cursor = sd.rawQuery("select * from dictionary where disease LIKE \'%" + newText + "%\'" , null);

                while (cursor.moveToNext()) {

                    data.add(new DictObjectModel(cursor.getString(cursor.getColumnIndex("disease")),
                            cursor.getString(cursor.getColumnIndex("description")),
                            cursor.getString(cursor.getColumnIndex("symptoms")),
                            cursor.getString(cursor.getColumnIndex("causes")),
                            cursor.getString(cursor.getColumnIndex("diagnosis")),
                            cursor.getString(cursor.getColumnIndex("treatment"))));
                }

                adapter = new CustomAdapter(data);
                recyclerView.setAdapter(adapter);
                return true;
            }
        });


    }
    public void fetchData() throws SQLException,IOException {


        db=new DatabaseHelper(Dictionary.this);

        SQLiteDatabase sd =  db.getWritableDatabase();
        if(sd==null)
            Toast.makeText(this,"found null",Toast.LENGTH_LONG).show();
        Cursor cursor = sd.rawQuery("select * from dictionary", null);

        while (cursor.moveToNext()) {


            data.add(new DictObjectModel(cursor.getString(cursor.getColumnIndex("disease")),
                    cursor.getString(cursor.getColumnIndex("description")),
                    cursor.getString(cursor.getColumnIndex("symptoms")),
                    cursor.getString(cursor.getColumnIndex("causes")),
                    cursor.getString(cursor.getColumnIndex("diagnosis")),
                    cursor.getString(cursor.getColumnIndex("treatment"))));


        }
        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);

    }

}