package com.example.webprog26.task_3_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainAppActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvPoem = (TextView) findViewById(R.id.tvPoem);

        AssetsReader assetsReader = new AssetsReader(this);

        Log.i(TAG, assetsReader.getTxtFile(getResources().getString(R.string.poem_file_title)));

        if(assetsReader.getTxtFile(getResources().getString(R.string.poem_file_title)) != null)
        {
            tvPoem.setText(assetsReader.getTxtFile(getResources().getString(R.string.poem_file_title)));
        }
    }
}
