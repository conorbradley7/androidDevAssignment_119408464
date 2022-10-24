package com.example.androiddevassignment_119408464;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PlayersFromXML {

    private Context context;
    private Player [] players;

    public PlayersFromXML(Context context){
        this.context = context;

        // make the input stream
        InputStream stream = context.getResources().openRawResource(R.raw.player_data);
        DocumentBuilder docBuilder = null;
        Document xmlDoc = null;

        try {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = docBuilder.parse(stream);
        }catch(Exception e){
        }

        // slice xmlDoc
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList nationalityList = xmlDoc.getElementsByTagName("nationality");
        NodeList positionList = xmlDoc.getElementsByTagName("position");
        NodeList shirtNumList = xmlDoc.getElementsByTagName("shirtNum");
        NodeList urlList = xmlDoc.getElementsByTagName("bio");

        players = new Player[nameList.getLength()];

        // populate people
        for(int i=0;i< players.length;i++){
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String nationality = nationalityList.item(i).getFirstChild().getNodeValue();
            String position = positionList.item(i).getFirstChild().getNodeValue();
            String shirtNum = shirtNumList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();

            players[i] = new Player(name, nationality, position, shirtNum, url);
        }

    }

    public int getLength(){return players.length;}
    public Player getPlayer(int i){return players[i];}
    public String [] getNames(){
        String names [] = new String[players.length];
        for(int i=0;i<getLength();i++){
            names[i] = getPlayer(i).getName();
        }
        return names;
    }
    public String [] getPositions(){
        String positions [] = new String[players.length];
        for(int i=0;i<getLength();i++){
            positions[i] = getPlayer(i).getPosition();
        }
        return positions;
    }
}
