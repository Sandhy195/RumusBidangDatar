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


public class PersegiActivity extends ActionBarActivity {

    Button btnluas,btnkeliling,btnreset;
    EditText txtsisi;
    TextView txtpenyelesaian,txthasil;
    float s = 0;
    float hasil = 0;

    Button btnclosepopup;
    ImageView btnopenpopup;
    PopupWindow pwindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);

        btnluas = (Button)findViewById(R.id.btnluas);
        btnkeliling = (Button)findViewById(R.id.btnkeliling);
        btnreset = (Button)findViewById(R.id.btnreset);
        txtsisi = (EditText)findViewById(R.id.txtsisi);
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
        if(txtsisi.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(),"s diisi dulu!",Toast.LENGTH_SHORT).show();
        }else{
            s = Float.parseFloat(txtsisi.getText().toString());
            hasil = 4 * s;
            txtpenyelesaian.setText("Penyelesaian\n" +
                    "sisi = " + s +
                    "\nKeliling = 4 x " + s +
                    "\nKeliling = " + hasil);
            txthasil.setText("" + hasil);
        }
    }

    private void kalkulasiluas() {
        if(txtsisi.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(),"s diisi dulu!",Toast.LENGTH_SHORT).show();

        }else{
            s = Float.parseFloat(txtsisi.getText().toString());
            hasil = s*s;
            txtpenyelesaian.setText("Penyelesaian\n" +
                    "sisi = "+s+
                    "\nLuas = "+s+" x "+s+
                    "\nLuas = "+hasil);
            txthasil.setText(""+hasil);
        }
    }

    private void resetkalkulasi() {
        txtsisi.setText("");
        txtpenyelesaian.setText("Penyelesaian");
        txthasil.setText("0");
        s = 0;
        hasil = 0;
    }



    public void keluarPopup(){
        try{
            LayoutInflater inflater = (LayoutInflater)PersegiActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
