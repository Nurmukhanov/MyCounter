package com.counter;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterMainActivity extends Activity {
	private Button mEditButton;
	private Button mCounterButton;
	private Button mAboutButton;
	private Button mExitButton;
	//private Button mExitButton;
	DatabaseHelper dbHelper;
	SQLiteDatabase sdb;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		/*dbHelper = new DatabaseHelper(this, "mydatabase.db", null, 1);
		sdb = dbHelper.getWritableDatabase();
		
		ContentValues newValues = new ContentValues();
		newValues.put(dbHelper.EXSPENSE_COLUMN, "1250");
		newValues.put(dbHelper.CATEGORY_COLUMN, "Lunch");
		newValues.put(dbHelper.DATE_COLUMN, "21.07.2015");
		
		sdb.insert("counters", null, newValues);*/
		mEditButton = (Button)findViewById(R.id.edit_button);
		mEditButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent editIntent = new Intent(CounterMainActivity.this, EditActivity.class);
				startActivity(editIntent);
			}
		});
		
		mCounterButton = (Button)findViewById(R.id.counter_button);
		mCounterButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent counterIntent = new Intent(CounterMainActivity.this, CounterActivity.class);
				startActivity(counterIntent);
			}
		});
		
		mAboutButton = (Button)findViewById(R.id.about_button);
		mAboutButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent aboutIntent = new Intent(CounterMainActivity.this, AboutActivity.class);
				startActivity(aboutIntent);
				
			}
		});
		
		mExitButton = (Button) findViewById(R.id.exit_button);
		mExitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
			}
		});
	}
	
	
	public void onCounter(View v){
		Cursor cursor = sdb.query("counters", new String[] {dbHelper.EXSPENSE_COLUMN, dbHelper.CATEGORY_COLUMN, dbHelper.DATE_COLUMN}, null, null, null, null, null);
		cursor.moveToFirst();
		
		String expense = cursor.getString(cursor.getColumnIndex(dbHelper.EXSPENSE_COLUMN));
		String category = cursor.getString(cursor.getColumnIndex(dbHelper.CATEGORY_COLUMN));
		String date = cursor.getString(cursor.getColumnIndex(dbHelper.DATE_COLUMN));
		
		TextView tvInfo = (TextView)findViewById(R.id.textView1);
		tvInfo.setText("Centa" + expense + "Categoriya" + category + "date" + date);
	}

}
