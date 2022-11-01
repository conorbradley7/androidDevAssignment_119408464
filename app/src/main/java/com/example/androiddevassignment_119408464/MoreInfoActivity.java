package com.example.androiddevassignment_119408464;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MoreInfoActivity extends AppCompatActivity {

    private Button homebtn = null;
    private Player data = null;
    private TextView name = null;
    private TextView bio = null;
    private TextView appearances = null;
    private TextView goals = null;
    private TextView assists = null;
    private TextView trophies = null;
    private TextView quote = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        //Get player data
        Intent intent = getIntent();
        data = (Player)intent.getExtras().getSerializable("data");

        homebtn = findViewById(R.id.homeBtn);
        name = findViewById(R.id.pageTitle);
        bio = findViewById(R.id.bio);
        appearances = findViewById(R.id.appearancesVal);
        goals = findViewById(R.id.goalsVal);
        assists = findViewById(R.id.assistsVal);
        trophies = findViewById(R.id.trophiesVal);
        quote = findViewById(R.id.quote);


        name.setText(data.getName());
        bio.setText(data.getBio());
        appearances.setText(data.getAppearances());
        goals.setText(data.getGoals());
        assists.setText(data.getAssists());
        trophies.setText(data.getMajor_trophies());
        quote.setText(data.getQuote());



        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreInfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}