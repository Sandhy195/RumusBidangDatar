package com.example.sipo.rumusbidangdatar;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


public class LingkaranActivity extends ActionBarActivity {

    Button btnluas,btnkeliling,btnreset;
    EditText txtr,txtd;
    TextView txtpenyelesaian,txthasil;
    float r = 0;
    float d = 0;
    float phi = (float) 3.14;
    float hasil = 0;

    Button btnclosepopup;
    ImageView btnopenpopup;
    PopupWindow pwindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        btnluas = (Button)findViewById(R.id.btnluas);
        btnkeliling = (Button)findViewById(R.id.btnkeliling);
        btnreset = (Button)findViewById(R.id.btnreset);
        txtr = (EditText)findViewById(R.id.txtr);
        txtd = (EditText)findViewById(R.id.txtd);
        txtpenyelesaian = (TextView)findViewById(R.id.txtpenyelesaian);
        txthasil = (TextView)findViewById(R.id.txthasil);

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetkalkulasi();
            }
        });
        btnluas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kalkulasiluas();
            }
        });
        btnkeliling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kalkulasikeliling();
            }
        });


        btnopenpopup = (ImageView)findViewById(R.id.imageViewinfo);
        btnopenpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keluarPopup();
            }
        });

    }

    private void kalkulasikeliling() {
        if(txtd.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "d diisi dulu!", Toast.LENGTH_SHORT).show();
        }else{
            d = Float.parseFloat(txtd.getText().toString());
            hasil = phi*d;
            txtpenyelesaian.setText("Penyelesaian\n" +
                    "diameter = " + d +
                    "\nKeliling = 3.14 x " + d +
                    "\nKeliling = " + hasil);
            txthasil.setText("" + hasil);
        }
    }

    private void kalkulasiluas() {
        if(txtr.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(),"r diisi dulu!",Toast.LENGTH_SHORT).show();

        }else{
            r = Float.parseFloat(txtr.getText().toString());
            hasil = phi*r*r;
            txtpenyelesaian.setText("Penyelesaian\n" +
                    "jari-jari = "+r+
                    "\nLuas = 3.14 x "+r+" x "+r+
                    "\nLuas = "+hasil);
            txthasil.setText(""+hasil);
        }
    }

    private void resetkalkulasi() {
        txtr.setText("");
        txtd.setText("");
        txtpenyelesaian.setText("Penyelesaian");
        txthasil.setText("0");
        r = 0;
        d = 0;
        hasil = 0;
    }



    public void keluarPopup(){
        try{
            LayoutInflater inflater = (LayoutInflater)LingkaranActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup,(ViewGroup)findViewById(R.id.popup_element));

            pwindow = new PopupWindow(layout,500,550,true);
            pwindow.showAtLocation(layout, Gravity.CENTER,0,0);

            btnclosepopup =(Button)layout.findViewById(R.id.btnclosepopup);
            btnclosepopup.setOnClickListener(btntutup);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private View.OnClickListener btntutup = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pwindow.dismiss();
        }
    };



}
