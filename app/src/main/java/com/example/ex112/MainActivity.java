package com.example.ex112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.textView);
        
        getData();
    }

    private void getData() {
        SharedPreferences settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        String str = settings.getString("str","");
        counter = settings.getInt("counter",0);
        et.setText(str);
        tv.setText(String.valueOf(counter));
    }

    public void count(View view) {
        counter++;
        tv.setText(String.valueOf(counter));
    }

    public void reset(View view) {
        counter = 0;
        et.setText("");
        save();

    }

    private void save() {
        SharedPreferences.Editor editor = getSharedPreferences("PREFS_NAME", MODE_PRIVATE).edit();
        editor.putString("str", et.getText().toString());
        editor.putInt("counter",counter);
        editor.commit();
    }

    public void exit(View view) {
        save();
        finish();
    }
}