package com.example.simplekiosk_hw;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Menu extends AppCompatActivity {
    EditText chicken,pasta,pizza,steak,lobstar,drink;
    Button button;
    CheckBox check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("음식 주문하기");
        init();
    }
    void init() {
         chicken = findViewById(R.id.chickenCount);
         pasta = findViewById(R.id.pastaCount);
         pizza = findViewById(R.id.pizzaCount);
         steak = findViewById(R.id.steakCount);
         lobstar = findViewById(R.id.lobstarCount);
         drink = findViewById(R.id.drinkCount);
         button = findViewById(R.id.resultBtn);
         check = findViewById(R.id.checkBox);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chickenEdit = chicken.getText().toString();
                String pastaEdit = pasta.getText().toString();
                String pizzaEdit = pizza.getText().toString();
                String steakEdit = steak.getText().toString();
                String lobstarEdit = lobstar.getText().toString();
                String drinkEdit = drink.getText().toString();

                int chickenCount,pastaCount,pizzaCount,steakCount,lobstarCount,drinkCount;

                if(chickenEdit.getBytes().length==0){
                    chickenCount = 0;
                }else{
                    chickenCount = Integer.parseInt(chickenEdit);
                }
                if(pastaEdit.getBytes().length==0){
                    pastaCount = 0;
                }else{
                    pastaCount = Integer.parseInt(pastaEdit);
                }
                if(pizzaEdit.getBytes().length==0){
                    pizzaCount = 0;
                }else{
                    pizzaCount = Integer.parseInt(pizzaEdit);
                }
                if(steakEdit.getBytes().length==0){
                    steakCount = 0;
                }else{
                    steakCount = Integer.parseInt(steakEdit);
                }
                if(lobstarEdit.getBytes().length==0){
                    lobstarCount = 0;
                }else{
                    lobstarCount = Integer.parseInt(lobstarEdit);
                }
                if(drinkEdit.getBytes().length==0){
                    drinkCount = 0;
                }else{
                    drinkCount = Integer.parseInt(drinkEdit);
                }
                int count = chickenCount+pastaCount+pizzaCount+
                        steakCount+lobstarCount+drinkCount;
                double result;

                if(check.isChecked() == true){
                    result = (chickenCount*16000)+(pastaCount*12000)+
                            (pizzaCount*14000)+(steakCount*23000)+
                            (lobstarCount*280000)+(drinkCount*2000);
                    result = result - (result*0.1);
                }else{
                    result = (chickenCount*16000)+(pastaCount*12000)+
                            (pizzaCount*14000)+(steakCount*23000)+
                            (lobstarCount*280000)+(drinkCount*2000);
                }
                Option data = new Option();
                data.setData1(count);
                data.setData2((int)result);
                Intent in = new Intent(getApplicationContext(), Bill.class);
                in.putExtra("OBFECT",data);
                startActivity(in);
            }
        });
    }
}
