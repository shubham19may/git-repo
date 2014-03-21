package edlogiq.neurongym;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Overall_performance_history_activity extends Activity {

	Score_manager scr_mgr;
	String[] all_date = new String[3000];
	int all_date_index = 0;
	TextView all_day_tv , all_games_tv ;
	TextView[] type = new TextView[7];
	ImageView[] type_i  = new ImageView[7];
	double[] p = new double[7];
	TextView type_o;
	ImageView type_o_i;
	double pp = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.performance_history_layout);
		if(get_all_games() == 0)
		{
			setContentView(R.layout.wait_layout);
			ImageView img = (ImageView)findViewById(R.id.imageView1);
			img.setImageResource(R.drawable.game_unlock);
		}
		else
		{
			all_day_tv = (TextView) findViewById(R.id.all_date);
			all_day_tv.setText(""+get_days_played());
			all_games_tv =(TextView) findViewById(R.id.all_games);
			all_games_tv.setText(""+get_all_games());
			type[1] = (TextView)findViewById(R.id.type_one);
			type_i[1] = (ImageView)findViewById(R.id.type_one_arrow);
			type[1].setText(""+type1());
			if(type1()<0)
			{
				type_i[1].setImageResource(R.drawable.down_arrow);
			}
			type[2] = (TextView)findViewById(R.id.type_two);
			type_i[2] = (ImageView)findViewById(R.id.type_two_arrow);
			type[2].setText(""+type2());
			if(type2()<0)
			{
				type_i[2].setImageResource(R.drawable.down_arrow);
			}
			type[3] = (TextView)findViewById(R.id.type_three);
			type_i[3] = (ImageView)findViewById(R.id.type_three_arrow);
			type[3].setText(""+type3());
			if(type3()<0)
			{
				type_i[3].setImageResource(R.drawable.down_arrow);
			}
			type[4] = (TextView)findViewById(R.id.type_four);
			type_i[4] = (ImageView)findViewById(R.id.type_four_arrow);
			type[4].setText(""+type4());
			if(type4()<0)
			{
				type_i[4].setImageResource(R.drawable.down_arrow);
			}
			type[5] = (TextView)findViewById(R.id.type_five);
			type_i[5] = (ImageView)findViewById(R.id.type_five_arrow);
			type[5].setText(""+type5());
			if(type5()<0)
			{
				type_i[5].setImageResource(R.drawable.down_arrow);
			}
			type[6] = (TextView)findViewById(R.id.type_six);
			type_i[6] = (ImageView)findViewById(R.id.type_six_arrow);
			type[6].setText(""+type6());
			if(type6()<0)
			{
				type_i[6].setImageResource(R.drawable.down_arrow);
			}
			for(int l = 1; l<=6; l++)
			{
				pp += p[l];
				
			}
			pp = pp /6;
			type_o = (TextView)findViewById(R.id.type_o);
			type_o.setText(""+(int)pp);
			if(pp<0)
			{
				type_o_i = (ImageView)findViewById(R.id.type_o_arrow);
				type_o_i.setImageResource(R.drawable.down_arrow);
			}
		}
		
	}
    public int type1()
    {
    	game_manager(1);
    	if(scr_mgr.get_no_of_rows() >1)
    	{
    		 double avg = scr_mgr.get_avg_score();
    		 double avg1 = avg*scr_mgr.get_no_of_rows();
    		 avg1 = avg1 - scr_mgr.get_score_from_id(1);
    		 avg1 = avg1/(scr_mgr.get_no_of_rows()-1);
    		 double percentage = (avg1 - scr_mgr.get_score_from_id(1))/scr_mgr.get_score_from_id(1)*100;
    		 p[1] = percentage;
    		 scr_mgr.close();
    		 return (int)percentage;
    	}
    	else{
    		scr_mgr.close();
    		return 0;
    	}
    }
    public int type2()
    {
    	game_manager(2);
    	if(scr_mgr.get_no_of_rows() >1)
    	{
    		 double avg = scr_mgr.get_avg_score();
    		 double avg1 = avg*scr_mgr.get_no_of_rows();
    		 avg1 = avg1 - scr_mgr.get_score_from_id(1);
    		 avg1 = avg1/(scr_mgr.get_no_of_rows()-1);
    		 double percentage = (avg1 - scr_mgr.get_score_from_id(1))/scr_mgr.get_score_from_id(1)*100;
    		 p[2] = percentage;
    		 scr_mgr.close();
    		 return (int)percentage;
    	}
    	else{
    		scr_mgr.close();
    		return 0;
    	}
    }
    public int type3()
    {
    	game_manager(3);
    	if(scr_mgr.get_no_of_rows() >1)
    	{
    		 double avg = scr_mgr.get_avg_score();
    		 double avg1 = avg*scr_mgr.get_no_of_rows();
    		 avg1 = avg1 - scr_mgr.get_score_from_id(1);
    		 avg1 = avg1/(scr_mgr.get_no_of_rows()-1);
    		 double percentage = (avg1 - scr_mgr.get_score_from_id(1))/scr_mgr.get_score_from_id(1)*100;
    		 p[3] = percentage;
    		 scr_mgr.close();
    		 return (int)percentage;
    	}
    	else{
    		scr_mgr.close();
    		return 0;
    	}
    }
    public int type4()
    {
    	game_manager(4);
    	if(scr_mgr.get_no_of_rows() >1)
    	{
    		 double avg = scr_mgr.get_avg_score();
    		 double avg1 = avg*scr_mgr.get_no_of_rows();
    		 avg1 = avg1 - scr_mgr.get_score_from_id(1);
    		 avg1 = avg1/(scr_mgr.get_no_of_rows()-1);
    		 double percentage = (avg1 - scr_mgr.get_score_from_id(1))/scr_mgr.get_score_from_id(1)*100;
    		 p[4] = percentage;
    		 scr_mgr.close();
    		 return (int)percentage;
    	}
    	else{
    		scr_mgr.close();
    		return 0;
    	}
    }
    public int type5()
    {
    	game_manager(5);
    	if(scr_mgr.get_no_of_rows() >1)
    	{
    		 double avg = scr_mgr.get_avg_score();
    		 double avg1 = avg*scr_mgr.get_no_of_rows();
    		 avg1 = avg1 - scr_mgr.get_score_from_id(1);
    		 avg1 = avg1/(scr_mgr.get_no_of_rows()-1);
    		 double percentage = (avg1 - scr_mgr.get_score_from_id(1))/scr_mgr.get_score_from_id(1)*100;
    		 p[5] = percentage;
    		 scr_mgr.close();
    		 return (int)percentage;
    	}
    	else{
    		scr_mgr.close();
    		return 0;
    	}
    }
    public int type6()
    {
    	game_manager(6);
    	if(scr_mgr.get_no_of_rows() >1)
    	{
    		 double avg = scr_mgr.get_avg_score();
    		 double avg1 = avg*scr_mgr.get_no_of_rows();
    		 avg1 = avg1 - scr_mgr.get_score_from_id(1);
    		 avg1 = avg1/(scr_mgr.get_no_of_rows()-1);
    		 double percentage = (avg1 - scr_mgr.get_score_from_id(1))/scr_mgr.get_score_from_id(1)*100;
    		 p[6] = percentage;
    		 scr_mgr.close();
    		 return (int)percentage;
    	}
    	else{
    		scr_mgr.close();
    		return 0;
    	}
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
    public int get_days_played()
    {
    	for(int i=1;i<=18;i++)
    	{
    		game_manager(i);
    		for(int j=1; j<=scr_mgr.get_no_of_rows(); j++)
    		{
    			String temp = scr_mgr.get_date_from_id(j);
    			int flag =0;
    			for(int k=1; k<=all_date_index ; k++)
    			{
    				if(temp.matches(all_date[k]))
    				{
    					flag = 1;
    					break;
    				}
    			}
    			if(flag == 0)
    			{
    				all_date_index++;
    				all_date[all_date_index] = temp;
    			}
    		}
    		scr_mgr.close();
    	}
    	return(all_date_index);
    }
    public int get_all_games()
    {
    	int no_of_games = 0;
    	
    	for(int i = 1; i<=6 ; i++)
    	{
    		game_manager(i);
    		no_of_games += scr_mgr.get_no_of_rows();
    		Log.d("days", ""+scr_mgr.get_no_of_rows());
    		scr_mgr.close();
    	}
    	return no_of_games;
    }
}

