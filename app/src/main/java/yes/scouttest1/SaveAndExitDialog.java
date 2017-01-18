package yes.scouttest1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class SaveAndExitDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.u_sure)
                .setPositiveButton(R.string.yas, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //yes
                    }
                })
                .setNegativeButton(R.string.no_plz, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //no
                    }
                })
                .setNeutralButton(R.string.meh, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //neutral
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}