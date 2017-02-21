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


public class JajargenjangActivity extends ActionBarActivity {

    Button btnluas,btnkeliling,btnreset;
    EditText txtalas,txttinggi,txtA;
    TextView txtpenyelesaian,txthasil;
    float alas = 0;
    float tinggi = 0;
    float a = 0;
    float hasil = 0;

    Button btnclosepopup;
    ImageView btnopenpopup;
    PopupWindow pwindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jajargenjang);

        btnluas = (Button)findViewById(R.id.btnluas);
        btnkeliling = (Button)findViewById(R.id.btnkeliling);
        btnreset = (Button)findViewById(R.id.btnreset);
        txtalas = (EditText)findViewById(R.id.txtalas);
        txttinggi = (EditText)findViewById(R.id.txttinggi);
        txtA = (EditText)findViewById(R.id.txtA);
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
        if(txtalas.getText().toString().matches("")||txttinggi.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "a dan t diisi dulu!", Toast.LENGTH_SHORT).show();
        }else{
            alas = Float.parseFloat(txtalas.getText().toString());
            tinggi = Float.parseFloat(txttinggi.getText().toString());
            hasil = alas * tinggi;
            txtpenyelesaian.setText("Penyelesaian\n" +
                    "alas = " + alas +
                    "\ntinggi = " + tinggi +
                    "\nKeliling = "+ alas +" x " + tinggi +
                    "\nKeliling = " + hasil);
            txthasil.setText("" + hasil);
        }
    }

    private void kalkulasiluas() {
        if(txtalas.getText().toString().matches("")||txtA.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(),"a dan A diisi dulu!",Toast.LENGTH_SHORT).show();

        }else{
            alas = Float.parseFloat(txtalas.getText().toString());
            a = Float.parseFloat(txtA.getText().toString());
            hasil = 2*(alas+a);
            txtpenyelesaian.setText("Penyelesaian\n" +
                    "alas = "+alas+
                    "\nA = "+a+
                    "\nLuas = ( 2 x "+alas+" ) + ( 2 x "+a+ " )"+
                    "\nLuas = "+hasil);
            txthasil.setText(""+hasil);
        }
    }

    private void resetkalkulasi() {
        txtalas.setText("");
        txttinggi.setText("");
        txtA.setText("");
        txtpenyelesaian.setText("Penyelesaian");
        txthasil.setText("0");
        alas = 0;
        tinggi = 0;
        a = 0;
        hasil = 0;
    }

    public void keluarPopup(){
        try{
            LayoutInflater inflater = (LayoutInflater)JajargenjangActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
