package com.example.androiddevassignment_119408464;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webview;

    private Player data;

    private TextView name;

    private Button homeBtn;
    private Button listBtn;
    private Button moreInfoBtn;
    private Button playerInfoBtn;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        data = (Player)intent.getExtras().getSerializable("data");

        name = findViewById(R.id.pageTitle);
        name.setText(data.getName());

        webview = findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(data.getUrl());

        homeBtn = findViewById(R.id.homeBtn);
        listBtn = findViewById(R.id.listBut);
        moreInfoBtn = findViewById(R.id.moreInfo);
        playerInfoBtn = findViewById(R.id.playerInfo);


        moreInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                Intent intent = new Intent(WebViewActivity.this, MoreInfoActivity.class);
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        playerInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                Intent intent = new Intent(WebViewActivity.this, PlayerInfoActivity.class);
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebViewActivity.this, PlayersListActivity.class);
                startActivity(intent);
            }
        });

    }
}