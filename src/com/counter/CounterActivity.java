package com.counter;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;

public class CounterActivity extends Activity {
	
	DatabaseHelper dbHelper;
	SQLiteDatabase sdb;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.counter);
		
	}
}
