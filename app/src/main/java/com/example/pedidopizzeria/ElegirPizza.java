package com.example.pedidopizzeria;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ElegirPizza extends AppCompatActivity {

    TextView tvCuatroQuesos;
    TextView tvBarbacoa;
    TextView tvMediterranea;
    TextView tvCarbonara;
    Usuario miCliente;
    Item pizza;
    List<Item> pizzas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_pizza);
        tvCuatroQuesos = (TextView) findViewById(R.id.tvContador4Quesos);
        tvBarbacoa = (TextView) findViewById(R.id.tvContadorBarbacoa);
        tvMediterranea = (TextView) findViewById(R.id.tvContadorMediterranea);
        tvCarbonara = (TextView) findViewById(R.id.tvContadorCarbonara);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        miCliente = (Usuario) bundle.getSerializable("cliente");

    }

    public void volverRegistro(View view) {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }

    public void continuarElegirBebida(View view) {


        if (!tvBarbacoa.getText().toString().equals("0")) {
            pizza = new Item("Pizza Barbacoa", tvBarbacoa.getText().toString(), 9.00);
            pizzas.add(pizza);
        }

        if (!tvMediterranea.getText().toString().equals("0")) {
            pizza = new Item("Pizza Mediterranea", tvMediterranea.getText().toString(), 8.00);
            pizzas.add(pizza);
        }

        if (!tvCuatroQuesos.getText().toString().equals("0")) {
            pizza = new Item("Pizza 4 Quesos", tvCuatroQuesos.getText().toString(), 7.00);
            pizzas.add(pizza);
        }

        if (!tvCarbonara.getText().toString().equals("0")) {
            pizza = new Item("Pizza Carbonara", tvCarbonara.getText().toString(), 8.00);
            pizzas.add(pizza);
        }

        if (pizzas.isEmpty()) {
            Toast.makeText(this, "¡No se ha elegido ninguna pizza!", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, ElegirBebida.class);
        Bundle extras = new Bundle();
        extras.putSerializable("cliente", miCliente);
        extras.putSerializable("pizzas", (Serializable) pizzas);
        intent.putExtras(extras);
        startActivity(intent);
    }


    public void addCuatroQuesos(View view) {

        int getCurrentValue = Integer.parseInt(tvCuatroQuesos.getText().toString());
        tvCuatroQuesos.setText(String.valueOf(getCurrentValue + 1));
        tvCuatroQuesos.setTextColor(Color.parseColor("#43A047"));

    }

    public void addBarbacoaPizza(View view) {
        int getCurrentValue = Integer.parseInt(tvBarbacoa.getText().toString());
        tvBarbacoa.setText(String.valueOf(getCurrentValue + 1));
        tvBarbacoa.setTextColor(Color.parseColor("#43A047"));
    }

    public void addMediterranea(View view) {
        int getCurrentValue = Integer.parseInt(tvMediterranea.getText().toString());
        tvMediterranea.setText(String.valueOf(getCurrentValue + 1));
        tvMediterranea.setTextColor(Color.parseColor("#43A047"));

    }

    public void addCarbonara(View view) {
        int getCurrentValue = Integer.parseInt(tvCarbonara.getText().toString());
        tvCarbonara.setText(String.valueOf(getCurrentValue + 1));
        tvCarbonara.setTextColor(Color.parseColor("#43A047"));

    }

    public void limpiarValores(View view) {
        pizzas.clear();
        tvCarbonara.setText(String.valueOf(0));
        tvBarbacoa.setText(String.valueOf(0));
        tvCuatroQuesos.setText(String.valueOf(0));
        tvMediterranea.setText(String.valueOf(0));
    }
}