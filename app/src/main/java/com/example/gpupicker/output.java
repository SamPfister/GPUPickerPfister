package com.example.gpupicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class output extends AppCompatActivity {
    public static final String RG_TEXT = "blank";
    public static final String CB1_VAL = "blank2";
    public static final String CB2_VAL = "blank3";
    public static final String CB3_VAL = "blank4";
    public static final String CB4_VAL = "blank5";
    public static final String CB5_VAL = "blank6";
    public static final String SWITCH_VAL = "blank7";
    public static final String SPINNER_VAL = "blank8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Intent intent = getIntent();
        String radioGroup = intent.getStringExtra(RG_TEXT);
        String checkbox1 = intent.getStringExtra(CB1_VAL);
        String checkbox2 = intent.getStringExtra(CB2_VAL);
        String checkbox3 = intent.getStringExtra(CB3_VAL);
        String checkbox4 = intent.getStringExtra(CB4_VAL);
        String checkbox5 = intent.getStringExtra(CB5_VAL);
        String switchvalue = intent.getStringExtra(SWITCH_VAL);
        String spinnervalue = intent.getStringExtra(SPINNER_VAL);
        String GPUchoice;
        if(radioGroup.equals("Nvidia")){
            if(switchvalue.equals("true")){
                if(spinnervalue.equals("1440p") || spinnervalue.equals("4K")) {
                    if (checkbox3.equals("true") || checkbox5.equals("true")) {
                        GPUchoice = "GTX 1080ti";
                    }
                    else{
                        GPUchoice = "GTX 1070";
                    }
                }
                else{
                    GPUchoice = "GTX 1050ti";
                }
            }
            else{
                if(spinnervalue.equals("1440p") || spinnervalue.equals("4K")) {
                    if (checkbox3.equals("true") || checkbox5.equals("true")) {
                        GPUchoice = "RTX 2080";
                    }
                    else{
                        GPUchoice = "RTX 2060";
                    }
                }
                else{
                    GPUchoice = "GTX 1650";
                }
            }
        }
        else{
            if(switchvalue.equals("true")){
                if(spinnervalue.equals("1440p") || spinnervalue.equals("4K")) {
                    if (checkbox3.equals("true") || checkbox5.equals("true")) {
                        GPUchoice = "RX 590 pair in CrossFire";
                    }
                    else{
                        GPUchoice = "RX 590";
                    }
                }
                else{
                    GPUchoice = "RX 570";
                }
            }
            else{
                if(spinnervalue.equals("1440p") || spinnervalue.equals("4K")) {
                    if (checkbox3.equals("true") || checkbox5.equals("true")) {
                        GPUchoice = "RX 5700XT";
                    }
                    else{
                        GPUchoice = "RX 5700 or Vega 64";
                    }
                }
                else{
                    GPUchoice = "Vega 56";
                }
            }
        }
        String finalOutput = "We recommend a(n) " + GPUchoice;
        TextView str = (TextView) findViewById(R.id.textView);
        str.setText(finalOutput);
    }
}
