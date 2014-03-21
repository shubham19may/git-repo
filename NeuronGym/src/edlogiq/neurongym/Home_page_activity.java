package edlogiq.neurongym;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home_page_activity extends Activity {

	DBcontrol controller ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_interface);
		Typeface tf = Typeface.createFromAsset(this.getAssets(),
		        "brand.ttf");
		TextView tv = (TextView) findViewById(R.id.dfghj);
		tv.setTypeface(tf);


	}
	public void games_fun(View v)
	{
		Intent i = new Intent(this, Game_type_options_activity.class);
		
		startActivity(i);
	}
	public void profile_fun(View v)
	{
		Intent i = new Intent(this, Brain_profile_activity.class);
		
		startActivity(i);
	}
}
