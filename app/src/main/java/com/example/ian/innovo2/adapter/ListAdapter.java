package com.example.ian.innovo2.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ian.innovo2.MainActivity;
import com.example.ian.innovo2.R;
import com.example.ian.innovo2.model.Objeto;

import java.util.ArrayList;

/**
 * Created by ian on 14-11-17.
 */

public class ListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<Objeto> objetos;
    TextView titulo;
    ImageView logo;
    ImageView phone;

    public ListAdapter(Context context, ArrayList<Objeto> objetos) {
        this.context = context;
        this.objetos = objetos;
    }


    @Override
    public int getCount() {
        return objetos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {




        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View itemView = inflater.inflate(R.layout.style_object, parent, false);

        titulo = itemView.findViewById(R.id.titulo);
        logo = itemView.findViewById(R.id.logo);
        phone = itemView.findViewById(R.id.phone);

        titulo.setText(objetos.get(position).getNombre());
        if(objetos.get(position).getCategoria().equals("centrosalud")){
            logo.setImageDrawable(itemView.getResources().getDrawable(R.drawable.nurse));
        }else if(objetos.get(position).getCategoria().equals("bomberos")){
            logo.setImageDrawable(itemView.getResources().getDrawable(R.drawable.bombero));
        }else{
            logo.setImageDrawable(itemView.getResources().getDrawable(R.drawable.police));
        }

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+objetos.get(position).getTelefono()));

                if (ActivityCompat.checkSelfPermission(context,
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    context.startActivity(callIntent);
                }

            }
        });

        return itemView;
    }
}
