package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDishName, editTextRestaurantName;
    private TextView textViewRateResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDishName = findViewById(R.id.editTextDishName);
        editTextRestaurantName = findViewById(R.id.editTextRestaurantName);
        textViewRateResult = findViewById(R.id.textViewRateResult);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRatingDialog();
            }
        });
    }

    private void showRatingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.rating_dialog, null);
        final RatingBar ratingBar = dialogView.findViewById(R.id.ratingBar);
        Button buttonOk = dialogView.findViewById(R.id.buttonOk);

        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                textViewRateResult.setText(String.valueOf(rating));
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
