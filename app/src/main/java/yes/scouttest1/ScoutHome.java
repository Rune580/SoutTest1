package yes.scouttest1;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.ToggleButton;

public class ScoutHome extends AppCompatActivity {

    private String botTypeSelected ="Defence";
    private String frameType="Custom";
    public ToggleButton KOPFrameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        KOPFrameButton = (ToggleButton) findViewById(R.id.DefualtFrame);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scout_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save_exit) {
            toasting("Save & Exit code here");


            DialogFragment SaveExitConfirm = new SaveAndExitDialog();
            SaveExitConfirm.show(getFragmentManager(), "saveandexitconfirmation");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onToggleKOPFrame(View view) {
        if (KOPFrameButton.isChecked())
            frameType="KOP";
        else
            frameType="Custom";
    }

    public void onBotTypeSelection(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.FuelType:
                if (checked)
                    botTypeSelected ="Fuel";
                    break;
            case R.id.GearType:
                if (checked)
                    botTypeSelected ="Gears";
                    break;
            case R.id.BothType:
                if (checked)
                    botTypeSelected ="Fuel & Gears";
                break;
            case R.id.DefenceType:
                if (checked)
                    botTypeSelected ="Defence";
                break;
        }
    }

    public void saveAndNext(View view) {
        toasting(frameType + " Bot, " + botTypeSelected + " Type, Save & Next code here");
    }

    public void toasting(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
