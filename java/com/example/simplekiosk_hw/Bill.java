package com.example.simplekiosk_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bill extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        TextView text1 = findViewById(R.id.count);
        TextView text2 = findViewById(R.id.price);
        Intent in = getIntent();
        Option data = (Option) in.getSerializableExtra("OBFECT");
        text1.setText(String.valueOf(data.getData1() + " 개"));
        text2.setText(String.valueOf(data.getData2() + " 원"));

        Button re = findViewById(R.id.reset);
        re.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
