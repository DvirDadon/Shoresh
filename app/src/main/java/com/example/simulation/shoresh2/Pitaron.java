package com.example.simulation.shoresh2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Pitaron extends AppCompatActivity {
    TextView x1,x2;
    double a,b,c,d,e,f;
    WebView Wv;
    String url;
    Intent gi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitaron);
        gi = getIntent();
        a=gi.getDoubleExtra("n",999.9);
        b=gi.getDoubleExtra("nn",999.9);
        c=gi.getDoubleExtra("nnn",999.9);
        if ((a!=999.9) || (b!=999.9)||(c!=999.9)) {
            x1 = (TextView) findViewById(R.id.x1);
            x2 = (TextView) findViewById(R.id.x2);
            Wv = (WebView) findViewById(R.id.wV);
            url = "https://www.google.com/search?ei=mkSmXM6QIeOS1fAP_aaKwAk&q=" + a + "x%5E2%2B" + b + "x%2B" + c + "&oq=5x%5E2%2B2x%2B3&gs_l=psy-ab.3..0i203j0i30l9.7136711.7143291..7143563...0.0..0.151.1143.0j9......0....1..gws-wiz.......35i39j0i131j0j35i39i19.WDPr0vE0iME";
            b = b * (-1);
            d = Math.sqrt(Math.pow(b, 2) + (-4 * a * c));
            a = a * 2;
            e = (b + d) / a;
            f = (b - d) / a;
            x1.setText("x1="+" "+ e);
            x2.setText("x2="+" "+ f);
            Wv.getSettings().setJavaScriptEnabled(true);
            Wv.loadUrl(url);
            Wv.setWebViewClient(new WebViewClient());
        }
    }



    public void Kelet(View view) {
        gi.putExtra("n",e);
        gi.putExtra("nn",f);
        setResult(RESULT_OK,gi);
        finish();
    }

    private class MyWebViewClient extends WebViewClient {
    @Override
        public boolean shouldOverrideUrlLoading(WebView view ,String url){
            view.loadUrl(url);
            return true;
        }
    }


}