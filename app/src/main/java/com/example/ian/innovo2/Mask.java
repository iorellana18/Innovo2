package com.example.ian.innovo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ian on 13-11-17.
 */

public class Mask extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mask);
    }
    public void ingresar(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
