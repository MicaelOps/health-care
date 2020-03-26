
package com.Android3.Service;

import android.app.IntentService;
import android.content.Intent;

public class ISHandler extends IntentService
{


	/**
		Starts the Collection information system
		Acessing server to begin heartbeat tasks
	*/


	public ISHandler(){
		super("ICollector");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		if(intent == null) {
			return;
		}

		long started = intent.getLongExtra("started", -1);


		//connect to server papapapa
	}


	private void feedbackMessage(String string, String[] log) {
		Intent intent = new Intent();
		intent.setAction(string); // feedback

		if(log != null) {
			intent.putExtra("logs", log);
		}

		sendBroadcast(intent);
	}
}
