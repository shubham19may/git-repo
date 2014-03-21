package edlogiq.neurongym;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Game_type_options_activity extends Activity
{

	Gallery ga ;
	LinearLayout l;
	int height , width;
	int flag =0;
	int flag2 =0;
	Button  but;
	Context cnt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_type_option_layout);
		ga = (Gallery)findViewById(R.id.gallery1);
		l = (LinearLayout)findViewById(R.id.LinearLayout3);
		but = (Button)findViewById(R.id.button1);
		but.setEnabled(false);
		cnt = getApplicationContext();
		Log.d("flag n flag2", ""+flag +" " +flag2);
		ga.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			    //Toast.makeText(getBaseContext(), "You have selected picture " + (arg2+1) , Toast.LENGTH_SHORT).show();
			    if(flag ==1 && flag2 ==1)
			    {
			    	if(arg2 == 0)
			    	{
			    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
			    	    flag =0 ;
			    		flag2 = 0;
			    		but.setEnabled(false);
			    		Intent i = new Intent(getApplicationContext() , com.games.river_pass.Start_activity.class);
			    		startActivity(i);
			    	}
			    	else if(arg2 == 1)
			    	{
			    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
			    	    flag =0 ;
			    		flag2 = 0;
			    		but.setEnabled(false);
			    		Intent i = new Intent(getApplicationContext() , com.example.blink.Home.class);
			    		startActivity(i);
			    	}
			    	
			    	
			    }
			    else if(flag ==1 && flag2 ==2)
			    {
			    	if(arg2 == 0)
			    	{
			    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
			    	    flag =0 ;
			    		flag2 = 0;
			    		but.setEnabled(false);
			    		Intent i = new Intent(getApplicationContext() , com.games.spot_it.Start_Activity.class);
			    		startActivity(i);
			    	}
			    	else if(arg2 == 1)
			    	{
			    		
				    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
				    	    flag =0 ;
				    		flag2 = 0;
				    		but.setEnabled(false);
				    		Intent i = new Intent(getApplicationContext() , com.intern.internapp.SplashScreen.class);
				    		startActivity(i);
			    	}
			    }
			    else if(flag ==1 && flag2 ==3)
			    {
			    	if(arg2 == 0)
			    	{
			    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
			    	    flag =0 ;
			    		flag2 = 0;
			    		but.setEnabled(false);
			    		Intent i = new Intent(getApplicationContext() , com.games.dancing_fireflies.Start_activity.class);
			    		startActivity(i);
			    	}
			    }
			    else if(flag ==1 && flag2 ==4)
			    {
			    	if(arg2 == 0)
			    	{
			    		
				    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
				    	    flag =0 ;
				    		flag2 = 0;
				    		but.setEnabled(false);
				    		Intent i = new Intent(getApplicationContext() , com.example.moneygame.MainActivity.class);
				    		startActivity(i);
			    	}
			    	else if(arg2 == 1)
			    	{
			    		
				    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
				    	    flag =0 ;
				    		flag2 = 0;
				    		but.setEnabled(false);
				    		Intent i = new Intent(getApplicationContext() , com.example.matchmath.Home.class);
				    		startActivity(i);
			    	}
			    }
			    else if(flag ==1 && flag2 ==5)
			    {
			    	if(arg2 == 0)
			    	{
			    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
			    	    flag =0 ;
			    		flag2 = 0;
			    		but.setEnabled(false);
			    		Intent i = new Intent(getApplicationContext() , com.games.tracktheroute.Start_activity.class);
			    		startActivity(i);
			    	}
			    }
			    else if(flag ==1 && flag2 ==6)
			    {
			    	if(arg2 == 0)
			    	{
			    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
			    	    flag =0 ;
			    		flag2 = 0;
			    		but.setEnabled(false);
			    		Intent i = new Intent(getApplicationContext() , com.games.match_it.Match_it_Start_activity.class);
			    		startActivity(i);
			    	}
			    	else if(arg2 ==1)
			    	{
			    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
			    	    flag =0 ;
			    		flag2 = 0;
			    		but.setEnabled(false);
			    		Intent i = new Intent(getApplicationContext() , com.games.reversal.Start_Activity.class);
			    		startActivity(i);
			    	}
			    	else if(arg2 == 2)
			    	{
			    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
			    	    flag =0 ;
			    		flag2 = 0;
			    		but.setEnabled(false);
			    		Intent i = new Intent(getApplicationContext() , com.example.alphaiq.MainActivity.class);
			    		startActivity(i);
			    	}
			    	else if(arg2 == 3)
			    	{
			    		ga.setAdapter(new imageAdapter(getApplicationContext(), height , width));
			    	    flag =0 ;
			    		flag2 = 0;
			    		but.setEnabled(false);
			    		//Intent i = new Intent(getApplicationContext() , com.example.circlematch.Home.class);
			    		//startActivity(i);
			    	}
			    }
			    if(arg2 == 0 && flag ==0)
			    {
			    	ga.setAdapter(new Attension_adapter(getApplicationContext(), height , width));
			    	flag =1;
			    	but.setEnabled(true);
			    	flag2 =1;
			    }
			    else if(arg2 ==1 && flag ==0)
			    {
			    	ga.setAdapter(new Speed_adapter(getApplicationContext(), height , width));
			    	flag =1;
			    	but.setEnabled(true);
			    	flag2 =2;
			    }
			    else if(arg2 ==2 && flag ==0)
			    {
			    	ga.setAdapter(new V_p_adapter(getApplicationContext(), height , width));
			    	flag =1;
			    	but.setEnabled(true);
			    	flag2 =3;
			    }
			    else if(arg2 ==3 && flag ==0)
			    {
			    	ga.setAdapter(new P_s_adapter(getApplicationContext(), height , width));
			    	flag =1;
			    	but.setEnabled(true);
			    	flag2 =4;
			    }
			    else if(arg2 ==4 && flag ==0)
			    {
			    	ga.setAdapter(new Memory_adapter(getApplicationContext(), height , width));
			    	flag =1;
			    	but.setEnabled(true);
			    	flag2 =5;
			    }
			    else if(arg2 ==5 && flag ==0)
			    {
			    	ga.setAdapter(new Flexibility_adapter(getApplicationContext(), height , width));
			    	flag =1;
			    	but.setEnabled(true);
			    	flag2 =6;
			    }
			    
			    	
			}
			});
	}
	@Override
	public void onWindowFocusChanged (boolean hasFocus) {
	        // the height will be set at this point
	        height = l.getMeasuredHeight(); 
	         width = l.getMeasuredWidth();
	        		ga.setAdapter(new imageAdapter(this, height , width));
	}
	public void back_fun(View v)
	{
		ga.setAdapter(new imageAdapter(this, height , width));
		flag =0;
		flag2 =0;
		but.setEnabled(false);
	}
}