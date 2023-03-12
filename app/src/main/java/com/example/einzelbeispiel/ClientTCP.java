package com.example.einzelbeispiel;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientTCP extends Thread {
    String getServerAnswer (String mNr) throws IOException{

        String serverAnswer;

        Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(mNr+'\n');
        serverAnswer = inFromServer.readLine();

        clientSocket.close();

        return serverAnswer;
    }



}
