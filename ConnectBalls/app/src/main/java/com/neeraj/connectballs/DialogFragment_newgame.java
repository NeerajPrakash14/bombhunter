package com.neeraj.connectballs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogFragment_newgame extends AppCompatDialogFragment {

    String result;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View v = inflater.inflate(R.layout.dialog_fragment_newgame, null);

        builder.setView(v)
                .setTitle(result)
                .setCancelable(true)
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getContext(), OpenActivity.class);
                        startActivity(intent);
                    }
                })
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);

                    }

                });
        return builder.create();
    }

    public void setResult(int flag) {
        if (flag == 1) {
            result = "CONGRATULATIONS! YOU WON";
        } else {
            result = "OOPS! YOU LOST";
        }
    }

}


