package jp.suntech.s21016.bmicalculators21016;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class Dialog extends DialogFragment {

    @NonNull
    public AlertDialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.Warning);
        builder.setMessage(R.string.Warning_tx);
        builder.setPositiveButton(R.string.Warning_answer, new DialogButtonClickListener());
        return builder.create();
    }

    private static class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which){
        }
    }
}