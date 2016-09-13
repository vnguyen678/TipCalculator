package edu.orangecoastcollege.cs273.vnguyen678.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static NumberFormat percent = NumberFormat.getPercentInstance();

    // Associate the controll with the needed views
    private EditText amountEditText;
    private TextView amountTextView;
    private TextView tipTextView;
    private TextView tipAmountView;
    private TextView totalAmountTextView;
    private SeekBar  percentSeekBar;

    // Associate the controll with the needed model

    RestaurantBill currentBill = new RestaurantBill();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the controller with the widget in our app
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        tipTextView    = (TextView) findViewById(R.id.tipTextView);
        tipAmountView  = (TextView) findViewById(R.id.pecentTextView);
        totalAmountTextView = (TextView) findViewById(R.id.totalTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.pecentSeekBar);

        // Define a listener for the amountEditText (onTextChange)
        amountEditText.addTextChangedListener(amountTextChangeListener);

        // Define a listener for the percent seekBar {onProgressBar}
        percentSeekBar.setOnSeekBarChangeListener(percentChangeListener);
    }

    private TextWatcher amountTextChangeListener = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {
            // DO NOTTING
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {
            // Try to get amount from amountEditText
            try{
                double amount = Double.parseDouble(charSequence.toString()) / 100.0;
                currentBill.setAmount(amount);
            }
            catch (NumberFormatException e)
            {
                amountEditText.setText("");
            }

            //No Exception input is valid:
            //1) Set the bill amount
            amountTextView.setText((currency.format(currentBill.getAmount())));
            updateView();
        }

        @Override
        public void afterTextChanged(Editable editable)
        {

        }
    };

    private SeekBar.OnSeekBarChangeListener percentChangeListener = new SeekBar.OnSeekBarChangeListener()
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            //update the model with the new tip amount
            currentBill.setTip(i / 100.0);
            //update the percent text view
            tipAmountView.setText(percent.format(currentBill.getTip()));
            //update View
            updateView();


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };




    private void updateView()
    {
        //2) set tip amount(tipTextView)
        tipTextView.setText(currency.format(currentBill.getTipAmount()));
        //3) set Total amount
        totalAmountTextView.setText((currency.format(currentBill.getTotalAmount())));
    }



}
