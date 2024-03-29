package com.example.mealrater;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRating = findViewById(R.id.textViewRating);

        Button buttonRate = findViewById(R.id.buttonSubmit);
        buttonRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RatingCustomDialog.showRatingDialog(MainActivity.this, new RatingCustomDialog.RatingDialogListener() {
                    @Override
                    public void onRateClicked(float rating) {
                        textViewRating.setText(String.format("Rating: %.1f", rating));
                    }
                });
            }
        });
    }
}
