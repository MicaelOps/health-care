
package com.Android3;

import com.Android3.Service.ISHandler;
import com.Android3.Core.InfoChannels;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.os.Bundle;

public class Init extends Activity
{

	private ISHandlerReceiver hreceiver;
	

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    	this.getActionBar().hide();
    	super.onCreate(savedInstanceState);

		draw();
		handlers();
		//ServerMain main = new ServerMain();
	
		
		Intent intent = new Intent(this, ISHandler.class);
		startService(intent);
    }

	@Override
	protected void onStop() {
		super.onStop();
		unregisterReceiver(hreceiver);
	}


	private void handlers() {

		hreceiver = new ISHandlerReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction(InfoChannels.GPS.getName());
		registerReceiver(hreceiver, filter);
	}
	

    private void draw() { 

		this.getActionBar().hide();
    	TextView  tv = new TextView(this);
        tv.setText("Server not online");

		Button button = new Button(this);
		button.setText("try again");
		button.setOnClickListener( new android.view.View.OnClickListener() {
			@Override
			public void onClick(View view) {

				android.widget.Toast.makeText(getApplicationContext(), "failed", android.widget.Toast.LENGTH_SHORT).show();

			}
		});

		android.widget.LinearLayout layout = new android.widget.LinearLayout(this);
		layout.addView(tv);	
		layout.setBackgroundColor(Color.BLACK);
        setContentView(layout);
    }

    private class ISHandlerReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			//change
		}
    }
}
