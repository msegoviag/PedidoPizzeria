package com.example.pedidopizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class Registro extends AppCompatActivity {

    TextView nombre;
    TextView telefono;
    TextView direccion;
    TextView textViewDirec;
    Spinner tipoEntrega;
    Usuario cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre = findViewById(R.id.tvNombre);
        telefono = findViewById(R.id.tvTelefono);
        direccion = findViewById(R.id.tvdireccion);
        tipoEntrega = (Spinner) findViewById(R.id.spinnerRecogida);
        textViewDirec = findViewById(R.id.textViewDirec);

        tipoEntrega.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getAdapter().getItem(position).toString().equals("A Domicilio")) {
                    textViewDirec.setVisibility(View.VISIBLE);
                    direccion.setVisibility(View.VISIBLE);
                } else if (parent.getAdapter().getItem(position).toString().equals("Establecimiento")) {
                    textViewDirec.setVisibility(View.INVISIBLE);
                    direccion.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void volverPantallaPrincipal(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void continuarElegirPizza(View view) {

        if (nombre.getText().toString().isEmpty() || telefono.getText().toString().isEmpty() || tipoEntrega.getSelectedItem().toString().isEmpty() || (direccion.isShown() && direccion.getText().toString().isEmpty())) {
            Toast.makeText(this, "¡Hay campos obligatorios sin rellenar!", Toast.LENGTH_LONG).show();
        } else {
            cliente = new Usuario(nombre.getText().toString().trim(), Integer.parseInt(telefono.getText().toString().trim()), direccion.getText().toString().trim(), tipoEntrega.getSelectedItem().toString());
            Intent intent = new Intent(this, ElegirPizza.class);
            Bundle extras = new Bundle();
            extras.putSerializable("cliente", cliente);
            intent.putExtras(extras);
            startActivity(intent);
        }


    }
}