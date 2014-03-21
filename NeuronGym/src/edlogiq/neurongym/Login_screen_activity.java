package edlogiq.neurongym;

import java.util.HashMap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login_screen_activity extends Activity{

	DBcontrol controller ;
	int flag_db_created;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen_layout);
		controller = new DBcontrol(this);
		
		Button but = (Button) findViewById(R.id.button1);
		
		controller.insertAnimal();
		if(controller.get_db_Created() == 0)
		{
			
			but.setText("Sign Up");
			flag_db_created = 0;
		}
		else if(controller.get_db_Created() == 1)
		{
			but.setText("Log in");
			flag_db_created = 1;
		}
		Log.d("check_db",controller.get_Name());
		Log.d("check_db",""+controller.get_Age());
		Log.d("check_db",controller.get_MailID());
		Log.d("check_db",controller.get_Gender());
		Log.d("check_db",controller.get_UserName());
		Log.d("check_db",controller.get_PSWD());
		Log.d("check_db",""+controller.get_db_Created());
		Log.d("check_db",controller.get_Date());
	}
	public void sign_log_fun(View v)
	{
		if(flag_db_created == 0)
		{
			
			Intent i = new Intent(this , Sign_up_form_activity.class);
			finish();
			startActivity(i);
		}
		else
		{
			final Dialog dialog = new Dialog(this);
			dialog.setContentView(R.layout.log_in_layout);
			dialog.setTitle("Log In");
			//dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
			TextView user_n = (TextView)dialog.findViewById(R.id.user);
			user_n.setText(controller.get_UserName());
				
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					EditText pswd = (EditText)dialog.findViewById(R.id.editText2);
					String pass = pswd.getText().toString();
					if(pass.matches(controller.get_PSWD()))
					{
						Toast.makeText(getApplicationContext(), "Logged in", 1000).show();
						finish();
						startActivity(new Intent(getApplicationContext(),Home_page_activity.class));
					}
					else 
					{
						Toast.makeText(getApplicationContext(), "Wrong password", 1000).show();
					}
					dialog.dismiss();
				}
				
			});
 
			dialog.show();
		}
	}
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu)
	    {
		    if(flag_db_created == 1){
	        MenuInflater menuInflater = getMenuInflater();
	        menuInflater.inflate(R.menu.login_screen_layout, menu);
	        return true;
		    }
		    return false;
	    }
	 public boolean onOptionsItemSelected(MenuItem item)
	    {
	         
	        switch (item.getItemId())
	        {
	        case R.id.menu_settings:
	        	final Dialog dialog = new Dialog(this);
				dialog.setContentView(R.layout.log_in_layout);
				dialog.setTitle("Enter password to delete account");
				//dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				TextView user_n = (TextView)dialog.findViewById(R.id.user);
				user_n.setText(controller.get_UserName());
					
				dialogButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						EditText pswd = (EditText)dialog.findViewById(R.id.editText2);
						String pass = pswd.getText().toString();
						if(pass.matches(controller.get_PSWD()))
						{
							controller.delete_User_Info();
							Toast.makeText(getApplicationContext(), "Account deleted.", 1000).show();
							Intent i =getIntent();
							finish();
							startActivity(i);
							//startActivity(new Intent(getApplicationContext(),Game_type_options_activity.class));
						}
						else 
						{
							Toast.makeText(getApplicationContext(), "Wrong password", 1000).show();
						}
						dialog.dismiss();
					}
					
				});
	 
				dialog.show();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }    
}
