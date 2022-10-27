package com.example.androiddevassignment_119408464;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PlayersFromXML {
    // XML Parsing
    // Extracts data from XML into lists of data for each tag

    private Context context;
    private Player [] players;

    public PlayersFromXML(Context context){
        this.context = context;

        // make the input stream
        // point to XML file
        InputStream stream = context.getResources().openRawResource(R.raw.player_data);
        DocumentBuilder docBuilder = null;
        Document xmlDoc = null;

        try {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = docBuilder.parse(stream);
        }catch(Exception e){
        }

        // slice xmlDoc, create lists of data by tagName
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList nationalityList = xmlDoc.getElementsByTagName("nationality");
        NodeList positionList = xmlDoc.getElementsByTagName("position");
        NodeList shirtNumList = xmlDoc.getElementsByTagName("shirtNum");
        NodeList imageList = xmlDoc.getElementsByTagName("image");

        // Create a list of player objects
        players = new Player[nameList.getLength()];

        // populate player objects from created lists with XML data by iterating through
        // and creating player object for each index.
        for(int i=0;i< players.length;i++){
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String nationality = nationalityList.item(i).getFirstChild().getNodeValue();
            String position = positionList.item(i).getFirstChild().getNodeValue();
            String shirtNum = shirtNumList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();

            players[i] = new Player(name, nationality, position, shirtNum, image);
        }

    }

    // Standard getters for extracting player data from Players list
    public int getLength(){return players.length;}
    public Player getPlayer(int i){return players[i];}

    public Player [] getPlayers(){
        Player [] data = null;
        for(int i=0;i<getLength();i++){
            data[i] = getPlayer(i);
        }
        return data;
    }


    public String [] getData(String type){
        String data [] = new String[players.length];
        for(int i=0;i<getLength();i++){
        }
        switch(type){
            case "names":
                for(int i=0;i<getLength();i++){
                    data[i] = getPlayer(i).getName();
                }
                break;

            case "positions":
                for(int i=0;i<getLength();i++){
                    data[i] = getPlayer(i).getPosition();
                }
                break;

            case "images":
                for(int i=0;i<getLength();i++){
                    data[i] = getPlayer(i).getImage();
                }
                break;

            case "nationalities":
                for(int i=0;i<getLength();i++){
                    data[i] = getPlayer(i).getNationality();
                }
                break;
        }
        return data;
    }
}
