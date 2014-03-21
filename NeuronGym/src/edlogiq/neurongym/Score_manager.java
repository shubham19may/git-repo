package edlogiq.neurongym;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class Score_manager extends SQLiteOpenHelper{

	
	
	private static final String TAG = "blah";
    private static String game_table_name;
	private static String database_name;
	
	public Score_manager(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	
	
	public Score_manager(Context applicationcontext ,String table_name , String database_name) {
		  super(applicationcontext, database_name, null, 1);
		  game_table_name = table_name; 
		  this.database_name = database_name;
		  Log.d(TAG,"Created");
		}
	
	
	
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
         Log.d(TAG,"user_info Created");
		
		String query;
		query = "CREATE TABLE " + game_table_name +  " (_ID INTEGER PRIMARY KEY, game_score REAL, date_played TXET);";
		  db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

	public void insert_score(Double score , String date)
	{ 
		  SQLiteDatabase database = this.getWritableDatabase();
		  ContentValues values = new ContentValues();
		  values.put("game_score", score);
		  values.put("date_played", date);
		  //values.put("times_played", times);
		  database.insert(game_table_name, null, values);
		  database.close();
	}
	public int get_last_id()
	{
		  int word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM "+ game_table_name +" WHERE  = (SELECT MAX(_ID) FROM "+game_table_name+");";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getInt(0);
		  return word;
	}
	public double get_score_from_id(int id)
	{
		double word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM "+ game_table_name +" WHERE  _ID = "+id+";";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getDouble(1);
		  return word;
	}
	public String get_date_from_id(int id)
	{
		String word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM "+ game_table_name +" WHERE  _ID = "+ id +";";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getString(2);
		  return word;
	}
//	public int get_times_from_id(int id)
//	{
//		  int word; 
//		  SQLiteDatabase database = this.getReadableDatabase();
//		  String selectQuery = "SELECT * FROM "+ game_table_name +" WHERE  _ID = "+id+";";
//		  Cursor cursor = database.rawQuery(selectQuery, null);
//		  cursor.moveToFirst();
//		  word = cursor.getInt(3);
//		  return word;
//	}
	public int get_no_of_rows()
	{ 
		int word; 
		  SQLiteDatabase database = this.getWritableDatabase();
		  String selectQuery = "SELECT * FROM "+ game_table_name+";";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  word = cursor.getCount();
		  return word;
	}
	public double get_avg_score()
	{ 
		double word; 
		  SQLiteDatabase database = this.getWritableDatabase();
		  String selectQuery = "select avg( game_score) from "+game_table_name+";";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getDouble(0);
		  return word;
	}
	public void close_db()
	{
		SQLiteDatabase database = this.getWritableDatabase();
		database.close();
	}
	
}
