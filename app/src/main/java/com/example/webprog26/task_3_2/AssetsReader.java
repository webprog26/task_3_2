package com.example.webprog26.task_3_2;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by webprog26 on 11.10.2016.
 */

public class AssetsReader implements Readable{

    private static final String TAG = "AssetsReader";


    private AssetManager mAssetManager;
    private Activity mActivity;

    public AssetsReader(Activity activity) {
        this.mActivity = activity;
        mAssetManager = mActivity.getAssets();
    }

    @Override
    public String getTxtFile(String fileName)
    {
        BufferedReader reader = null;
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try{
            inputStream = mAssetManager.open(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while((line = reader.readLine()) != null)
            {
                Log.i(TAG, line);
                builder.append(line);
                builder.append("\n");
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        } finally {

            if(inputStream != null)
            {
                try {
                    inputStream.close();
                } catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }

            if(reader != null)
            {
                try {
                    reader.close();
                } catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }
        Log.i(TAG, "builder.toString(): " + builder.toString());
        return builder.toString();
    }
}
