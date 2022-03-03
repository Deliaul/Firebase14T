package com.example.firebase14t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Persona extends AppCompatActivity {
    private EditText et1, et2, et3, et4;
    private Spinner spinner1;
    private RadioButton rb1, rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        String[] opciones = {"Ecuador", "Bolivia", "Peru", "Venezuela", "Corea"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
    }

    public void guardar(View view) {
        SQLite admin = new SQLite(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String ced = et1.getText().toString();
        String nom = et2.getText().toString();
        String prov = et3.getText().toString();
        String cor = et4.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("cedula", ced);
        registro.put("nombre", nom);
        registro.put("provincia", prov);
        registro.put("correo", cor);
        bd.insert("persona", null, registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        Toast.makeText(this, "Se cargaron los datos de la persona",
                Toast.LENGTH_SHORT).show();
    }

    public void consultaporcedula(View v) {
        SQLite admin = new SQLite(this,
                "administracion", null, 1);
        SQLiteDatabase sqLiteDatabase = admin.getWritableDatabase();
        String ced = et1.getText().toString();
        Cursor fila = sqLiteDatabase.rawQuery(
                "select nombre,provincia,correo from persona where cedula=" + ced, null);
        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
            et4.setText(fila.getString(2));
        } else
            Toast.makeText(this, "No existe una persona  con la edula ingresada ",
                    Toast.LENGTH_SHORT).show();
        sqLiteDatabase.close();
    }

    public void borrarporcodigo(View v) {
        SQLite admin = new SQLite(this,
                "administracion", null, 1);
        SQLiteDatabase sqLiteDatabase = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        int cant = sqLiteDatabase.delete("persona", "cedula=" + cod, null);
        sqLiteDatabase.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");


        if (cant == 1)
            Toast.makeText(this, "Se borró el registro con con la cedula" + cod,
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe una persona  con dicha cedula",
                    Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        SQLite admin = new SQLite(this,
                "administracion", null, 1);
        SQLiteDatabase sqLiteDatabase = admin.getWritableDatabase();
        String ced = et1.getText().toString();
        String nom = et2.getText().toString();
        String prov = et3.getText().toString();
        String cor = et4.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("cedula", ced);
        registro.put("nombre", nom);
        registro.put("provincia", prov);
        registro.put("correo", cor);
        int cant = sqLiteDatabase.update("persona", registro, "cedula=" + ced, null);
        sqLiteDatabase.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe unu perona con la cedula  ingresada",
                    Toast.LENGTH_SHORT).show();
    }




}