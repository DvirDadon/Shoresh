package com.example.simulation.shoresh2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Double a, b, c;
    String aa, bb, cc;
    Random rnd = new Random();
    EditText A;
    EditText B;
    EditText C;
    TextView answer1;
    TextView answer2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = (EditText) findViewById(R.id.A);
        B = (EditText) findViewById(R.id.B);
        C = (EditText) findViewById(R.id.C);
        answer1 = (TextView) findViewById(R.id.answer1);
        answer2 = (TextView) findViewById(R.id.answer2);
        }



        public void Random (View view){
            a = rnd.nextInt(100) + 1 + rnd.nextDouble();
            b = rnd.nextInt(100) + 1 + rnd.nextDouble();
            c = rnd.nextInt(100) + 1 + rnd.nextDouble();
            A.setText("" + a);
            B.setText("" + b);
            C.setText("" + c);
        }


        public void Solution (View view){
            Intent si = new Intent(this, Pitaron.class);
            aa = A.getText().toString();
            bb = B.getText().toString();
            cc = C.getText().toString();
            if((aa.equals(""))||(bb.equals(""))||(cc.equals(""))||(aa.equals("-"))||(bb.equals("-"))||(cc.equals("-")))
                Toast.makeText(this, "Enter ax^2+bx+c before doing a solution", Toast.LENGTH_SHORT).show();
            else {
                a = Double.parseDouble(aa);
                b = Double.parseDouble(bb);
                c = Double.parseDouble(cc);
                si.putExtra("n", a);
                si.putExtra("nn", b);
                si.putExtra("nnn", c);
                startActivityForResult(si, 1);

            }
        }
        @Override
        protected void onActivityResult(int source , int good, @Nullable Intent data){
        if(source==1){
            if (good==RESULT_OK){
                if (data!=null) {
                    answer1.setText("x1="+" "+ data.getStringExtra("n"));
                    answer2.setText("x2=" +" "+ data.getStringExtra("nn"));
                }
                }
        }
        }
    }
