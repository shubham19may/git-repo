package edlogiq.neurongym;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Brain_profile_activity extends Activity {

	Score_manager scr_mgr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_brain_profile);
		
	}

	public void overall_fun(View v)
	{
		Intent i = new Intent(this , overall_brain_profile_activity.class);
		startActivity(i);
	
	}
	public void performance_history_fun(View v)
	{
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.xcustom_performance_history_layout);
		dialog.setTitle("Performance History");
		//dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		Button overall = (Button) dialog.findViewById(R.id.button1);
		Button today = (Button) dialog.findViewById(R.id.button2);
		Button seven = (Button) dialog.findViewById(R.id.button3);
		Button thirty = (Button) dialog.findViewById(R.id.button4);
		
		
			
		overall.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext() , Overall_performance_history_activity.class);
				startActivity(i);
				dialog.dismiss();
			}
			
		});

		today.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext() , Today_performance_history_activity.class);
				startActivity(i);
				dialog.dismiss();
			}
			
		});
		seven.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext() , Seven_performance_history_activity.class);
				startActivity(i);
				dialog.dismiss();
			}
			
		});
		thirty.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext() , Thirty_performance_history_activity.class);
				startActivity(i);
				dialog.dismiss();
			}
			
		});
		dialog.show();
	}
}

