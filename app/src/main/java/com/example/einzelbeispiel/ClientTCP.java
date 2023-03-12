package com.example.einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTCP {

    String getServerAnswer (String mnr) throws IOException{

        String serverAnswer;

        Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(mnr);
        serverAnswer = inFromServer.readLine();

        clientSocket.close();

        return serverAnswer;
    }


}
