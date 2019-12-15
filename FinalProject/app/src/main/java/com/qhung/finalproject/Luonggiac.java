package com.qhung.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Luonggiac extends AppCompatActivity {
    EditText edt;
    Button btnSin,btnCos,btnTan,btnCotan,btnb;
    RadioGroup rdg;
    TextView tvres;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luonggiac);
        edt = findViewById(R.id.edt_a);
        btnSin = findViewById(R.id.btn_sin);
        btnCos = findViewById(R.id.btn_cos);
        btnTan = findViewById(R.id.btn_tan);
        btnCotan = findViewById(R.id.btn_cotan);
        btnb = findViewById(R.id.btn_back);
        rdg = findViewById(R.id.rdg);
        tvres = findViewById(R.id.tv_res);
        db = new MyDatabase(this);
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = edt.getText().toString();
                if (a.isEmpty()){
                    Toast.makeText(Luonggiac.this, "Mời nhập dữ liệu", Toast.LENGTH_SHORT).show();
                }
                else{
                    double x = Double.parseDouble(a);
                    String s="Sin("+x;
                    int i=rdg.getCheckedRadioButtonId();
                    if (i==R.id.rdd){
                        x=x/180*Math.PI;
                        s+=" độ)=";
                    }
                    else s+=" radian)=";
                    s=s+Math.sin(x);
                    db.addchuoi(s);
                    tvres.setText(Math.sin(x)+"");
                }
            }
        });
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = edt.getText().toString();
                if (a.isEmpty()){
                    Toast.makeText(Luonggiac.this, "Mời nhập dữ liệu", Toast.LENGTH_SHORT).show();
                }
                else{
                    double x = Double.parseDouble(a);
                    String s="Cos("+x;
                    int i=rdg.getCheckedRadioButtonId();
                    if (i==R.id.rdd){
                        x=x/180*Math.PI;
                        s+=" độ)=";
                    }
                    else s+=" radian)=";
                    s=s+Math.cos(x);
                    db.addchuoi(s);
                    tvres.setText(Math.cos(x)+"");
                }
            }
        });
        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = edt.getText().toString();
                if (a.isEmpty()){
                    Toast.makeText(Luonggiac.this, "Mời nhập dữ liệu", Toast.LENGTH_SHORT).show();
                }
                else{
                    double x = Double.parseDouble(a);
                    String s="Tan("+x;
                    int i=rdg.getCheckedRadioButtonId();
                    if (i==R.id.rdd){
                        x=x/180*Math.PI;
                        s+=" độ)=";
                    }
                    else s+=" radian)=";
                    s=s+Math.tan(x);
                    db.addchuoi(s);
                    tvres.setText(Math.tan(x)+"");
                }
            }
        });
        btnCotan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = edt.getText().toString();
                if (a.isEmpty()){
                    Toast.makeText(Luonggiac.this, "Mời nhập dữ liệu", Toast.LENGTH_SHORT).show();
                }
                else{
                    double x = Double.parseDouble(a);
                    String s="Cotan("+x;
                    int i=rdg.getCheckedRadioButtonId();
                    if (i==R.id.rdd){
                        x=x/180*Math.PI;
                        s+=" độ)=";
                    }
                    else s+=" radian)=";
                    s=s+1.0/Math.tan(x);
                    db.addchuoi(s);
                    tvres.setText(1.0/Math.tan(x)+"");
                }
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
