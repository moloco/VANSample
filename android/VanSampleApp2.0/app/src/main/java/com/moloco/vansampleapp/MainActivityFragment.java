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

import com.moloco.van.context.MolocoVAN;
import com.moloco.van.Constants;
import com.moloco.van.listeners.ApiCallback;

import java.util.HashMap;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment
    extends Fragment implements View.OnClickListener, ApiCallback {

  public MainActivityFragment() {

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_main, container, false);

    Button sendBtn = (Button) v.findViewById(R.id.send_button);
    sendBtn.setOnClickListener(this);

    Button customSendBtn = (Button) v.findViewById(R.id.custom_send_button);
    customSendBtn.setOnClickListener(this);

    TextView textView = (TextView) v.findViewById(R.id.text_view);
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
        MolocoVAN.sendEvent(Constants.EventType.PURCHASE, dataMap, MainActivityFragment.this);
      }
      break;
      case R.id.custom_send_button: {
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("username", "moloco");
        dataMap.put("location", "seoul");
        MolocoVAN.sendCustomEvent(Constants.CustomEventType.CUSTOM_00, "android_sample_app_click_test", dataMap, MainActivityFragment.this);
      }
      break;
      default:
        break;
    }
  }

  @Override
  public void onSuccessResponse(String response) {
    TextView textView = (TextView) getView().findViewById(R.id.text_view);
    textView.setText("MolocoVAN result:\nSuccess!");
    Log.d(com.moloco.van.Constants.LOG, "MolocoVAN result: success!");
  }

  @Override
  public void onFailureResponse(String response) {
    TextView textView = (TextView) getView().findViewById(R.id.text_view);
    textView.setText(String.format("MolocoVAN result:\nFailed (%s)", response));
    Log.d(com.moloco.van.Constants.LOG, String.format("MolocoVAN result: failed (%s)", response));
  }
}
