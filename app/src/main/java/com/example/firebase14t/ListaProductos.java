package com.example.firebase14t;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListaProductos extends AppCompatActivity {
    private static final String TAGLOG = "firebase-db";
    Button siguente;

    //FirebaseRecyclerAdapter mAdapter;

    private RecyclerView recyclerView;
    ProductosHolder
            adapter; // Create Object of the Adapter class
    DatabaseReference mbase; // Create object of the
    // Firebase Realtime Database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);




        //Ejemplo con FirebaseUI

        // Create a instance of the database and get
        // its reference
        mbase = FirebaseDatabase.getInstance().getReference().child("Productos");

        recyclerView = findViewById(R.id.lstProducto);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<Productos1> options
                = new FirebaseRecyclerOptions.Builder<Productos1>()
                .setQuery(mbase, Productos1.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new ProductosHolder(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);

    }



    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }



        public void  siguente(View view) {
            Intent i = new Intent(ListaProductos.this,Inventario.class);
            startActivity(i);
        }


}
