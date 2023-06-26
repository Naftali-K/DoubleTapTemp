package com.example.doubletaptemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Test_code";

    private Button doubleBtn, oneAndDoubleTapBtn, rightLeftFlingBtn, upDownFlingBtn;
    private TextView rightLeftTextView, upDownTextView;
    GestureDetector doubleTapGestureDetector, oneAndDoubleTapGestureDetector,
            rightLeftTapGestureDetector, upDownTapGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setReferences();
        setGestureDetector();

        doubleBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                doubleTapGestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
        oneAndDoubleTapBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                oneAndDoubleTapGestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
        rightLeftFlingBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                rightLeftTapGestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
        upDownFlingBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                upDownTapGestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
    }

    private void setReferences() {
        doubleBtn = findViewById(R.id.double_btn);
        oneAndDoubleTapBtn = findViewById(R.id.one_and_double_tap_btn);
        rightLeftTextView = findViewById(R.id.right_left_text_view);
        rightLeftFlingBtn = findViewById(R.id.right_left_fling_btn);
        upDownTextView = findViewById(R.id.up_down_text_view);
        upDownFlingBtn = findViewById(R.id.up_down_fling_btn);
    }

    private void setGestureDetector() {

        doubleTapGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Log.d(TAG, "onDoubleTap: Double Tap");
                return super.onDoubleTap(e);
            }
        });

        oneAndDoubleTapGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(@NonNull MotionEvent e) {
                Log.d(TAG, "onDoubleTap: Double Tap");
                return super.onDoubleTap(e);
            }

            @Override
            public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
                Log.d(TAG, "onSingleTapConfirmed: Single Tap");
                return super.onSingleTapConfirmed(e);
            }
        });

        rightLeftTapGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
//                Log.d(TAG, "onFling: Moving1: " + e1 + " \nMotion2: " + e2 + "\nVelocityX: " + velocityX + " \nVelocityY: " + velocityY);

                if (velocityX > 0) {
                    Log.d(TAG, "onFling: Fling to Right");
                    rightLeftTextView.setText("Right");
                } else {
                    Log.d(TAG, "onFling: Fling to Left");
                    rightLeftTextView.setText("Left");
                }

                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });

        upDownTapGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
//                Log.d(TAG, "onFling: Moving1: " + e1 + " \nMotion2: " + e2 + "\nVelocityX: " + velocityX + " \nVelocityY: " + velocityY);

                if (velocityY > 0) {
                    Log.d(TAG, "onFling: Fling to Down");
                    upDownTextView.setText("Down");
                } else {
                    Log.d(TAG, "onFling: Fling to UP");
                    upDownTextView.setText("UP");
                }

                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }
}