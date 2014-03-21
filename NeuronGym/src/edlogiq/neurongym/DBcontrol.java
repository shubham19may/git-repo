package edlogiq.neurongym;


import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBcontrol extends SQLiteOpenHelper {

	public DBcontrol(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	public DBcontrol(Context applicationcontext) {
		  super(applicationcontext, "androidsqlite.db", null, 1);
		  Log.d(TAG,"Created");
		}
	private static final String TAG = DBcontrol.class.getSimpleName();

	

	@Override
	public void onCreate(SQLiteDatabase database) {

		Log.d(TAG,"user_info Created");
		
		String query;
		query = "CREATE TABLE user_info (user_ID INTEGER PRIMARY KEY, user_Name TEXT, user_Age INTEGER, user_MailID TEXT, user_Gender TEXT, user_UserName TEXT, user_PSWD TEXT, db_Created INTEGER, date_Created TEXT);";
		  database.execSQL(query);
		  
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	public void insertAnimal() {
		  SQLiteDatabase database = this.getWritableDatabase();
		  ContentValues values = new ContentValues();
		  values.put("user_ID", 1);
		  values.put("user_Name", "asd");
		  values.put("user_Age", 10);
		  values.put("user_MailID", "asd");
		  values.put("user_Gender", "asd");
		  values.put("user_UserName", "asd");
		  values.put("user_PSWD", "asd");
		  values.put("db_Created", 0);
		  values.put("date_Created", "asd");
		  database.insert("user_info", null, values);
		  database.close();
		}
	public String get_Name() {
		  String word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM user_info where user_Id= '1'";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getString(1);
		  return word;
		} 

	public int get_Age() {
		  int word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM user_info where user_Id= '1'";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getInt(2);
		  return word;
		}
	public String get_MailID() {
		  String word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM user_info where user_Id= '1'";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getString(3);
		  return word;
		} 
	public String get_Gender() {
		  String word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM user_info where user_Id= '1'";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getString(4);
		  return word;
		} 
	public String get_UserName() {
		  String word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM user_info where user_Id= '1'";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getString(5);
		  return word;
		} 
	public String get_PSWD() {
		  String word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM user_info where user_Id= '1'";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getString(6);
		  return word;
		} 
	public int get_db_Created() {
		  int word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM user_info where user_Id= '1'";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getInt(7);
		  return word;
		} 
	public String get_Date() {
		  String word; 
		  SQLiteDatabase database = this.getReadableDatabase();
		  String selectQuery = "SELECT * FROM user_info where user_Id= '1'";
		  Cursor cursor = database.rawQuery(selectQuery, null);
		  cursor.moveToFirst();
		  word = cursor.getString(8);
		  return word;
		} 
	public int update_user_Name(String user_Name) {
	    SQLiteDatabase database = this.getWritableDatabase();  
	    ContentValues values = new ContentValues();
	    values.put("user_Name", user_Name);
	    return database.update("user_info", values, "user_Id = 1", null);
	  }
	public int update_db_created(int i) {
	    SQLiteDatabase database = this.getWritableDatabase();  
	    ContentValues values = new ContentValues();
	    values.put("db_Created", i);
	    return database.update("user_info", values, "user_Id = 1", null);
	  }
	public int update_date_created(String user_Name) {
	    SQLiteDatabase database = this.getWritableDatabase();  
	    ContentValues values = new ContentValues();
	    values.put("date_Created", user_Name);
	    return database.update("user_info", values, "user_Id = 1", null);
	  }
	public int update_user_Age(int user_Age) {
	    SQLiteDatabase database = this.getWritableDatabase();  
	    ContentValues values = new ContentValues();
	    values.put("user_Age", user_Age);
	    return database.update("user_info", values, "user_Id = 1", null);
	  }
	public int update_user_Gender(String user_Gender) {
	    SQLiteDatabase database = this.getWritableDatabase();  
	    ContentValues values = new ContentValues();
	    values.put("user_Gender", user_Gender);
	    return database.update("user_info", values, "user_Id = 1", null);
	  }
	public int update_user_MailID(String user_MailID) {
	    SQLiteDatabase database = this.getWritableDatabase();  
	    ContentValues values = new ContentValues();
	    values.put("user_MailID", user_MailID);
	    return database.update("user_info", values, "user_Id = 1", null);
	  }
	public int update_user_UserName(String user_UserName) {
	    SQLiteDatabase database = this.getWritableDatabase();  
	    ContentValues values = new ContentValues();
	    values.put("user_UserName", user_UserName);
	    return database.update("user_info", values, "user_Id = 1", null);
	  }
	public int update_user_PSWD(String user_PSWD) {
	    SQLiteDatabase database = this.getWritableDatabase();  
	    ContentValues values = new ContentValues();
	    values.put("user_PSWD", user_PSWD);
	    return database.update("user_info", values, "user_Id = 1", null);
	  }
	public void delete_User_Info() {
	    Log.d(TAG,"delete");
	    SQLiteDatabase database = this.getWritableDatabase();  
	    String deleteQuery = "DELETE FROM  user_info";
	    Log.d("query",deleteQuery);   
	    database.execSQL(deleteQuery);
	  }
}

