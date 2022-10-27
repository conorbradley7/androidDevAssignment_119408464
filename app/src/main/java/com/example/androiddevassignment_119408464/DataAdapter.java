package com.example.androiddevassignment_119408464;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    // Data Adapter Class
    // USed for working with the recycle view list element
    private Context context;
    private int rowID;
    private PlayersFromXML players;
    private String [] names;
    private String [] positions;
    private String[] images;
    RecycleViewInterface recycleViewInterface;

    public DataAdapter(Context context, int rowID, PlayersFromXML players, RecycleViewInterface recycleViewInterface) {
        this.context = context;
        this.rowID = rowID;
        this.players = players;

        this.names = players.getData("names");
        this.positions = players.getData("positions");
        this.images = players.getData("images");
        this.recycleViewInterface = recycleViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout and return the tree view
        View v = LayoutInflater.from(this.context).inflate(this.rowID, parent, false);
        return new ViewHolder(v, recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int pos) {
        // populate or bind the viewholder fields with data
        // takes in an integer pos marking the index of the list.
        // populates that list item with appropriate name, image and position of player
        int imageId = context.getResources().getIdentifier(images[pos],"drawable", context.getPackageName());
        holder.name.setText(names[pos]);
        holder.position.setText(positions[pos]);
        holder.icon.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView position;
        public ImageView icon;

        public ViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            position = itemView.findViewById(R.id.position);
            icon = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // call the RecycleView Interface Method
                    if (recycleViewInterface != null){
                        //get pos
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            recycleViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }

    }
}
