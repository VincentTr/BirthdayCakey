package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        CakeView view = findViewById(R.id.cakeview);
        CakeController control = new CakeController(view);

        //cp2
        //retrieve the reference to the "Blow Out" button (step 11)
        Button blowButton = findViewById(R.id.blowOutButton);
        blowButton.setOnClickListener(control);

        //cp3
        Switch candleSwitch = findViewById(R.id.candleSwitch);
        candleSwitch.setOnCheckedChangeListener(control);

        //cp4
        SeekBar candleSeekBar = findViewById(R.id.numOfCandlesSeekBar);
        candleSeekBar.setOnSeekBarChangeListener(control);

    }
    public void goodbye(View button){
        Log.i("button", "Goodbye");
        finishAffinity();
    }
}
