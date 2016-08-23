package com.shahar.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private FuctsBook myBook = new FuctsBook();
    private  ColorSet curColor = new ColorSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //declaring and inisialize our variables
        final TextView factLable = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.funFactLayout);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the "next fact" button was clicked , we now change the factlable to a new one
                String fact = myBook.getFact();
                factLable.setText(fact);
                int color = curColor.getColor();
                myLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);

            }
        };
        showFactButton.setOnClickListener(listener);

        // ways for debugging : 1: toast messages: they will appear on the screen while the app is running
        Toast.makeText(this, "yeah! the acticity started succesfully =)", Toast.LENGTH_LONG).show();
        //2: log messages, there are few types of messages: .d - debug, .w - warnings, .e - errors, we can choose which type to see after.
        Log.d(TAG, "hey! we are logging within the onCreate method!");
    }
}
