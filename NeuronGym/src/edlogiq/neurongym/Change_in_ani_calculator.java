package edlogiq.neurongym;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.util.Log;

public class Change_in_ani_calculator {

	int no_days;
	Context context;
	Score_manager scr_mgr;
	Ani_calculator calcu;
	public Change_in_ani_calculator(int number_of_days, Context cnt)
	{
		no_days = number_of_days;
		no_days -=1;
		context = cnt;
	}
	public Date convert_to_date(String date_str) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = sdf.parse(date_str);
		return date;
	}
	public double change_type1() throws ParseException
	{
		double game1 = change_in_percent_game(1);
		return game1;
	}
	public double change_type2() throws ParseException
	{
		double game2 = change_in_percent_game(2);
		return game2;
	}
	public double change_type3() throws ParseException
	{
		double game3 = change_in_percent_game(3);
		return game3;
	}
	public double change_type4() throws ParseException
	{
		double game4 = change_in_percent_game(4);
		return game4;
	}
	public double change_type5() throws ParseException
	{
		
		return 0;
	}
	public double change_type6() throws ParseException
	{
		double game5 = change_in_percent_game(5);
		double game6 = change_in_percent_game(6);
		return (game5+game6)/2;
	}
	public double outperiod_score(int j) throws ParseException
	{
		    double score = 0;
		    int no_of_inperiod_days = 0;
			game_manager(j);
			Calendar c = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String todays_date_s = df.format(c.getTime());
			Date todays_date = convert_to_date(todays_date_s);
			for(int i=1;i<=scr_mgr.get_no_of_rows();i++)
			{
				int diff_bet_date;
				Date prev_date = convert_to_date(scr_mgr.get_date_from_id(i));
				int diffInDays = (int)( (todays_date.getTime() - prev_date.getTime()) 
		                 / (1000 * 60 * 60 * 24) );
				if(diffInDays <= no_days)
				{
					score += scr_mgr.get_score_from_id(i);
					no_of_inperiod_days +=1;
				}
			}
			//Log.d("score", "score"+score);
			double outperiod_score = ((scr_mgr.get_avg_score()*scr_mgr.get_no_of_rows()) - score);
			
			if(outperiod_score!=0)
			{double outperiod_score_avg = outperiod_score/(scr_mgr.get_no_of_rows()-no_of_inperiod_days);
			scr_mgr.close();
			return outperiod_score_avg;}
			else{
				  scr_mgr.close();
				  return 0;
				}
	}
	public void game_manager(int i)
    {
    	if(i == 1)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db1.db");
    	}
    	if(i == 2)
    	{
    		scr_mgr = new Score_manager(context, "spot_it_table", "game_score_db2.db");
    	}
    	if(i == 3)
    	{
    		scr_mgr = new Score_manager(context, "dancing_balls_table", "game_score_db3.db");
    	}
    	if(i == 4)
    	{
    		scr_mgr = new Score_manager(context, "track_the_route_table", "game_score_db4.db");
    	}
    	if(i == 5)
    	{
    		scr_mgr = new Score_manager(context, "match_it_table", "game_score_db5.db");
    	}
    	if(i == 6)
    	{
    		scr_mgr = new Score_manager(context, "reversal_table", "game_score_db6.db");
    	}
    	if(i == 7)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db7.db");
    	}
    	if(i == 8)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db8.db");
    	}
    	if(i == 9)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db9.db");
    	}
    	if(i == 10)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db10.db");
    	}
    	if(i == 11)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db11.db");
    	}
    	if(i == 12)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db12.db");
    	}
    	if(i == 13)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db13.db");
    	}
    	if(i == 14)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db14.db");
    	}
    	if(i == 15)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db15.db");
    	}
    	if(i == 16)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db16.db");
    	}
    	if(i == 17)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db17.db");
    	}
    	if(i == 18)
    	{
    		scr_mgr = new Score_manager(context, "river_pass_table", "game_score_db18.db");
    	}
    }
	public double change_in_percent_game(int game_no) throws ParseException
	{
		double change_in_percent;
		//for game1
		game_manager(game_no);
		calcu = new Ani_calculator(scr_mgr.get_avg_score(), game_no);
		double ani_total = calcu.get_ani();
		
		calcu = new Ani_calculator(outperiod_score(game_no), game_no);
		//Log.d("outperiod_score", ""+outperiod_score(game_no));
		double ani_outperiod = calcu.get_ani();
		scr_mgr.close();
		if(ani_outperiod!=0)
		 change_in_percent =(((ani_total - ani_outperiod)/ani_outperiod)*100);
		else
		 change_in_percent =100;
		return change_in_percent;
		
	}
	
}
