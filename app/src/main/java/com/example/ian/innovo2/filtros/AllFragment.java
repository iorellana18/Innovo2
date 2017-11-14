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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
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

        try {int j;
            JSONArray json = new JSONArray(readJSONFromAsset());
            for(j=0;j<json.length();j++){
                JSONObject object = json.getJSONObject(j);
                Objeto objeto2 = new Objeto(object.getString("comuna"),object.getString("nombre"),
                        object.getString("direccion"),object.getString("telefono"),object.getString("categoria"));
                objetos.add(objeto2);
            }
        }catch (JSONException j){
            System.out.print(j);
        }


        return objetos;
    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getResources().openRawResource(R.raw.all);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
