package com.counter;


import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class EditActivity extends Activity {
	
	
	private EditText mExpenseText;
	private Spinner mCategory;
	String[] data = {"garments", "food", "bus ticket", "subway ticket", "public spending"};
	DatabaseHelper dbHelper;
	SQLiteDatabase sdb;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit);
		mCategory = (Spinner)findViewById(R.id.expense_category);
		mCategory.setPrompt("Category");
		mExpenseText = (EditText) findViewById(R.id.edit_expense);
		/*Button confirmButton = (Button) findViewById(R.id.save_expense);*/
		final DatePicker datePicker = (DatePicker) findViewById(R.id.today);
		/*confirmButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dbHelper = new DatabaseHelper(this, "mydatabase.db", null, 1);
				sdb = dbHelper.getWritableDatabase();
		
				ContentValues newValues = new ContentValues();
				newValues.put(dbHelper.EXSPENSE_COLUMN, "1250");
				newValues.put(dbHelper.CATEGORY_COLUMN, "Lunch");
				newValues.put(dbHelper.DATE_COLUMN, "21.07.2015");
		
				sdb.insert("counters", null, newValues);
			}
		});*/
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		saveState();
	}
	
	@Override
	protected void onResume() {
	    super.onResume();
	}
	
	private void saveState() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		Spinner spinner = (Spinner) findViewById(R.id.expense_category);
		spinner.setAdapter(adapter);
		spinner.setPrompt("Category");
		spinner.setSelection(2);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}
	
	public void onSave(View v){
		dbHelper = new DatabaseHelper(this, "mydatabase.db", null, 1);
		sdb = dbHelper.getWritableDatabase();
		
		ContentValues newValues = new ContentValues();
		newValues.put(dbHelper.EXSPENSE_COLUMN, "1250");
		newValues.put(dbHelper.CATEGORY_COLUMN, "Lunch");
		newValues.put(dbHelper.DATE_COLUMN, "21.07.2015");
		sdb.insert("counters", null, newValues);
	}
}

