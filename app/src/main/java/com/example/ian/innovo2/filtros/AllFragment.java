package com.example.ian.innovo2.filtros;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.ian.innovo2.R;
import com.example.ian.innovo2.model.Objeto;

import java.util.ArrayList;

/**
 * Created by ian on 14-11-17.
 */

public class AllFragment extends Fragment {


    ListView list;
    ListAdapter adapter;
    String[]  titulos = {
            "Bombero",
            "Salud",
            "Paco"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all, container, false);
        list =view.findViewById(R.id.list);

        adapter = new com.example.ian.innovo2.adapter.ListAdapter(getContext(), getObjetos());
        list.setAdapter(adapter);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });

        return view;
    }

    public ArrayList<Objeto> getObjetos(){
        ArrayList<Objeto> objetos = new ArrayList<>();
        Objeto objeto = new Objeto("comuna","nombre","direccion","telefono","categoria");
        objetos.add(objeto);

        return objetos;
    }
}
