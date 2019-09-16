package com.example.gpupicker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // radio button code from https://www.mkyong.com/android/android-radio-buttons-example/
        // spinner code from https://developer.android.com/guide/topics/ui/controls/spinner
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.monitor_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        Toast.makeText(MainActivity.this, "Select a brand", Toast.LENGTH_SHORT).show();
    }
    public void addListenerOnButton() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnDisplay = (Button) findViewById(R.id.button);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox1:
                if (checked){
                    Toast.makeText(MainActivity.this, "check box 1 checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox2:
                if (checked){
                    Toast.makeText(MainActivity.this, "check box 2 checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox3:
                if (checked){
                    Toast.makeText(MainActivity.this, "check box 3 checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox4:
                if (checked){
                    Toast.makeText(MainActivity.this, "check box 4 checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox5:
                if (checked){
                    Toast.makeText(MainActivity.this, "check box 5 checked", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    public void switchClick(View view){
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        boolean switchState = simpleSwitch.isChecked();

        if(switchState){
            Toast.makeText(MainActivity.this, "The switch is on", Toast.LENGTH_SHORT).show();
            switchState = false;
        }
        else{
            Toast.makeText(MainActivity.this, "The switch is off", Toast.LENGTH_SHORT).show();
            switchState = true;
        }
    }

    public void sendInfo(View v){
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String rgText = (String) radioButton.getText();
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox cb5 = (CheckBox) findViewById(R.id.checkBox5);
        boolean cbval1 = cb1.isChecked();
        boolean cbval2 = cb2.isChecked();
        boolean cbval3 = cb3.isChecked();
        boolean cbval4 = cb4.isChecked();
        boolean cbval5 = cb5.isChecked();
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        boolean switchval = switch1.isChecked();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String spinnerval = spinner.getSelectedItem().toString();
        Intent intent = new Intent(this, output.class);
        intent.putExtra(output.RG_TEXT, rgText);
        intent.putExtra(output.CB1_VAL, cbval1);
        intent.putExtra(output.CB2_VAL, cbval2);
        intent.putExtra(output.CB3_VAL, cbval3);
        intent.putExtra(output.CB4_VAL, cbval4);
        intent.putExtra(output.CB5_VAL, cbval5);
        intent.putExtra(output.SWITCH_VAL, switchval);
        intent.putExtra(output.SPINNER_VAL, spinnerval);
    }

}

