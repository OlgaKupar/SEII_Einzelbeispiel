package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ClientTCP clientTCP;

    TextView tfInstruction;
    TextView tfServerAnswer;
    TextView tfComputationResult;
    EditText etfMNr;
    Button btnSend;
    Button btnCompute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientTCP = new ClientTCP();

        tfInstruction = findViewById(R.id.tfInstruction);
        tfServerAnswer = findViewById(R.id.tfServerAnswer);
        tfComputationResult = findViewById(R.id.tfComputationResult);
        etfMNr = findViewById(R.id.etfMNr);
        btnSend = findViewById(R.id.btnSend);
        btnCompute = findViewById(R.id.btnCompute);

        btnSend.setOnClickListener(
                view -> {
                    String input = etfMNr.getText().toString();

                    try {
                        String serverAnswer = clientTCP.getServerAnswer(
                                String.valueOf(Integer.parseInt(input)));

                        tfServerAnswer.setText(serverAnswer);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}