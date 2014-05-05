package com.counter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.View.OnClickListener;

public class DatabaseHelper extends SQLiteOpenHelper implements BaseColumns{
	
	private static final String DATABASE_NAME = "mydatabase.db";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_TABLE = "counters";

	public static final String EXSPENSE_COLUMN = "expense";
	public static final String CATEGORY_COLUMN = "category";
	public static final String DATE_COLUMN = "date";
	
	private static final String DATABASE_CREATE_SCRIPT = "create table "
			+ DATABASE_TABLE + " (" + BaseColumns._ID
			+ " integer primary key autoincrement, " + EXSPENSE_COLUMN
			+ " text not null, " + CATEGORY_COLUMN + " text not null, " + DATE_COLUMN
			+ " text);";
	
	DatabaseHelper(Context conext, String name, CursorFactory factory, int version) {
	    super(conext, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	DatabaseHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE_SCRIPT);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);
		db.execSQL("DROP TABLE IF IT EXIST " + DATABASE_TABLE);
		onCreate(db);
	}

}
