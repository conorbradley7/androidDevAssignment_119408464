package com.example.androiddevassignment_119408464;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PlayersListActivity extends AppCompatActivity implements RecycleViewInterface {

    private RecyclerView recyclerView = null;
    private DataAdapter adapter = null;
    private PlayersFromXML players;

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
        String[] names = players.getNames();
        String[] positions = players.getPositions();

        // make the adapter and set it to recycleView
        adapter = new DataAdapter(this, R.layout.row_layout, names, positions, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int pos) {
        // what to do when click a list item

        //Get data associated with pos
        Player player = players.getPlayer(pos);
        Bundle bundle = new Bundle();

        // make intent + place bundle on ot + start new activity
        // still few lines of functionality
        Toast.makeText(this, players.getPlayer(pos).getName(),Toast.LENGTH_SHORT).show();

    }
}

