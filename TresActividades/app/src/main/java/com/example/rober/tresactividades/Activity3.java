package com.example.rober.tresactividades;

import android.app.Activity;
import android.content.Intent;

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class Activity3 extends AppCompatActivity {



    Uri selectedImage = null;
    private static final int SELECT_FILE=1;
    private static final int FOTO_CAMARA=2;

    private ImageButton botonGaleria,botonCamara;
    private final Activity THIS = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        botonCamara= (ImageButton) findViewById(R.id.botonCamara);
        botonGaleria = (ImageButton) findViewById(R.id.botonGaleria);


        //-------Escuchador del boton galeria
        botonGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            //-----cuando se pulse galeria
            public void onClick(View v) {
                Toast.makeText(THIS, "Galeria Pulsado", Toast.LENGTH_LONG).show();


                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Seleccione una imagen"),SELECT_FILE);

            }

        });


            //-------Escuchador del boton camara
        botonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            //-----cuando se pulse camara
            public void onClick(View v) {
                Toast.makeText(THIS, "Camara Pulsado", Toast.LENGTH_LONG).show();


                //Creamos el intent para llamar a la camara
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri foto_save = null;
                if (takePictureIntent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(takePictureIntent,FOTO_CAMARA);
                }//final if

            }






        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int opcion1 = 1111;

        // para crear los menus
        menu.add(0, opcion1, 0, "enviar").setIcon(android.R.drawable.ic_popup_sync);

        return true;
    }






    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        Uri selectedImageUri = null;

        ImageView foto = (ImageView) findViewById(R.id.imageView);
        if(requestCode==SELECT_FILE){
            selectedImage = data.getData();
            Log.d("Rober", "el nom de la imatge es: " + selectedImage.toString());
            Log.d("Rober","ara es quan vaig a fer setImageURI");
            foto.setImageURI(selectedImage);



        }//final if
        if(requestCode==FOTO_CAMARA && resultCode ==RESULT_OK){
            Log.d("Rober","fent la foto");
            //Web interesant = http://www.tutorialeshtml5.com/2013/12/tutorial-android-utilizar-el-intent-de.html
            //Fuente = https://developer.android.com/training/camera/photobasics.html#TaskPath
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            foto.setImageBitmap(imageBitmap);
        }//final if

    }//final onActivityResult


    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("Rober","onOptionsItemSelected llamado");
        // callback de una opcion del boton de menu
        if (item.getItemId() == 1111) {
            Toast.makeText(this, "enviar_pulsado", Toast.LENGTH_LONG).show();

            //Enviar la foto seleccionada: (pag.109 ApuntesPMOV)
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("image/jpeg");
            sendIntent.putExtra(Intent.EXTRA_STREAM, selectedImage);
            startActivity(sendIntent);

        }
        return false;
    }
}
