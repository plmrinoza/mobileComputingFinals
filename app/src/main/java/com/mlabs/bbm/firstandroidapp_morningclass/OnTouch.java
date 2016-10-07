package com.mlabs.bbm.firstandroidapp_morningclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.view.InputEvent;
import android.widget.TextView;
import android.widget.Toast;

public class OnTouch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontouch);

        final ImageView image = (ImageView)findViewById(R.id.touchme);

        final TextView textViewX1 = (TextView) findViewById(R.id.x1);
        final TextView textViewX2 = (TextView) findViewById(R.id.x2);
        final TextView textViewY1 = (TextView) findViewById(R.id.y1);
        final TextView textViewY2 = (TextView) findViewById(R.id.y2);

        final TextView diff = (TextView) findViewById(R.id.diff);
        final TextView motion = (TextView) findViewById(R.id.motion);
        final TextView quad = (TextView) findViewById(R.id.quadrant);

        image.setOnTouchListener(new View.OnTouchListener() {

            float x1, y1, x2, y2, difX, difY;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        y1 = event.getY();

                        textViewX1.setText("x1: " + String.valueOf(x1));
                        textViewY1.setText("y1: " + String.valueOf(y1));


                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        y2 = event.getY();

                        difX = x2 - x1;
                        difY = y2 - y1;

                        textViewX2.setText("x2: " + String.valueOf(x2));
                        textViewY2.setText("y2: " + String.valueOf(y2));

                        diff.setText("Difference: x=" + String.valueOf(difX) + "\n y=" + String.valueOf(difY));

                        if (difX > 0 && difY < 0) {
                            motion.setText("Motion: right-up");
                            quad.setText("Quadrant: 1");
                        }
                        else if (difX < 0 && difY < 0) {
                            motion.setText("Motion: left-up");
                            quad.setText("Quadrant: 2");
                        }
                        else if (difX < 0 && difY > 0) {
                            motion.setText("Motion: left-down");
                            quad.setText("Quadrant: 3");
                        }
                        else if (difX > 0 && difY > 0) {
                            motion.setText("Motion: right-down");
                            quad.setText("Quadrant: 4");
                        }
                        else if (x1 < x2)
                            motion.setText("right");
                        else if (x1 > x2)
                            motion.setText("left");
                        else if (y1 < y2)
                            motion.setText("down");
                        else if (y1 > y2)
                            motion.setText("up");
                }
                return true;
            }
        });
    }
}