package com.example.pedidopizzeria;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /*
    Se infla el menú de la toolbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
    Operaciones que se efectuan al pulsar las opciones del menú desplegable de la toolbar.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.acerca_de) {
            Intent intent = new Intent(this, AcercaDe.class);
            startActivity(intent);
        }
        if (id == R.id.ayuda) {
            Intent intent = new Intent(this, Ayuda.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    /*
    Onclick del botón hacer pedido, ejecuta la acción que efectua el paso a la pantalla de registro
     */
    public void hacerPedido(View view) {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}