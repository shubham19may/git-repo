package edlogiq.neurongym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class training_page_activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.training_page_layout);
	}

	public void logout_fun(View v)
	{
		Intent i = new Intent(this, Login_screen_activity.class);
		finish();
		startActivity(i);
	}
	public void browse_all_fun(View v)
	{
		Intent i = new Intent(this, Game_type_options_activity.class);
		//finish();
		startActivity(i);
	}
}
