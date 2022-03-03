package com.example.firebase14t;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ProductosHolder extends FirebaseRecyclerAdapter<
    Productos1, ProductosHolder.productos1Viewholder> {

    public ProductosHolder(
                @NonNull FirebaseRecyclerOptions<Productos1> options)
        {
            super(options);
        }

        // Function to bind the view in Card view(here
        // "person.xml") iwth data in
        // model class(here "person.class")
        @Override
        protected void
        onBindViewHolder(@NonNull productos1Viewholder holder,
        int position, @NonNull Productos1 model)
        {

            // Add fecha from model class (here
            // "Prediccion.class")to appropriate view in Card
            // view (here "item_lista.xml")
            holder.Descripcion.setText(model.getDescripcion());

            // Add cielo from model class (here
            // "Prediccion.class")to appropriate view in Card
            // view (here "item_lista.xml")
            holder.Codigo.setText(model.getCodigo());
            holder.Nombre.setText(model.getNombre());

            // Add humedad from model class (here
            // "Prediccion.class")to appropriate view in Card
            // view (here "item_lista.xml")

            holder.PrecioV.setText("PrecioV: "+String.valueOf(model.getPrecioV())+" ºPV");
            holder.Stock.setText("Stock: "+String.valueOf(model.getStock())+" ºC");
        }

        // Function to tell the class about the Card view (here
        // "person.xml")in
        // which the data will be shown
        @NonNull
        @Override
        public productos1Viewholder
        onCreateViewHolder(@NonNull ViewGroup parent,
        int viewType)
        {
            View view
                    = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_lista, parent, false);
            return new ProductosHolder.productos1Viewholder(view);
        }

        // Sub Class to create references of the views in Crad
        // view (here "person.xml")
        class productos1Viewholder
                extends RecyclerView.ViewHolder {
            TextView Descripcion,Codigo,  Nombre,  PrecioV,  Stock;
            public productos1Viewholder(@NonNull View itemView)
            {
                super(itemView);

                Descripcion= itemView.findViewById(R.id.lblDescripcion);
                Codigo = itemView.findViewById(R.id.lblCodigo);
                Nombre = itemView.findViewById(R.id.lblNombre);
                PrecioV = itemView.findViewById(R.id.lblPrecioV);
                Stock = itemView.findViewById(R.id.lblStock);
            }
        }



    }
