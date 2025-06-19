package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // You can add button listeners here if needed
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Reference to the user info TextView
        final TextView userInfoText = findViewById(R.id.userInfoText);
        // Store current values
        final String[] currentUsername = {"N.H.M.Dilhara"};
        final String[] currentEmail = {"2022t01525@stu.cmb.ac.lk"};

        Button editInfoButton = findViewById(R.id.editInfoButton);
        editInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.edit_info_dialog, null);
                builder.setView(dialogView);
                AlertDialog dialog = builder.create();

                EditText editUsername = dialogView.findViewById(R.id.editUsername);
                EditText editEmail = dialogView.findViewById(R.id.editEmail);
                editUsername.setText(currentUsername[0]);
                editEmail.setText(currentEmail[0]);

                Button okButton = dialogView.findViewById(R.id.okButton);
                Button cancelButton = dialogView.findViewById(R.id.cancelButton);

                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String newUsername = editUsername.getText().toString();
                        String newEmail = editEmail.getText().toString();
                        currentUsername[0] = newUsername;
                        currentEmail[0] = newEmail;
                        userInfoText.setText("\n    Username : " + newUsername + "\n\n    E-mail :\n    " + newEmail);
                        dialog.dismiss();
                    }
                });

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        Button signOutButton = findViewById(R.id.signOutButton);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.signout_confirm_dialog, null);
                builder.setView(dialogView);
                AlertDialog dialog = builder.create();

                Button yesButton = dialogView.findViewById(R.id.yesButton);
                Button noButton = dialogView.findViewById(R.id.noButton);

                yesButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                });

                noButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
} 