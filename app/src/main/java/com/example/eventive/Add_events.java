package com.example.eventive;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import DataBase.DBHelper;


import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;




public class Add_events extends Event_edit {


    private ArrayAdapter adapter;
        EditText theFilter;
        DBHelper Hdb;
       Event_edit eve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        //


        eve = new Event_edit();

        populateListview();
        listViewItemLongClick();
       eventlistViewItemclick();




        }

        //new part




    private void populateListview(){

        ListView evenlist = findViewById(R.id.eventList);
        Hdb = new DBHelper(this);

        //

       ArrayList<String> HList = new ArrayList<>();
        Cursor data = Hdb.getListEvents();

        if (data.getCount() == 0) {

            Toast.makeText(Add_events.this, "event list is empty", Toast.LENGTH_LONG).show();
        }else
            while (data.moveToNext()) {

                HList.add(data.getString(1));
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HList);

                evenlist.setAdapter(adapter);



                theFilter = findViewById(R.id.Esearch);

                theFilter.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        (Add_events.this).adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });


            }

    }

    //delete

        private void listViewItemLongClick() {


            final ListView evenlist = findViewById(R.id.eventList);

            evenlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                 public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, final long id) {

                    AlertDialog dail = new AlertDialog.Builder(Add_events.this)
                            .setTitle("delete task?")
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    try {


                                        Hdb.deleteRow(id);
                                        evenlist.deferNotifyDataSetChanged();
                                        populateListview();
                                        Toast.makeText(Add_events.this, "deleted successfully", Toast.LENGTH_LONG).show();
                                    }
                                    catch (Exception e){
                                        Log.e("error", e.getMessage());
                                    }



                                }
                            })

                            .setNegativeButton("NO", null)
                            .create();
                    dail.show();

                    return true;
                }
            });

        }

        public void onClick_deleteall(View view){



        Hdb.deleteAll();

            Intent intent = new Intent(this,Add_events.class);
            startActivity(intent);


    }




                    //delete

            ///update





        private void eventlistViewItemclick(){

                final ListView evenlist = findViewById(R.id.eventList);
                evenlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {



                            //eve.updatevent(id);
                            viewevents(id);


                            Intent intent = new Intent(Add_events.this, Event_edit.class);
                            startActivity(intent);



                       // Hdb.updaterowevnt(id,username,date,loication,notes);


                    }
                });

            }

            //update




            public void back(View view){
        Intent intent = new Intent(Add_events.this,Home.class);
        startActivity(intent);
    }

    public void addEvents(View view){
        Intent intent = new Intent(Add_events.this,event_details.class);
        startActivity(intent);
    }


}
