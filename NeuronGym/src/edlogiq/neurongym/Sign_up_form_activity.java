package edlogiq.neurongym;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up_form_activity extends Activity{

	private EditText name , age , mailid , username , password ;
	Button male , female;
	String str_name , str_mailid , str_username , str_password ,str_gender = "Male";
	int int_age;
	DBcontrol controller ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up_form);
		name = (EditText)findViewById(R.id.editText1);
		age = (EditText)findViewById(R.id.editText2);
		mailid = (EditText)findViewById(R.id.editText3);
		username = (EditText)findViewById(R.id.editText4);
		password = (EditText)findViewById(R.id.editText5);
		
		
		controller = new DBcontrol(this);
	}	
	public void male_fun(View v)
	{
		str_gender = "Male";
	}
	public void female_fun(View v)
	{
		str_gender = "Female";
	}
	public void confirm_fun(View v)
	{
		str_name =name.getText().toString();
		if(!age.getText().toString().matches(""))
		int_age = Integer.parseInt(age.getText().toString());
		str_mailid =mailid.getText().toString();
		str_username =username.getText().toString();
		str_password = password.getText().toString();
		if (str_gender.matches("")||str_name.matches("")||str_mailid.matches("")||str_password.matches("")||str_username.matches("")||((age.getText().toString()).matches(""))) {
		    Toast.makeText(this, "Form Incomplete", Toast.LENGTH_SHORT).show();
		}
		else 
		{
			controller.update_user_Name(str_name);
			controller.update_user_Age(int_age);
			controller.update_user_MailID(str_mailid);
			controller.update_user_UserName(str_username);
			controller.update_user_Gender(str_gender);
			controller.update_user_PSWD(str_password);
			controller.update_db_created(1);
			Calendar c = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String date = df.format(c.getTime());
			controller.update_date_created(date);
			finish();
			Intent i =new Intent(this , Login_screen_activity.class);
			startActivity(i);
		}
	}
}
