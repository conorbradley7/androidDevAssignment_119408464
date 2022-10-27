package com.example.androiddevassignment_119408464;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PlayersListActivity extends AppCompatActivity implements RecycleViewInterface {
    // "Activity 1"
    // Recycle View List with players of Man United Squad
    // List rows include image, name and position of players

    private RecyclerView recyclerView = null;
    private DataAdapter adapter = null;
    private PlayersFromXML players;
    private Button homebtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_list);

        // recycleView settings
        recyclerView = findViewById(R.id.playerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // get the data
        players = new PlayersFromXML(this);

        // make the adapter and set it to recycleView
        adapter = new DataAdapter(this, R.layout.row_layout, players, this);

        recyclerView.setAdapter(adapter);

        homebtn = findViewById(R.id.homeBtn);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayersListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(int pos) {
        // what to do when click a list item

        //Get data associated with pos
        Player player = players.getPlayer(pos);
        Bundle bundle = new Bundle();

        // make intent + place bundle on ot + start new activity
        // still few lines of functionality
        Intent intent = new Intent(PlayersListActivity.this, PlayerInfoActivity.class);
        bundle.putSerializable("data", player);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}

