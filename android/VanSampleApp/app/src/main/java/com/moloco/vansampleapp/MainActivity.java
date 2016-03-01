package com.moloco.vansampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.moloco.van.context.MolocoEntryPoint;
import com.moloco.van.listeners.ApiCallback;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Send one event before initializing MolocoEntryPoint. This is not actually sent to VAN
        // server until the library is initialized by {@link MolocoEntryPoint#init(Context, String)}.
        MolocoEntryPoint.sendEvent("beforeInitEvent", new HashMap<String, Object>(), new ApiCallback<String>() {
            @Override
            public void handleResponse(String response) {
                Log.d("com.moloco.vansample", String.format(
                        "Got response from event sent before initialization : %s", response));
            }
        });

        // Initialize Moloco VAN SDK library.
        // The second parameter must be a unique string for each app.
        MolocoEntryPoint.init(this, "MolocoVanSample");
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
