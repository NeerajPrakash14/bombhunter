package com.neeraj.connectballs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogFragment_rules extends AppCompatDialogFragment {

    String result;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View v = inflater.inflate(R.layout.dialog_fragment_rules, null);

        builder.setView(v)
                .setCancelable(true)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


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


