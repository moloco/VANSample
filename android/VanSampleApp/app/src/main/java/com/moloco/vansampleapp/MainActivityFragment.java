package com.moloco.vansampleapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.moloco.van.context.MolocoContext;
import com.moloco.van.context.MolocoEntryPoint;
import com.moloco.van.listeners.ApiCallback;

import java.util.HashMap;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener, ApiCallback<String> {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        Button post_btn = (Button) v.findViewById(R.id.send_button);
        post_btn.setOnClickListener(this);

        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_button: {
                    HashMap<String, Object> dataMap = new HashMap<String, Object>();
                    dataMap.put("username", "moloco");
                    dataMap.put("latitude", 0.123923f);
                    dataMap.put("longitude", 0.5346123f);
                    MolocoEntryPoint.sendEvent("clickEvent", dataMap, MainActivityFragment.this);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void handleResponse(String jsonObject) {
        TextView textView = (TextView) getView().findViewById(R.id.textView);
        textView.setText(String.format("Result: %s", jsonObject));
        Log.d("com.moloco.vansample", String.format("Result for click event : %s", jsonObject));

        Log.d("com.moloco.vansample", String.format(
                "Device Info\nIDFA : %s\nModel : %s\nLocation : %s\nCarrier : %s",
                MolocoContext.INSTANCE.getAdvertisingId(),
                MolocoContext.INSTANCE.getDeviceInfo(),
                MolocoContext.INSTANCE.getLocation(),
                MolocoContext.INSTANCE.getCarrier()
        ));
    }
}
