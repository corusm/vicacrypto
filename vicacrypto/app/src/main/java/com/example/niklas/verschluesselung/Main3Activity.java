package com.example.niklas.verschluesselung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    EditText text;
    EditText key;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text = findViewById(R.id.editText);
        key = findViewById(R.id.editKey);
        textView = findViewById(R.id.output);
    }

    public void encrypt(View view) {
        textView.setText(vigenere(text.getText().toString(), key.getText().toString(), 1));
    }

    public void decrypt(View view) {
        textView.setText(vigenere(text.getText().toString(), key.getText().toString(), 0));
    }

    public static String vigenere(String text, String key, int mode) {
        text = text.toUpperCase();
        text = text.replaceAll(" ", "");
        key = key.toUpperCase();
        String returnText = "";
        for (int i = 0, j = 0; i < text.length(); i++, j++) {
            //i: Zähler für text; j: Zähler für key
            if (j == key.length()) {
                j = 0;
                //Wenn Schlüsselwort durchlaufen, dann wieder von vorne
            }
            if (mode == 1){
                returnText += (char) ((text.charAt(i) + key.charAt(j) - 130) % 26 + 65);
                //Verschlüsselung
            }
            if (mode == 0) {
                returnText += (char) ((text.charAt(i) - key.charAt(j) + 130) % 26 + 65);
                //Entschlüsselung
            }
        }
        return returnText;
    }
}
