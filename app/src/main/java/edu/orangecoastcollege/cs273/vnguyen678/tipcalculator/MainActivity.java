package edu.orangecoastcollege.cs273.vnguyen678.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        tipTextView    = (TextView) findViewById(R.id.pecentTextView);
        tipAmountView  = (TextView) findViewById(R.id.tipTextView);
        totalAmountTextView = (TextView) findViewById(R.id.totalTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.pecentSeekBar);

        // Define a listener for the amountEditText (onTextChange)
        amountEditText.addTextChangedListener(amountTextChangeListener);
    }

    private TextWatcher amountTextChangeListener = new TextWatcher() {
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
        }

        @Override
        public void afterTextChanged(Editable editable)
        {

        }
    }


}
