package com.example.rober.tresactividades;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        int opcion1 = 1234;
        int opcion2 = 1235;
// para crear los menus
        menu.add(0, opcion1, 0, "Opcion1").setIcon(android.R.drawable.ic_popup_sync);
        menu.add(0, opcion2, 0, "Opcion2").setIcon(android.R.drawable.ic_popup_sync);
        return true;
    }
    //..........................................................................
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// callback de una opcion del boton de menu
        if (item.getItemId() == 1234) {
            Toast.makeText(this, "Opcion1", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == 1235) {
            Toast.makeText(this, "Opcion2", Toast.LENGTH_LONG).show();
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
