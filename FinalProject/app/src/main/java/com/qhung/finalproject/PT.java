package com.qhung.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PT extends AppCompatActivity {
    EditText edta,edtb,edtc;
    TextView tvpt,tvres;
    Button btn,btn_back;
    String a="",b="",c="",res="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt);
        edta = findViewById(R.id.edt_a);
        edtb = findViewById(R.id.edt_b);
        edtc = findViewById(R.id.edt_c);
        tvpt = findViewById(R.id.tv_pt);
        tvres = findViewById(R.id.tv_res);
        btn = findViewById(R.id.btn);
        tvpt.setText(res);
        edta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                a=charSequence.toString();
                res="";
                if (!a.isEmpty()) res="("+a+")x^2";
                if (!b.isEmpty())
                    if (res.isEmpty()) res="("+b+")x";
                        else res=res+"+("+b+")x";
                if (!c.isEmpty())
                    if (res.isEmpty()) res="("+c+")";
                    else res=res+"+("+c+")";
                if (!res.isEmpty()) res=res+"=0";
                tvpt.setText(res);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                b=charSequence.toString();
                res="";
                if (!a.isEmpty()) res="("+a+")x^2";
                if (!b.isEmpty())
                    if (res.isEmpty()) res="("+b+")x";
                    else res=res+"+("+b+")x";
                if (!c.isEmpty())
                    if (res.isEmpty()) res="("+c+")";
                    else res=res+"+("+c+")";
                if (!res.isEmpty()) res=res+"=0";
                tvpt.setText(res);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                c=charSequence.toString();
                res="";
                if (!a.isEmpty()) res="("+a+")x^2";
                if (!b.isEmpty())
                    if (res.isEmpty()) res="("+b+")x";
                    else res=res+"+("+b+")x";
                if (!c.isEmpty())
                    if (res.isEmpty()) res="("+c+")";
                    else res=res+"+("+c+")";
                if (!res.isEmpty()) res=res+"=0";
                tvpt.setText(res);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a.isEmpty() && b.isEmpty() && c.isEmpty()){
                    Toast.makeText(PT.this, "Bạn phải nhập ít nhất 1 giá trị", Toast.LENGTH_SHORT).show();
                }
                else{
                    double x=0,y=0,z=0;
                    if (!a.isEmpty()) x=Double.parseDouble(a);
                    if (!b.isEmpty()) y=Double.parseDouble(b);
                    if (!c.isEmpty()) z=Double.parseDouble(c);
                    if (x==0){
                        if (y==0){
                            if (z==0)
                                tvres.setText("Phương trình vô số nghiệm");
                            else tvres.setText("Phương trình vô nghiệm");
                        }
                        else tvres.setText("x="+(-z/y));
                    }
                    else{
                        double delta=y*y-4*x*z;
                        if (delta<0) tvres.setText("Phương trình vô nghiệm");
                        if (delta==0) tvres.setText("x="+(-y/2/x));
                        if (delta>0) tvres.setText("x1="+((-y+Math.sqrt(delta))/2/x)+" và x2="+((-y-Math.sqrt(delta))/2/x));
                    }
                }
            }
        });
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

