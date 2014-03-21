package edlogiq.neurongym;

import java.util.Timer;
import java.util.TimerTask;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_screen extends Activity {

	ImageView splash_logo;
	MediaPlayer mp;
	int i =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen_layout);
        splash_logo = (ImageView)findViewById(R.id.imageView1);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadeout_splash);
        fadeInAnimation.setFillAfter(true);
        splash_logo.startAnimation(fadeInAnimation );
        mp= MediaPlayer.create(this, R.raw.splash_screen_sound);
		mp.setLooping(false);
		mp.start();
		final Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

		    @Override
		    public void run() {
		    	i++;
		    	if(i == 5)
		    	{
		    		Intent i = new Intent(getApplicationContext(), Login_screen_activity.class);
		    		mp.stop();
		    		t.cancel();
		    		finish();
		    		startActivity(i);
		    	}
		    	
		    }
		         
		},
		0,
		500);
	}
}
