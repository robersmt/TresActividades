package com.example.rober.tresactividades;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private TextView colorR, colorG, colorB;

    private final Activity THIS = this; //una variable privada de un metodo la hacemos general

    final Context context = this;
                                        //En esta activity solamente creamos un menu con tres textos pulsables de los cuales podemos elegir uno de ellos.
                                        // cuando pulsamos uno nos pregunta si queremos elegir ese o no. Una vez elegido desaparece el resto.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //vincular el boton del layaut al de programa
        colorR = (TextView) findViewById(R.id.colorR);              //textos que contiene la funcion OnClick
        colorG = (TextView) findViewById(R.id.colorG);
        colorB = (TextView) findViewById(R.id.colorB);

        //escuchador del boton
        colorR.setOnClickListener(new View.OnClickListener() {
            @Override
            //cuando pulse
            public void onClick(View v) {
                Toast.makeText(THIS, "ROJO_pulsado", Toast.LENGTH_LONG).show();

                //---------que salga el dialogo de Si,No,Cancelar

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set title
                alertDialogBuilder.setTitle("Opción pulsada");

                // set dialog message
                alertDialogBuilder
                        .setMessage("¿Seguro que quieres escoger el ROJO?")
                        .setCancelable(false)
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cuando le doy a si
                                Toast.makeText(THIS, "ROJO_elegido", Toast.LENGTH_LONG).show();
                                //hacer invisible el resto
                                colorG.setVisibility(TextView.INVISIBLE);       //hacer invisible el resto de opciones
                                colorB.setVisibility(TextView.INVISIBLE);

                                dialog.cancel();
                            }
                        })

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cuando le doy a no
                                Toast.makeText(THIS, "Vuelve a elegir", Toast.LENGTH_LONG).show();
                                colorG.setVisibility(TextView.VISIBLE);     //hacer invisible el resto de opciones
                                colorB.setVisibility(TextView.VISIBLE);

                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();


            }
        });

        //escuchador del boton
        colorG.setOnClickListener(new View.OnClickListener() {
            @Override
            //cuando pulse
            public void onClick(View v) {
                Toast.makeText(THIS, "VERDE_pulsado", Toast.LENGTH_LONG).show();
                //---------que salga el dialogo de Si,No,Cancelar

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set title
                alertDialogBuilder.setTitle("Opción pulsada");

                // set dialog message
                alertDialogBuilder
                        .setMessage("¿Seguro que quieres escoger el VERDE?")
                        .setCancelable(false)
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cuando le doy a si
                                Toast.makeText(THIS, "VERDE_elegido", Toast.LENGTH_LONG).show();
                                //hacer invisible el resto
                                colorR.setVisibility(TextView.INVISIBLE);
                                colorB.setVisibility(TextView.INVISIBLE);

                                dialog.cancel();


                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cuando le doy a no
                                Toast.makeText(THIS, "Vuelve a elegir", Toast.LENGTH_LONG).show();
                                colorR.setVisibility(TextView.VISIBLE);
                                colorB.setVisibility(TextView.VISIBLE);
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();


            }
        });

        //escuchador del boton
        colorB.setOnClickListener(new View.OnClickListener() {
            @Override
            //cuando pulse
            public void onClick(View v) {
                Toast.makeText(THIS, "AZUL_pulsado", Toast.LENGTH_LONG).show();
                //---------que salga el dialogo de Si,No,Cancelar

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set title
                alertDialogBuilder.setTitle("Opción pulsada");

                // set dialog message
                alertDialogBuilder
                        .setMessage("¿Seguro que quieres escoger el AZUL?")
                        .setCancelable(false)
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cuando le doy a si
                                Toast.makeText(THIS, "AZUL_elegido", Toast.LENGTH_LONG).show();
                                //hacer invisible el resto
                                colorG.setVisibility(TextView.INVISIBLE);
                                colorR.setVisibility(TextView.INVISIBLE);

                                dialog.cancel();


                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cuando le doy a no
                                Toast.makeText(THIS, "Vuelve a elegir", Toast.LENGTH_LONG).show();
                                dialog.cancel();
                                colorG.setVisibility(TextView.VISIBLE);
                                colorR.setVisibility(TextView.VISIBLE);
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();


            }
        });


    }


}
