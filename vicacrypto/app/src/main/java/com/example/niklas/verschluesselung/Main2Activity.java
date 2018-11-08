package com.example.niklas.verschluesselung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {
    HashMap<Character, Character> verschl;
    HashMap<Character, Character> entschl;

    EditText editText;
    EditText editKey;
    TextView output;
    private int status = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.editText);
        editKey = (EditText) findViewById(R.id.editShift);
        output = findViewById(R.id.output);
    }

    public void exe(View view) {
        String getText = editText.getText().toString();
        int getKey = Integer.parseInt(editKey.getText().toString());

        if (status == 1) {
            output.setText(encode(getText, getKey));
            status = 3;
        }
        if (status == 2) {
            output.setText(decode(getText, getKey));
            status = 3;
        }
    }

    public void enButton(View view) {
        status = 1;
    }

    public void deButton(View view) {
        status = 2;
    }



    public Main2Activity() {
        super();
        verschl = new HashMap<Character, Character>();
        entschl = new HashMap<Character, Character>();
    }

    public String decode(String text, int shift){
        initVersch(shift);
        return transl(text, entschl);
    }

    public String encode(String text, int shift){
        initVersch(shift);
        return transl(text, verschl);
    }

    private String transl(String text, HashMap<Character, Character> alphabet){
        String lowercase = text.toUpperCase().replace(" ","");

        String output = "";

        for(int i=0; i < lowercase.length(); i++) {
            output += alphabet.get(lowercase.charAt(i));
        }

        return output;
    }

    private void initVersch(int shift) {
        for (char loop='A'; loop<='Z';loop++){
            if((loop+shift) <= 'Z'){
                verschl.put(loop, (char) (loop+shift));
                entschl.put((char) (loop+shift), loop);
            }
            else {
                verschl.put(loop, (char) (loop+shift-26));
                entschl.put((char) (loop+shift-26), loop);
            }
        }
    }
}
