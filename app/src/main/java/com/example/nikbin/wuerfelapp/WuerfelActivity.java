package com.example.nikbin.wuerfelapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WuerfelActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_textview_rolldice) TextView rollDice;
    @BindView(R.id.activity_main_textview_shownumber) TextView showNumber;
    @BindView(R.id.activity_main_button_finish) Button finishButton;
    @BindView(R.id.activity_main_imageview_dice) ImageView diceImage;
    private RotateAnimation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // a Button that finishes the app when clicked
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation.start();
                int result = rollTheDice();
                String resultAsText = String.valueOf(result);
                showNumber.setText(resultAsText);
            }
        });

        animateRollTheDiceImage(diceImage);
        fadeInViews(300, 500, diceImage);
        fadeInViews(600, 1100, rollDice);
    }

    /**
     * method for rolling a dice with 6 sides
     *
     * @return the random number between 1 and 6
     */
    public int rollTheDice() {
        int randomnumber;
        randomnumber = (int) (Math.random() * 6) + 1;
//        Log.d("MJA", "rollTheDice: " + randomnumber); --> gives method.not-mocked error in unit test
        return randomnumber;
    }

    /**
     * Fades in specified View with specified duration and offset timing.
     * By using an {@link AlphaAnimation} we control the alpha level of an object, which is
     * useful for fading things in and out.
     *
     * @param fadeInDuration    duration of the fade in animation
     * @param fadeInOffset      offset of the fade in animation
     * @param view              view to fade in
     */
    private void fadeInViews(int fadeInDuration, int fadeInOffset, View view){
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(fadeInDuration);
        fadeIn.setStartOffset(fadeInOffset);
        view.setAnimation(fadeIn);
    }


    private void animateRollTheDiceImage(ImageView imageView){
//        imageView.setImageDrawable(AppCompatDrawableManager.get().getDrawable(this, R.drawable.red_dice));
        animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(500);
        imageView.startAnimation(animation);
//        messageTextView = (TextView) findViewById(R.id.customview_waitingscreen_textview_message);
//        if (messageTextView != null) {
//            messageTextView.setText(title);
//        }

    }
}
