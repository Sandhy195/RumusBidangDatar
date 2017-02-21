package com.example.sipo.rumusbidangdatar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    GridView gridView;
    String[] nama = {
            "Persegi","Persegi Panjang","Segitiga","Jajar Genjang","Trapesium","Layang-layang","Belah Ketupat","Lingkaran"
    };
    int[] gambar = {
            R.drawable.persegi,
            R.drawable.persegipanjang,
            R.drawable.segitiga,
            R.drawable.jajargenjang,
            R.drawable.trapesium,
            R.drawable.layanglayang,
            R.drawable.belahketupat,
            R.drawable.lingkaran
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        gridView = (GridView)findViewById(R.id.gridView);

        Adapter adapter = new Adapter(this, getBangun());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),nama[position],Toast.LENGTH_SHORT).show();
                masukrumus(position);
            }
        });
    }

    private void masukrumus(int position) {
        if(position == 0){
            Intent a = new Intent(MainActivity.this,PersegiActivity.class);
            startActivity(a);
        }else if(position == 1){
            Intent a = new Intent(MainActivity.this,PersegipanjangActivity.class);
            startActivity(a);
        }else if(position == 2){
            Intent a = new Intent(MainActivity.this,SegitigaActivity.class);
            startActivity(a);
        }else if(position == 3){
            Intent a = new Intent(MainActivity.this,JajargenjangActivity.class);
            startActivity(a);
        }else if(position == 4){
            Intent a = new Intent(MainActivity.this,TrapesiumActivity.class);
            startActivity(a);
        }else if(position == 5){
            Intent a = new Intent(MainActivity.this,LayanglayangActivity.class);
            startActivity(a);
        }else if(position == 6){
            Intent a = new Intent(MainActivity.this,BelahketupatActivity.class);
            startActivity(a);
        }else if(position == 7){
            Intent a = new Intent(MainActivity.this,LingkaranActivity.class);
            startActivity(a);
        }
    }

    private ArrayList<Bangun> getBangun(){
        ArrayList<Bangun> bangun = new ArrayList<Bangun>();
        for(int i=0;i < nama.length;i++) {
            bangun.add(new Bangun(nama[i], gambar[i]));
        }
        return bangun;
    }
}
