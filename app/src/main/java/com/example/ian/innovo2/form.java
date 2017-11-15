package com.example.ian.innovo2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ian.innovo2.model.Objeto;

/**
 * Created by ianorellana on 15-11-17.
 */

public class form extends AppCompatActivity {

    TextView nombre;
    TextView comuna;
    TextView telefono;
    TextView direccion;
    Objeto objeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        nombre = findViewById(R.id.textNombre);
        comuna = findViewById(R.id.textComuna);
        telefono = findViewById(R.id.textTelefono);
        direccion = findViewById(R.id.textDireccion);

        objeto = (Objeto)getIntent().getSerializableExtra("objeto");

        nombre.setText(objeto.getNombre());
        comuna.setText(objeto.getComuna());
        telefono.setText(objeto.getTelefono());
        direccion.setText(objeto.getDireccion());

    }


    public void llamar(View view){

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+objeto.getTelefono()));

        if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            getApplicationContext().startActivity(callIntent);
        }
    }
}
