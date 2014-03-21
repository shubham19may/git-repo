package edlogiq.neurongym;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;

public class Graph_overall_performance_history {
	Score_manager scr_mgr;
	Context cnt;
	int count = 1;
	Date[] date_array;
	String[] date_str;
	int[] score_array;
	int[]  x_v = {1,2,3,4,5,6,7,8,9,10};
    int[] y_v = {1,2,3,4,5,6,7,8,9,10};
	public Intent getIntent(Context context) throws ParseException
	{
	    cnt = context;
	    game_manager(1);
	    String temp = scr_mgr.get_date_from_id(1);
	   
	    for(int i=1;i<=scr_mgr.get_no_of_rows();i++)
	    {
	    	if(scr_mgr.get_date_from_id(i).matches(temp))
	    	{
	    		
	    	}
	    	else
	    	{
	    		temp = scr_mgr.get_date_from_id(i);
	    		count ++;
	    	}
	    }
	    Log.d("count", "count= "+count);
	    date_array = new Date[count];
	    score_array = new int[count];
	    int cn=1;
	    date_array[0] = convert_to_date(scr_mgr.get_date_from_id(1));
	    temp  = scr_mgr.get_date_from_id(1);
	    for(int i=1;i<=scr_mgr.get_no_of_rows();i++)
	    {
	    	if(scr_mgr.get_date_from_id(i).matches(temp))
	    	{
	    		
	    	}
	    	else
	    	{
	    		temp = scr_mgr.get_date_from_id(i);
	    		date_array[cn] = convert_to_date(scr_mgr.get_date_from_id(i));
	    		cn++;
	    	}
	    }
	    for(int i=0;i<count;i++)
	    {
	    	Log.d("date", "date = "+date_array[i]);
	    }
	    for(int i=0;i<count;i++)
	    {
	    	for(int j =1 ;j<=scr_mgr.get_no_of_rows();j++)
	    	{
	    		int coun = 0;
	    	    double score =0;
	    		if(date_array[i]==convert_to_date(scr_mgr.get_date_from_id(j)))
	    		{
	    			score += scr_mgr.get_score_from_id(j);
	    			coun ++;
	    		}
	    		score = score/coun;
	    		Ani_calculator cal = new Ani_calculator(score, 2);
	    		int ani = (int )cal.get_ani();
	    		score_array[i] = ani;
	    	}
	    }
	    TimeSeries series  = new TimeSeries("line1");
	   /* for(int i = 0; i<count; i++)
	    {
	    	 series.add(date_array[i] , score_array[i]);
	    }*/
	    for(int i=0;i<=9;i++)
	    {
	    	series.add(x_v[i] , y_v[i]);
	    }
	    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
	    dataset.addSeries(series);
	    XYMultipleSeriesRenderer mrenderer = new XYMultipleSeriesRenderer();
	    XYSeriesRenderer renderer = new XYSeriesRenderer();
	    renderer.setColor(Color.BLUE);
	    renderer.setPointStyle(PointStyle.SQUARE);
	    renderer.setFillPoints(true);
	    mrenderer.addSeriesRenderer(renderer);
	    mrenderer.setZoomButtonsVisible(true);
	    mrenderer.setZoomEnabled(true);
	    Intent intent = ChartFactory.getLineChartIntent(context, dataset, mrenderer , "Spot it Progress");
		return intent;
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
