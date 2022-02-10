package cs301.birthdaycake;


import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;


public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
, SeekBar.OnSeekBarChangeListener, View.OnTouchListener{

    private CakeView view;
    private CakeModel model;

    public void onClick(View v){
        Log.d("BlowOut", "It Worked!");
        //cp2 step 12
        model.lit = false;
        //cp2 step 13
        view.invalidate();
    }

    public CakeController(CakeView initView) {
        this.view = initView;
        model = view.getCake();
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.d("Candles", "It worked!!!");
        if (model.hasCandles == true) {
            model.hasCandles = false;
        }
        else{
            model.hasCandles = true;
        }
        view.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //Do some magic :)
        Log.d("SeekBar for number of Candles", "Number of candles worked!");
        model.numOfCandles = i;
        view.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //no need
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //no thanks
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            model.x = x;
            model.y = y;
            view.invalidate();
        }
        return true;
    }
}
