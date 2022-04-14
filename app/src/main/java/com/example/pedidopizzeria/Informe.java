package com.example.pedidopizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Informe extends AppCompatActivity {

    ListView listaPedidosFinal;
    ArrayList<String> listaInformacion;
    ArrayList<Pedido> listaPedido;
    List<Item> itemsBebidas;
    List<Item> itemsPizzas;
    Usuario miCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        itemsBebidas = (List<Item>) bundle.getSerializable("bebidas");
        itemsPizzas = (List<Item>) bundle.getSerializable("pizzas");
        miCliente = (Usuario) bundle.get("cliente");

        listaPedidosFinal = (ListView) findViewById(R.id.listaPedidosFinal);
        obtenerPedido();
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.listview_personalizado, listaInformacion);
        listaPedidosFinal.setAdapter(adaptador);

    }

    public void obtenerPedido() {
        listaInformacion = new ArrayList<>();
        double subTotalBebidas = 0;
        double subTotalPizzas = 0;

        if (miCliente.getRecogida().equals("A Domicilio")) {
            listaInformacion.add("Cliente: " + miCliente.getNombreUsuario() + "\n" + "Teléfono: " + miCliente.getTelefono() + "\n" + "Dirección: " + miCliente.getDireccion());
        }

        for (Item bebidas : itemsBebidas) {
            listaInformacion.add("Productos: " + bebidas.getNombre() + "\n" + "Cantidad: " + bebidas.getCantidad() + "\n" + "Precio Unitario: " + bebidas.getPrecio() + " €" + "\n" + "SUBTOTAL: " + bebidas.getSubTotal() + " €");
            subTotalBebidas += bebidas.getSubTotal();
        }

        for (Item pizzas : itemsPizzas) {
            listaInformacion.add("Productos: " + pizzas.getNombre() + "\n" + "Cantidad: " + pizzas.getCantidad() + "\n" + "Precio Unitario: " + pizzas.getPrecio() + " €" + "\n" + "SUBTOTAL: " + pizzas.getSubTotal() + " €");
            subTotalPizzas += pizzas.getSubTotal();
        }

        if (miCliente.getRecogida().equals("A Domicilio")) {
            listaInformacion.add("Precio entrega domicilio: 2€ ");
            listaInformacion.add("\n" + "TOTAL: " + (subTotalBebidas + subTotalPizzas + 2 + " €"));
        } else {
            listaInformacion.add("\n" + "TOTAL: " + (subTotalBebidas + subTotalPizzas + " €"));
        }

        Toast.makeText(this, "PEDIDO REALIZADO CON ÉXITO", Toast.LENGTH_LONG).show();

    }

    public void volverAtras(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}