package com.moloco.vansampleapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.moloco.van.context.MolocoEntryPoint;
import com.moloco.van.listeners.ApiCallback;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener, ApiCallback<JSONObject> {

	public MainActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_main, container, false);

		Button post_btn = (Button)v.findViewById(R.id.post_button);
		post_btn.setOnClickListener(this);

		Button get_btn = (Button)v.findViewById(R.id.get_button);
		get_btn.setOnClickListener(this);

		TextView textView = (TextView)v.findViewById(R.id.textView);
		textView.setMovementMethod(new ScrollingMovementMethod());

		return v;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.post_button: {
				HashMap<String, Object> dataMap = new HashMap<String, Object>();
				dataMap.put("username", "Ethan");
				dataMap.put("latitude", 0.123923f);
				dataMap.put("longitude", 0.5346123f);
				MolocoEntryPoint.SendEvent("test", dataMap, MainActivityFragment.this);
			} break;
			case R.id.get_button: {
				MolocoEntryPoint.GetEvent("test", MainActivityFragment.this);
			} break;
			default:
				break;
		}
	}

	@Override
	public void handleResponse(JSONObject jsonObject) {
		TextView textView = (TextView) getView().findViewById(R.id.textView);
		textView.setText(String.format("%s", jsonObject));
		Log.d("com.moloco.vansample", String.format("Get JSON : %s", jsonObject));
	}
}
