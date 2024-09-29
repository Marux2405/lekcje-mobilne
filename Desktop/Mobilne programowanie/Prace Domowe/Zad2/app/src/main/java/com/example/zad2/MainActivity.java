package com.example.zad2;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText surname;
    private EditText email;
    private EditText telephone;
    private EditText pass;
    private EditText cpass;
    private Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        email = findViewById(R.id.email);
        telephone = findViewById(R.id.telephone);
        pass = findViewById(R.id.pass);
        cpass = findViewById(R.id.cpass);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namec = name.getText().toString().trim();
                String surnamec = surname.getText().toString().trim();
                String emailc = email.getText().toString().trim();
                String telephonec = telephone.getText().toString().trim();
                String passc = pass.getText().toString().trim();
                String cpassc = cpass.getText().toString().trim();

                if (namec.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
                } else if (surnamec.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (emailc.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić email", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailc).matches()) {
                    Toast.makeText(MainActivity.this, "Nie Poprawny e-mail", Toast.LENGTH_SHORT).show();
                } else if (telephonec.length() < 9) {
                    Toast.makeText(MainActivity.this, "Nie Poprawny Nr Telefonu", Toast.LENGTH_SHORT).show();
                }else if (passc.isEmpty()){
                    Toast.makeText(MainActivity.this, "Haslo jest puste", Toast.LENGTH_SHORT).show();
                }else if (!passc.equals(cpassc)) {
                    Toast.makeText(MainActivity.this, "Hasła nie są zgodne", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wysłano", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}