package com.example.rober.tresactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        //...............................codigo de los apuntes pg54
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  //creador de menus
        int opcion1 = 1234;         //identificacion de las opciones
        int opcion2 = 1235;
            // para crear los menus
        menu.add(0, opcion1, 0, "Colores").setIcon(android.R.drawable.ic_popup_sync);       //opciones add
        menu.add(0, opcion2, 0, "Imagenes").setIcon(android.R.drawable.ic_popup_sync);
        return true;
    }
    //..........................................................................
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            // callback de una opcion del boton de menu

        if (item.getItemId() == 1234) {                                 //si pulsamos una opcion del menu
            Toast.makeText(this, "Colores", Toast.LENGTH_LONG).show();

            //---------- IR A OTRA ACTIVITY (Activity2)
            Intent intencion1 = new Intent(MainActivity.this, Activity2.class);
            intencion1.putExtra("VengoDe","MainActivity");
            MainActivity.super.startActivity(intencion1);
            //---------

        } else if (item.getItemId() == 1235) {                          //si pulsamos la otra opcion del menu
            Toast.makeText(this, "Imagenes", Toast.LENGTH_LONG).show();

            //---------- IR A OTRA ACTIVITY (Activity3)
            Intent intencion2 = new Intent(MainActivity.this, Activity3.class);
            intencion2.putExtra("VengoDe","MainActivity");
            MainActivity.super.startActivity(intencion2);
            //---------
        }
        return false;
    }
    //..........................................................................
    @Override
    public void onBackPressed() {
        // deja sin efecto la tecla física BACK (volver)
        return;
    }
}
