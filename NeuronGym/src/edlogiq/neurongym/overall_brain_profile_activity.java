package edlogiq.neurongym;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Arrays;

import org.achartengine.chart.LineChart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class overall_brain_profile_activity extends Activity{

	LayoutParams o_bar ,a_bar , s_bar , v_bar , p_bar , m_bar , f_bar;
	ImageView o_bar1 ,a_bar1 , s_bar1 , v_bar1 , p_bar1 , m_bar1 , f_bar1;
	LinearLayout ani_layout;
	TextView o_ani, a_ani, s_ani, v_ani, p_ani, m_ani, f_ani;
	TextView o_np, a_np, s_np, v_np, p_np, m_np, f_np;
	TextView best1 , best2;
	int height , width;
	Ani_calculator ani_cal;
	Score_manager scr_mgr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.overall_brain_profile_layout);
		ani_layout = (LinearLayout)findViewById(R.id.ani_layout);
		o_bar1 = (ImageView)findViewById(R.id.overall_bar);
		a_bar1 = (ImageView)findViewById(R.id.attention_bar);
		s_bar1 = (ImageView)findViewById(R.id.speed_bar);
		v_bar1 = (ImageView)findViewById(R.id.v_p_bar);
		p_bar1 = (ImageView)findViewById(R.id.p_s_bar);
		m_bar1 = (ImageView)findViewById(R.id.memory_bar);
		f_bar1 = (ImageView)findViewById(R.id.flexibility_bar);
		o_ani  = (TextView)findViewById(R.id.overall_ani);
		a_ani  = (TextView)findViewById(R.id.attention_ani);
		s_ani  = (TextView)findViewById(R.id.speed_ani);
		v_ani  = (TextView)findViewById(R.id.v_p_ani);
		p_ani  = (TextView)findViewById(R.id.p_s_ani);
		m_ani  = (TextView)findViewById(R.id.memory_ani);
		f_ani  = (TextView)findViewById(R.id.flexibility_ani);
		o_np =  (TextView)findViewById(R.id.overall_np);
		a_np =  (TextView)findViewById(R.id.attention_np);
		s_np =  (TextView)findViewById(R.id.speed_np);
		v_np =  (TextView)findViewById(R.id.v_p_np);
		p_np =  (TextView)findViewById(R.id.p_s_np);
		m_np =  (TextView)findViewById(R.id.memory_np);
		f_np =  (TextView)findViewById(R.id.flexibility_np);
		best1 =   (TextView)findViewById(R.id.best_area_1);
		best2 =   (TextView)findViewById(R.id.best_area_2);
		 DecimalFormat twoDForm = new DecimalFormat("#.#");
		o_ani.setText(""+Double.valueOf(twoDForm.format(overall_ani())));
		a_ani.setText(""+Double.valueOf(twoDForm.format(attenstion_ani())));
		s_ani.setText(""+Double.valueOf(twoDForm.format(speed_ani()))); 
		v_ani.setText(""+Double.valueOf(twoDForm.format(v_p_ani())));
		p_ani.setText(""+Double.valueOf(twoDForm.format(p_s_ani())));
		m_ani.setText(""+Double.valueOf(twoDForm.format(memory_ani())));
		f_ani.setText(""+Double.valueOf(twoDForm.format(flexibility_ani())));
		
		s_np.setText(""+get_no_of_games_gametype_2()/3);
		a_np.setText(""+get_no_of_games_gametype_1()/3);
		v_np.setText(""+get_no_of_games_gametype_3()/3);
		p_np.setText(""+get_no_of_games_gametype_4()/3);
		m_np.setText(""+get_no_of_games_gametype_5()/3);
		f_np.setText(""+get_no_of_games_gametype_6()/3);
		int total_games = get_no_of_games_gametype_1()+get_no_of_games_gametype_2()+get_no_of_games_gametype_3()+get_no_of_games_gametype_4()+get_no_of_games_gametype_5()+get_no_of_games_gametype_6();
		o_np.setText(""+total_games/3);
		double[] a = new double[6];
		a[0] = attenstion_ani();
		a[1] = speed_ani();
		a[2] = v_p_ani();
		a[3] = p_s_ani();
		a[4] = memory_ani();
		a[5] = flexibility_ani();
		double max = a[0];
		int j = 0;
		for(int i = 0;i <=5;i++)
		{
			if(a[i]>max)
				{max = a[i];
				   j =i;}
		}
		int k = 0;
		double max1 = 0;
		for(int i =0; i<= 5;i++)
		{
			if(i!=j)
			{
				Log.d("adasd", "sadasd");
				max1 = a[i];
				k =i;
			}
		}
		for(int i =0; i<= 5;i++)
		{
			if(i!=j)
			{
				if(a[i]>max1)
				{
					Log.d("adasd", "sadasd");
					max1 = a[i];
					k = i;
				}
			}
		}
		if(j == 0 )
		{
			best1.setText("Attention");
		}
		if(j == 1)
		{
			best1.setText("Speed");
		}
		if(j ==2)
		{
			best1.setText("Visual perception");
		}
		if(j ==3)
		{
			best1.setText("Problem solving");
		}
		if(j ==4)
		{
			best1.setText("Memory");
		}
		if(j ==5)
		{
			best1.setText("Flexibility");
		}
		if(k ==0)
		{
			best2.setText("Attention");
		}
		if(k ==1)
		{
			best2.setText("Speed");
		}
		if(k ==2)
		{
			best2.setText("Visual perception");
		}
		if(k ==3)
		{
			best2.setText("Problem solving");
		}
		if(k ==4)
		{
			best2.setText("Memory");
		}
		if(k ==5)
		{
			best2.setText("Flexibility");
		}
	}
	@Override
	public void onWindowFocusChanged (boolean hasFocus) {
	        // the height will be set at this point
	         height = ani_layout.getMeasuredHeight(); 
	         width = ani_layout.getMeasuredWidth();
	          
	         o_bar = new LayoutParams((int) (width*overall_ani()/1000.0),height);
	         o_bar1.setLayoutParams(o_bar);
	         a_bar = new LayoutParams((int) (width*attenstion_ani()/1000.0),height);
	         a_bar1.setLayoutParams(a_bar);
	         s_bar = new LayoutParams((int) (width*speed_ani()/1000.0),height);
	         s_bar1.setLayoutParams(s_bar);
	         v_bar = new LayoutParams((int) (width*v_p_ani()/1000.0),height);
	         v_bar1.setLayoutParams(v_bar);
	         p_bar = new LayoutParams((int) (width*p_s_ani()/1000.0),height);
	         p_bar1.setLayoutParams(p_bar);
	         m_bar = new LayoutParams((int) (width*memory_ani()/1000.0),height);
	         m_bar1.setLayoutParams(m_bar);
	         f_bar = new LayoutParams((int) (width*flexibility_ani()/1000.0),height);
	         f_bar1.setLayoutParams(f_bar);
	}
	public double attenstion_ani()
	{
        game_manager(1);
		
		double g2 = scr_mgr.get_avg_score();
		ani_cal = new Ani_calculator(g2 , 1);
		double ani_spot_it = ani_cal.get_ani();
		scr_mgr.close();
		return ani_spot_it;		
	}
	public double speed_ani()
	{
		game_manager(2);
		
		double g2 = scr_mgr.get_avg_score();
		ani_cal = new Ani_calculator(g2 , 2);
		double ani_spot_it = ani_cal.get_ani();
		scr_mgr.close();
		return ani_spot_it;
	}
	public double v_p_ani()
	{
        game_manager(3);
		double g2 = scr_mgr.get_avg_score();
		ani_cal = new Ani_calculator(g2 , 3);
		double ani_spot_it = ani_cal.get_ani();
		scr_mgr.close();
		return ani_spot_it;
	}
	public double p_s_ani()
	{
		return 0;
		
	}
	public double memory_ani()
	{
        game_manager(4);
		
		double g2 = scr_mgr.get_avg_score();
		ani_cal = new Ani_calculator(g2 , 4);
		double ani_spot_it = ani_cal.get_ani();
		scr_mgr.close();
		return ani_spot_it;
	}
	public double flexibility_ani()
	{
        game_manager(5);
		
		double g2 = scr_mgr.get_avg_score();
		ani_cal = new Ani_calculator(g2 , 5);
		double ani_spot_it = ani_cal.get_ani();
		scr_mgr.close();
		
         game_manager(6);
		
		 g2 = scr_mgr.get_avg_score();
		ani_cal = new Ani_calculator(g2 , 6);
		 ani_spot_it += ani_cal.get_ani();
		scr_mgr.close();
		return ani_spot_it/2;
	}
	public double overall_ani()
	{
		return(attenstion_ani()+ speed_ani() +v_p_ani()+p_s_ani()+memory_ani()+flexibility_ani())/6;
	}
	public int get_no_of_games_gametype_1()
	{
		int no_of_total_games = 0;
		game_manager(1);
		no_of_total_games += scr_mgr.get_no_of_rows();
		scr_mgr.close();
		return no_of_total_games;
	}
	public int get_no_of_games_gametype_2()
	{
		int no_of_total_games = 0;
		game_manager(2);
		no_of_total_games += scr_mgr.get_no_of_rows();
		scr_mgr.close();
		return no_of_total_games;
	}
	public int get_no_of_games_gametype_3()
	{
		int no_of_total_games = 0;
		game_manager(3);
		no_of_total_games += scr_mgr.get_no_of_rows();
		scr_mgr.close();
		return no_of_total_games;
	}
	public int get_no_of_games_gametype_4()
	{
		int no_of_total_games = 0;
		game_manager(4);
		no_of_total_games += scr_mgr.get_no_of_rows();
		scr_mgr.close();
		return no_of_total_games;
	}
	public int get_no_of_games_gametype_5()
	{
		return 0;
	}
	public int get_no_of_games_gametype_6()
	{
		int no_of_total_games = 0;
		game_manager(5);
		no_of_total_games += scr_mgr.get_no_of_rows();
		scr_mgr.close();
		game_manager(6);
		no_of_total_games += scr_mgr.get_no_of_rows();
		scr_mgr.close();
		return no_of_total_games;
	}
	public void game_manager(int i)
    {
    	if(i == 1)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db1.db");
    	}
    	if(i == 2)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "spot_it_table", "game_score_db2.db");
    	}
    	if(i == 3)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "dancing_balls_table", "game_score_db3.db");
    	}
    	if(i == 4)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "track_the_route_table", "game_score_db4.db");
    	}
    	if(i == 5)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "match_it_table", "game_score_db5.db");
    	}
    	if(i == 6)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "reversal_table", "game_score_db6.db");
    	}
    	if(i == 7)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db7.db");
    	}
    	if(i == 8)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db8.db");
    	}
    	if(i == 9)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db9.db");
    	}
    	if(i == 10)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db10.db");
    	}
    	if(i == 11)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db11.db");
    	}
    	if(i == 12)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db12.db");
    	}
    	if(i == 13)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db13.db");
    	}
    	if(i == 14)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db14.db");
    	}
    	if(i == 15)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db15.db");
    	}
    	if(i == 16)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db16.db");
    	}
    	if(i == 17)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db17.db");
    	}
    	if(i == 18)
    	{
    		scr_mgr = new Score_manager(getApplicationContext(), "river_pass_table", "game_score_db18.db");
    	}
    }
	public void show_graph_fun(View v) throws ParseException
	{
		Graph_overall_performance_history graph = new Graph_overall_performance_history();
		Intent lineIntent = graph.getIntent(this);
		startActivity(lineIntent);
	}
}
