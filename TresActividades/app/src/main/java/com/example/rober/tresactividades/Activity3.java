package com.example.rober.tresactividades;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.R.attr.data;

public class Activity3 extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
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
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);


                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

                startActivityForResult(chooserIntent, PICK_IMAGE);

                //ImageView imageView = (ImageView) findViewById(R.id.imageView);



            }

        });


            //-------Escuchador del boton camara
        botonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            //-----cuando se pulse camara
            public void onClick(View v) {
                Toast.makeText(THIS, "Camara Pulsado", Toast.LENGTH_LONG).show();




            }






        });
















    }

}
