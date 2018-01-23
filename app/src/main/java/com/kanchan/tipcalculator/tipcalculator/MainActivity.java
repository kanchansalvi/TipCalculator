package com.kanchan.tipcalculator.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText amnt;
    private TextView totamnt;
    private TextView resamnt;
    private SeekBar peramnt;
    private Button calc;
    private int seekper;
  private float enteredbill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amnt = (EditText) findViewById(R.id.amountID);
        totamnt = (TextView) findViewById(R.id.textViewID);
        resamnt = (TextView) findViewById(R.id.resultID);
        peramnt = (SeekBar) findViewById(R.id.seekBarID);
        calc = (Button) findViewById(R.id.buttonID);

        calc.setOnClickListener(this);

        peramnt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                totamnt.setText(String.valueOf(seekBar.getProgress()) + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            seekper = seekBar.getProgress();
            }
        });
    }

    @Override
    public void onClick(View v) {
        calculate();

    }

    public void calculate(){
        float result = 0.0f;
        if(!amnt.getText().toString().equals("")) {
            enteredbill = Float.parseFloat(amnt.getText().toString());
            result = enteredbill * seekper/100;
            resamnt.setText("Your Tip is : $"+ result + "\nYour Total Bill is : $" + String.valueOf(result + enteredbill));
        }
        else {
            Toast.makeText(MainActivity.this,"Please enter Bill Amount", Toast.LENGTH_LONG). show();
        }
        }


}

