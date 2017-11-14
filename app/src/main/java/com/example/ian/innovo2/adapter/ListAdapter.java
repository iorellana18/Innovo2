package com.example.ian.innovo2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

    public View getView(int position, View convertView, ViewGroup parent) {


        TextView titulo;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.style_object, parent, false);

        titulo = itemView.findViewById(R.id.titulo);

        titulo.setText(objetos.get(position).getCategoria());

        return itemView;
    }
}
