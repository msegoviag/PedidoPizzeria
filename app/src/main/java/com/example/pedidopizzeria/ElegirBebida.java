package com.example.pedidopizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ElegirBebida extends AppCompatActivity implements Serializable {

    TextView tvContadorCerveza;
    TextView tvContadorCola;
    TextView tvContadorAgua;
    CheckBox mayorEdad;
    Usuario miCliente;
    Item bebida;
    List<Item> bebidas = new ArrayList<>();
    List<Item> pizzas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_bebida);
        tvContadorCerveza = (TextView) findViewById(R.id.tvContadorCerveza);
        tvContadorCola = (TextView) findViewById(R.id.tvContadorCola);
        tvContadorAgua = (TextView) findViewById(R.id.tvContadorAgua);
        mayorEdad = (CheckBox) findViewById(R.id.checkMayorEdad);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        miCliente = (Usuario) bundle.getSerializable("cliente");
        pizzas = (List<Item>) bundle.getSerializable("pizzas");

    }

    public void continuarInformeTotal(View view) {


        /*
        Mandamos a pantalla final
         */
        if (!tvContadorAgua.getText().toString().equals("0")) {
            bebida = new Item("Agua", tvContadorAgua.getText().toString(), 2.00);
            bebidas.add(bebida);
        }

        if (!tvContadorCola.getText().toString().equals("0")) {
            bebida = new Item("Cola", tvContadorCola.getText().toString(), 3.00);
            bebidas.add(bebida);
        }

        if (!tvContadorCerveza.getText().toString().equals("0")) {
            bebida = new Item("Cerveza", tvContadorCerveza.getText().toString(), 3.00);
            bebidas.add(bebida);
        }

        if (bebidas.isEmpty()) {
            Toast.makeText(this, "¡No se ha elegido ninguna bebida!", Toast.LENGTH_LONG).show();
            return;
        }

        if (mayorEdad.isChecked() && (!tvContadorCerveza.getText().toString().equals("0")) || !mayorEdad.isChecked() && tvContadorCerveza.getText().toString().equals("0")) {
            mandarDatosActivity();
            //Toast.makeText(this, "Tienes cerveza en el pedido", Toast.LENGTH_LONG).show();
        } else if (!mayorEdad.isChecked() && (!tvContadorCerveza.getText().toString().equals("0"))) {
            Toast.makeText(this, "No eres mayor de edad para beber cerveza", Toast.LENGTH_SHORT).show();
            return;
        } else {
            mandarDatosActivity();
        }


    }

    private void mandarDatosActivity() {
        Intent intentEnviar = new Intent(this, Informe.class);
        Bundle extrasEnviar = new Bundle();
        extrasEnviar.putSerializable("bebidas", (Serializable) bebidas);
        extrasEnviar.putSerializable("pizzas", (Serializable) pizzas);
        extrasEnviar.putSerializable("cliente", miCliente);
        intentEnviar.putExtras(extrasEnviar);
        startActivity(intentEnviar);
    }

    public void volverPantallaPizza(View view) {
        Intent intent = new Intent(this, ElegirPizza.class);
        startActivity(intent);
    }

    public void addAgua(View view) {
        int getCurrentValue = Integer.parseInt(tvContadorAgua.getText().toString());
        tvContadorAgua.setText(String.valueOf(getCurrentValue + 1));
        tvContadorAgua.setTextColor(Color.parseColor("#43A047"));
    }

    public void addCola(View view) {
        int getCurrentValue = Integer.parseInt(tvContadorCola.getText().toString());
        tvContadorCola.setText(String.valueOf(getCurrentValue + 1));
        tvContadorCola.setTextColor(Color.parseColor("#43A047"));
    }

    public void addCerveza(View view) {
        int getCurrentValue = Integer.parseInt(tvContadorCerveza.getText().toString());
        tvContadorCerveza.setText(String.valueOf(getCurrentValue + 1));
        tvContadorCerveza.setTextColor(Color.parseColor("#43A047"));
    }

    public void limpiarValoresBebida(View view) {
        mayorEdad.setChecked(false);
        bebidas.clear();
        tvContadorCerveza.setText(String.valueOf(0));
        tvContadorCola.setText(String.valueOf(0));
        tvContadorAgua.setText(String.valueOf(0));

    }


}