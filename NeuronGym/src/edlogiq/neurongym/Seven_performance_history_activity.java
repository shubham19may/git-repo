package edlogiq.neurongym;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Seven_performance_history_activity extends Activity {

	Score_manager scr_mgr;
	String todays_date_s, pdate;
	TextView all_days , all_games;
	Change_in_ani_calculator change;
	double change1 , change2 ,change3 ,change4 ,change5 ,change6 , overall_change;
	TextView[] type = new TextView[7];
	ImageView[] type_i  = new ImageView[7];
	TextView type_o ;
	ImageView type_o_i;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.performance_history_layout);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		todays_date_s = df.format(c.getTime());		 
		change = new Change_in_ani_calculator(7, this);
		try {
			change1 = change.change_type1();
			 change2 = change.change_type2();
			 change3 = change.change_type3();
			 change4 = change.change_type4();
			 change5 = change.change_type5();
			
			 change6 = change.change_type6();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 overall_change = (change1 + change2 +change3 +change4 +change5 +change6)/6;
		 
		 type[1] = (TextView)findViewById(R.id.type_one);
			type_i[1] = (ImageView)findViewById(R.id.type_one_arrow);
			type[1].setText(""+(int)change1);
			if(change1<0)
			{
				type_i[1].setImageResource(R.drawable.down_arrow);
			}
			type[2] = (TextView)findViewById(R.id.type_two);
			type_i[2] = (ImageView)findViewById(R.id.type_two_arrow);
			type[2].setText(""+(int)change2);
			if(change2<0)
			{
				type_i[2].setImageResource(R.drawable.down_arrow);
			}
			type[3] = (TextView)findViewById(R.id.type_three);
			type_i[3] = (ImageView)findViewById(R.id.type_three_arrow);
			type[3].setText(""+(int)change3);
			if(change3<0)
			{
				type_i[3].setImageResource(R.drawable.down_arrow);
			}
			type[4] = (TextView)findViewById(R.id.type_four);
			type_i[4] = (ImageView)findViewById(R.id.type_four_arrow);
			type[4].setText(""+(int)change4);
			if(change4<0)
			{
				type_i[4].setImageResource(R.drawable.down_arrow);
			}
			type[5] = (TextView)findViewById(R.id.type_five);
			type_i[5] = (ImageView)findViewById(R.id.type_five_arrow);
			type[5].setText(""+(int)change5);
			if(change5<0)
			{
				type_i[5].setImageResource(R.drawable.down_arrow);
			}
			type[6] = (TextView)findViewById(R.id.type_six);
			type_i[6] = (ImageView)findViewById(R.id.type_six_arrow);
			type[6].setText(""+(int)change6);
			if(change6<0)
			{
				type_i[6].setImageResource(R.drawable.down_arrow);
			}
			
			
			type_o = (TextView)findViewById(R.id.type_o);
			type_o.setText(""+(int)overall_change);
			if(overall_change<0)
			{
				type_o_i = (ImageView)findViewById(R.id.type_o_arrow);
				type_o_i.setImageResource(R.drawable.down_arrow);
			}
			
		 
		Days_and_games_played days_n_games = new Days_and_games_played(7, this);
		
		all_days = (TextView)findViewById(R.id.all_date);
		try {
			all_days.setText(""+days_n_games.days_played());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		all_games = (TextView)findViewById(R.id.all_games);
		all_games.setText(""+days_n_games.games_played());
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
}
