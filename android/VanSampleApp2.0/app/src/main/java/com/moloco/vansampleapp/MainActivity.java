package com.moloco.vansampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.moloco.van.Constants.EventType;
import com.moloco.van.context.MolocoVAN;
import com.moloco.van.listeners.ApiCallback;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Send one event before initializing MolocoVAN. This is not actually sent to VAN
        // server until the library is initialized by {@link MolocoVAN#init(Context, String, String)}.
        MolocoVAN.sendEvent(EventType.REGISTER, new HashMap<String, Object>(), new ApiCallback() {
            @Override
            public void onSuccessResponse(String response) {
                Log.d(Constants.BUNDLE_NAME, String.format(
                        "Got success response from event sent before initialization : %s", response));
            }

            @Override
            public void onFailureResponse(String response) {
                Log.d(Constants.BUNDLE_NAME, String.format(
                    "Got failure response from event sent before initialization : %s", response));
            }
        });

        // Initialize Moloco VAN SDK library.
        // The second parameter must be a unique string for each app.
        MolocoVAN.init(this, "sdk_sample_android", "9efaa15f84ed47b68f52f837a0948eda");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
