package edlogiq.neurongym;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;

public class Days_and_games_played {

	int days;
	int[] days_array ;
	Score_manager scr_mgr;
	Context cnt;
	int no_of_games =0;
	public Days_and_games_played(int days, Context context)
	{
		this.days = days;
		days_array = new int[days];
		cnt = context;
		for(int i=0; i<=(days-1); i++)
		{
			days_array[i] =0; 
		}
	}
	public int days_played() throws ParseException
	{
		int no_of_days = 0;
		for(int i =1 ; i<= 6; i++)
		{
			game_manager(i);
			Calendar c = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String todays_date_s = df.format(c.getTime());
			Date todays_date = convert_to_date(todays_date_s);
			for(int j =1 ;j<= scr_mgr.get_no_of_rows();j++)
			{
				int diff_bet_date;
				Date prev_date = convert_to_date(scr_mgr.get_date_from_id(j));
				int diffInDays = (int)( (todays_date.getTime() - prev_date.getTime()) 
		                 / (1000 * 60 * 60 * 24) );
				if(diffInDays <= (days-1))
				{
					days_array[diffInDays] = 1; 
					no_of_games++;
				}
			}
		}
		for(int k =0;k<=(days -1 ); k++)
		{
			if(days_array[k] == 1)
			no_of_days ++;
		}
		return no_of_days;
	}
	public int games_played()
	{
		return no_of_games;
	}
	public void game_manager(int i)
    {
    	if(i == 1)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db1.db");
    	}
    	if(i == 2)
    	{
    		scr_mgr = new Score_manager(cnt, "spot_it_table", "game_score_db2.db");
    	}
    	if(i == 3)
    	{
    		scr_mgr = new Score_manager(cnt, "dancing_balls_table", "game_score_db3.db");
    	}
    	if(i == 4)
    	{
    		scr_mgr = new Score_manager(cnt, "track_the_route_table", "game_score_db4.db");
    	}
    	if(i == 5)
    	{
    		scr_mgr = new Score_manager(cnt, "match_it_table", "game_score_db5.db");
    	}
    	if(i == 6)
    	{
    		scr_mgr = new Score_manager(cnt, "reversal_table", "game_score_db6.db");
    	}
    	if(i == 7)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db7.db");
    	}
    	if(i == 8)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db8.db");
    	}
    	if(i == 9)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db9.db");
    	}
    	if(i == 10)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db10.db");
    	}
    	if(i == 11)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db11.db");
    	}
    	if(i == 12)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db12.db");
    	}
    	if(i == 13)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db13.db");
    	}
    	if(i == 14)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db14.db");
    	}
    	if(i == 15)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db15.db");
    	}
    	if(i == 16)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db16.db");
    	}
    	if(i == 17)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db17.db");
    	}
    	if(i == 18)
    	{
    		scr_mgr = new Score_manager(cnt, "river_pass_table", "game_score_db18.db");
    	}
    }
	public Date convert_to_date(String date_str) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = sdf.parse(date_str);
		return date;
	}
}
