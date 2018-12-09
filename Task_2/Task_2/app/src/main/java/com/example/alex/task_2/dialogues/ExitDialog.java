package com.example.alex.task_2.dialogues;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.alex.task_2.R;
import com.example.alex.task_2.interfaces.ExitDialogHandler;


public class ExitDialog extends DialogFragment {

    // Вызывается при конструкции диалога
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.exit_dialog_message)
                .setPositiveButton(R.string.exit_dialog_ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // согласие
                        ((ExitDialogHandler)getActivity()).onExit();
                    }
                })
                .setNegativeButton(R.string.exit_dialog_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // отмена
                    }
                });

        // Создает диалог и возвращает его
        return builder.create();
    }
}

