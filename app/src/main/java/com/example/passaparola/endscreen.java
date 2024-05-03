package com.example.passaparola;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class endscreen extends AppCompatActivity {

    TextView textViewInfo, textViewPassQuestions, textViewWrongQuestions;
    Button buttonRestart, buttonExit;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_endscreen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        int puan = intent.getIntExtra("puan", 0);
        ArrayList<String> passQuestions = intent.getStringArrayListExtra("passQuestions");
        ArrayList<String> wrongQuestions = intent.getStringArrayListExtra("wrongQuestions");
        textViewInfo = findViewById(R.id.textViewInfo);
        textViewInfo.setText("Tebrikler! Oyun bitti. Puanınız: " + puan);

        StringBuilder stringBuilderPass = new StringBuilder();

        if (!passQuestions.isEmpty()) {
            int passSize = passQuestions.size();
            for (int i = 0; i < passSize; i++) {
                String item = passQuestions.get(i);
                stringBuilderPass.append(item);
                if (i < passSize - 1) {
                    stringBuilderPass.append(", ");
                }
            }
        } else {
            stringBuilderPass.append("Pas geçtiğiniz sorunuz yok.");
        }
        StringBuilder stringBuilderWrong = new StringBuilder();
        if(!wrongQuestions.isEmpty()){
            int wrongSize = wrongQuestions.size();
            for (int i = 0; i < wrongSize; i++) {
                String item = wrongQuestions.get(i);
                stringBuilderWrong.append(item);
                if (i < wrongSize - 1) {
                    stringBuilderWrong.append(", ");
                }
            }
        } else{
            stringBuilderWrong.append("Yanlış sorunuz yok.");
        }

        textViewPassQuestions = findViewById(R.id.textViewPassQuestions);
        textViewPassQuestions.setText("Pas geçtiğiniz kelimeler: " + stringBuilderPass);

        textViewWrongQuestions = findViewById(R.id.textViewWrongQuestions);
        textViewWrongQuestions.setText("Yanlış bildiğiniz kelimeler: " + stringBuilderWrong);

        buttonRestart = findViewById(R.id.buttonRestart);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewGame = new Intent(endscreen.this, MainActivity.class);
                startActivity(intentNewGame);
                finish();
            }
        });

        buttonExit = findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}