package com.example.firebase14t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Inventario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.Venta) {

            Intent i = new Intent(Inventario.this,Venta.class);

            Toast.makeText(this,"Se seleccionó la  opción de Ventas",Toast.LENGTH_LONG).show();
            startActivity(i);
        }
        if (id==R.id.Compra) {
            Intent i = new Intent(Inventario.this,Compra.class);
            Toast.makeText(this,"Se seleccionó la opción de Compras",Toast.LENGTH_LONG).show();

            startActivity(i);
        }
        if (id==R.id.Listadeproductos ) {
            Intent i = new Intent(Inventario.this,ListaProductos.class);
            Toast.makeText(this,"Se seleccionó la opción de Lista de productos", Toast.LENGTH_LONG).show();
            startActivity(i);
        }
        if (id==R.id.CerrarSesion) {
            Intent i = new Intent(Inventario.this,MainActivity.class);
            Toast.makeText(this,"Se cerrara la cesioon", Toast.LENGTH_LONG).show();
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}