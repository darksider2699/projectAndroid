package com.qhung.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Basic extends AppCompatActivity {
    EditText edta,edtb;
    Button btnc,btnt,btnm,btnd,btnback;
    TextView tvres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        edta = findViewById(R.id.edt_a);
        edtb = findViewById(R.id.edt_b);
        btnc = findViewById(R.id.btn_plus);
        btnt = findViewById(R.id.btn_sub);
        btnm = findViewById(R.id.btn_mul);
        btnd = findViewById(R.id.btn_div);
        btnback = findViewById(R.id.btn_back);
        tvres = findViewById(R.id.tv_res);
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = edta.getText().toString();
                String b = edtb.getText().toString();
                if (a.isEmpty()||b.isEmpty()){
                    Toast.makeText(Basic.this, "Không được bỏ trống số, mời nhập đầy đủ", Toast.LENGTH_SHORT).show();
                }
                else{
                    double res=Double.parseDouble(a)+Double.parseDouble(b);
                    tvres.setText(String.valueOf(res));
                }
            }
        });
        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = edta.getText().toString();
                String b = edtb.getText().toString();
                if (a.isEmpty()||b.isEmpty()){
                    Toast.makeText(Basic.this, "Không được bỏ trống số, mời nhập đầy đủ", Toast.LENGTH_SHORT).show();
                }
                else{
                    double res=Double.parseDouble(a)-Double.parseDouble(b);
                    tvres.setText(String.valueOf(res));
                }
            }
        });
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = edta.getText().toString();
                String b = edtb.getText().toString();
                if (a.isEmpty()||b.isEmpty()){
                    Toast.makeText(Basic.this, "Không được bỏ trống số, mời nhập đầy đủ", Toast.LENGTH_SHORT).show();
                }
                else{
                    double res=Double.parseDouble(a)*Double.parseDouble(b);
                    tvres.setText(String.valueOf(res));
                }
            }
        });
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = edta.getText().toString();
                String b = edtb.getText().toString();
                if (a.isEmpty()||b.isEmpty()){
                    Toast.makeText(Basic.this, "Không được bỏ trống số, mời nhập đầy đủ", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (Double.parseDouble(b)==0){
                        Toast.makeText(Basic.this, "Không thể chia cho 0, mời nhập lại", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        double res = Double.parseDouble(a) / Double.parseDouble(b);
                        tvres.setText(String.valueOf(res));
                    }
                }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
