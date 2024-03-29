package com.example.mealrater;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class RatingCustomDialog {

    public interface RatingDialogListener {
        void onRateClicked(float rating);
    }

    public static void showRatingDialog(Context context, final RatingDialogListener listener) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.rating_dialog);

        final RatingBar ratingBar = dialog.findViewById(R.id.ratingBar);
        Button buttonRateDialog = dialog.findViewById(R.id.buttonRateDialog);

        buttonRateDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                if (listener != null) {
                    listener.onRateClicked(rating);
                }
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
