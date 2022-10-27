package com.example.androiddevassignment_119408464;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Landing "Home Page" Activity

    private Button enterButton = null;
    private ImageView imageView = null;
    private PlayersFromXML players = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterButton = findViewById(R.id.enterButton);
        imageView = findViewById(R.id.imageViewHome);

        // Get random player image for image view
        // Get Data from XML, extract image list, chose random image index
        // Get image resource id and set Image resource
        players = new PlayersFromXML(this);
        String[] images = players.getData(PlayersFromXML.DataRetrievalType.IMAGES);
        System.out.println(images[0]);
        int imageId = this.getResources().getIdentifier(images[new Random().nextInt(players.getLength())],"drawable", this.getPackageName());
        imageView.setImageResource(imageId);


        enterButton.setOnClickListener(new View.OnClickListener() {
            // Button to take you to playerListActivity
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlayersListActivity.class);
                startActivity(intent);
            }
        });
    }
}