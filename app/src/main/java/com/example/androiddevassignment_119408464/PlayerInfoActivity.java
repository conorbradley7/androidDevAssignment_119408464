package com.example.androiddevassignment_119408464;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerInfoActivity extends AppCompatActivity {

    private Button homebtn = null;
    private Button moreInfo = null;
    private Player data = null;
    private TextView name = null;
    private TextView position= null;
    private TextView shirtNum= null;
    private TextView nation= null;
    private ImageView playerImg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        //Get player data
        Intent intent = getIntent();
        data = (Player)intent.getExtras().getSerializable("data");

        homebtn = findViewById(R.id.homeBtn);
        moreInfo = findViewById(R.id.moreInfo);
        name = findViewById(R.id.pageTitle);
        position = findViewById(R.id.appearancesVal);
        shirtNum = findViewById(R.id.shirtNumVal);
        nation = findViewById(R.id.nationalityVal);
        playerImg = findViewById(R.id.playerImg);

        name.setText(data.getName());
        position.setText(data.getPosition());
        shirtNum.setText(data.getShirt_num());
        nation.setText(data.getNationality());
        int imageId = this.getResources().getIdentifier(data.getImage(),"drawable", this.getPackageName());
        playerImg.setImageResource(imageId);


        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayerInfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                Intent intent = new Intent(PlayerInfoActivity.this, MoreInfoActivity.class);
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}