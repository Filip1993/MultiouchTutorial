package com.filipkesteli.multiouchtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2, ed3, ed4;
    private TextView tv1;
    private float xAxis = 0f;
    private float yAxis = 0f;
    private float lastXAxis = 0f;
    private float lastYAxis = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);
        tv1 = (TextView) findViewById(R.id.textView2);
    }

    private void setupListeners() {
        tv1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int actionPeformed = event.getAction();

                switch (actionPeformed) {
                    case MotionEvent.ACTION_DOWN: {
                        final float x = event.getX();
                        final float y = event.getY();

                        lastXAxis = x;
                        lastYAxis = y;

                        ed1.setText(Float.toString(lastXAxis));
                        ed2.setText(Float.toString(lastYAxis));
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        final float x = event.getX();
                        final float y = event.getY();

                        final float dx = x - lastXAxis;
                        final float dy = y - lastYAxis;

                        xAxis += x;
                        yAxis += y;

                        ed3.setText(Float.toString(xAxis));
                        ed4.setText(Float.toString(yAxis));
                        break;
                    }
                }
                return true;
            }
        });
    }
}
