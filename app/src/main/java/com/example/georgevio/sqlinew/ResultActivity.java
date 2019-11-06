package com.example.georgevio.sqlinew;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    //DBHelper mydb;
    DBHelper mydb;
    Empl empl;
    ListView listView;
    ArrayList<Empl> emplList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mydb = new DBHelper(this);
        emplList = new ArrayList<>();
        Cursor data = mydb.getListContents();

        int numRows = data.getCount();
        if (numRows == 0) {
            Toast.makeText(ResultActivity.this, "The Database is empty  :(.", Toast.LENGTH_LONG).show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                empl = new Empl(data.getString(1), data.getString(2), data.getString(3), data.getString(4));
                emplList.add(i, empl);
                System.out.println(data.getString(1) + " " + data.getString(2) + " " + data.getString(3) + " " + data.getString(4));
                System.out.println(emplList.get(i).getName());
                i++;
            }
            // ------------------------------------------------------
//            listView = (ListView) findViewById(R.id.listView);
//            listView.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View view) {
//                                                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
//                                                a_builder.setMessage("you want to delete this app?")
//                                                        .setIcon(android.R.drawable.ic_media_previous)
//                                                        .setCancelable(false)
//                                                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
//                                                            @Override
//                                                            public void onClick(DialogInterface dialogInterface, int i) {
//                                                                finish();
//                                                            }
//                                                        })
//                                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                                                            @Override
//                                                            public void onClick(DialogInterface dialog, int i) {
//                                                                dialog.cancel();
//                                                            }
//                                                        });
//                                                AlertDialog alert = a_builder.create();
//                                                alert.setTitle("you");
//                                                alert.show();
//                                            }
//
//                                        });}



            // -----------------------------------------------------------

            CustomListView emplListalsaedi =  new CustomListView(this,R.layout.listview_row, emplList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(emplListalsaedi);



        }
    }
}
