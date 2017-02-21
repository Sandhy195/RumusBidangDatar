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


public class TrapesiumActivity extends ActionBarActivity {

    Button btnluas,btnkeliling,btnreset;
    EditText txttinggi,txtA,txtB,txtC,txtD;
    TextView txtpenyelesaian,txthasil;
    float t = 0;
    float a = 0;
    float b = 0;
    float c = 0;
    float d = 0;
    float hasil = 0;

    Button btnclosepopup;
    ImageView btnopenpopup;
    PopupWindow pwindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapesium);

        btnluas = (Button)findViewById(R.id.btnluas);
        btnkeliling = (Button)findViewById(R.id.btnkeliling);
        btnreset = (Button)findViewById(R.id.btnreset);
        txttinggi = (EditText)findViewById(R.id.txttinggi);
        txtA = (EditText)findViewById(R.id.txtA);
        txtB = (EditText)findViewById(R.id.txtB);
        txtC = (EditText)findViewById(R.id.txtC);
        txtD = (EditText)findViewById(R.id.txtD);
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
        if(txtA.getText().toString().matches("")||txtB.getText().toString().matches("")||txtC.getText().toString().matches("")||txtD.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "A, B, C dan D diisi dulu!", Toast.LENGTH_SHORT).show();
        }else{
            a = Float.parseFloat(txtA.getText().toString());
            b = Float.parseFloat(txtB.getText().toString());
            c = Float.parseFloat(txtC.getText().toString());
            d = Float.parseFloat(txtD.getText().toString());
            hasil = a+b+c+d;
            txtpenyelesaian.setText("Penyelesaian\n" +
                    "A = " + a +
                    "\nB = " + b +
                    "\nC = " + c +
                    "\nD = " + d +
                    "\nKeliling = " + a + " + " + b + " + " + c + " + " + d +
                    "\nKeliling = " + hasil);
            txthasil.setText("" + hasil);
        }
    }

    private void kalkulasiluas() {
        if(txtA.getText().toString().matches("")||txtB.getText().toString().matches("")||txttinggi.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(),"t, A dan B diisi dulu!",Toast.LENGTH_SHORT).show();

        }else{
            t = Float.parseFloat(txttinggi.getText().toString());
            a = Float.parseFloat(txtA.getText().toString());
            b = Float.parseFloat(txtB.getText().toString());
            hasil = ((a+b)*t)/2;
            txtpenyelesaian.setText("Penyelesaian\n" +
                    "tinggi = "+t+
                    "\nA = "+a+
                    "\nB = "+b+
                    "\nLuas = 1/2 x ( "+a+" + "+b+ ") x " +t+
                    "\nLuas = "+hasil);
            txthasil.setText(""+hasil);
        }
    }

    private void resetkalkulasi() {
        txttinggi.setText("");
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtD.setText("");
        txtpenyelesaian.setText("Penyelesaian");
        txthasil.setText("0");
        t = 0;
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        hasil = 0;
    }

    public void keluarPopup(){
        try{
            LayoutInflater inflater = (LayoutInflater)TrapesiumActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
