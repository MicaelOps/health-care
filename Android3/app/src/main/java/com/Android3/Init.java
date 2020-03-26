
package com.Android3;

import com.Android3.Core.ServerMain;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Button;
import android.graphics.Color;
import android.view.View;
import android.os.Bundle;

public class Init extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    	this.getActionBar().hide();
	
        super.onCreate(savedInstanceState);

		draw();
		
		ServerMain main = new ServerMain();
		if(main.connect()) {
			
		}
		
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
}
