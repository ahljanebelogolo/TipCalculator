package com.example.myapplication.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText billAmount;
    private EditText peopleNumber;
    private SeekBar tipPercentage;
    private TextView result1;
    private TextView result2;
    private int tipPercentValue=0;
    private TextView percentLabel;

    double bill ,people,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmount =(EditText)findViewById(R.id.billEditText);
        peopleNumber=(EditText)findViewById(R.id.peopleEditText);
        percentLabel=(TextView) findViewById(R.id.percentageLabel);
        tipPercentage= (SeekBar) findViewById(R.id.percentageSeek);
        result1=(TextView)findViewById(R.id.result1TextView);
        result2=(TextView)findViewById(R.id.result2TextView);


        tipPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                try {
                    tipPercentValue = progress;

                    double totalBill = Double.parseDouble(billAmount.getText().toString());
                    double totalPeople = Double.parseDouble((peopleNumber.getText().toString()));

                    double percentTip = (totalBill * tipPercentValue / 100) / totalPeople;
                    double billTotalAmount = percentTip * totalPeople;

                    if (totalBill == 0) {
                        Toast.makeText(getApplicationContext(), "You inputed ZERO !", Toast.LENGTH_SHORT).show();
                    } else if (totalPeople == 0 && totalBill == 0) {
                        Toast.makeText(getApplicationContext(), "You inputed ZERO !", Toast.LENGTH_SHORT).show();

                    } else {
                        result2.setText(String.valueOf(String.format("%.2f", billTotalAmount)));
                        result1.setText(String.valueOf(String.format("%.2f", percentTip)));

                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Can't Calculate", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                percentLabel.setText(seekBar.getProgress()+"%");
            }
        });

        peopleNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        billAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
