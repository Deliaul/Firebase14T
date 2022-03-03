package com.example.firebase14t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtusu,txtcontra;
    Button ing,reg;
    private Spinner spinner3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtusu=(EditText)findViewById(R.id.txtusu);
        txtcontra=(EditText)findViewById(R.id.txtcontra);
        ing=(Button)findViewById(R.id.ing);
       ing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vusu=txtusu.getText().toString();
                String vcontra=txtcontra.getText().toString();
                if (vusu.equals("admin")&& vcontra.equals("12345")){

                    Intent intent=new Intent(getApplicationContext(),Persona.class);
                    startActivity(intent);
                }else
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña no es correto",Toast.LENGTH_SHORT);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.Persona) {
            Intent i = new Intent(MainActivity.this,Persona.class);
            Toast.makeText(this,"Se seleccionó la  opción de Persona",Toast.LENGTH_LONG).show();
            startActivity(i);
        }
        if (id==R.id.Inventario) {
            Intent i = new Intent(MainActivity.this,Inventario.class);
            Toast.makeText(this,"Se seleccionó la opción de Inventario",Toast.LENGTH_LONG).show();
            startActivity(i);
        }
        if (id==R.id.producto ) {
            Intent i = new Intent(MainActivity.this,IngProducto .class);
            Toast.makeText(this,"Se seleccionó la opción de  Productos", Toast.LENGTH_LONG).show();
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }





























    public void siguiete1(View view) {
        Intent i = new Intent(MainActivity.this,Rigistro.class);
        startActivity(i);
    }

}