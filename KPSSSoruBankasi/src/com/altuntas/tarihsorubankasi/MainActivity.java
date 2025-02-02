package com.altuntas.tarihsorubankasi;

import java.io.IOException;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public Button BtnNext;
	public Button BtnBefore;
	public Button BtnSonuc;
	public SQLiteDatabase SqlLite;
	public TextView FistSelection;
	public TextView SecondSelection;
	public TextView ThirdSelection;
	public TextView FourthSelection;
	public TextView FifthSelection;
	public TextView Answer;
	public Integer i = 0;
	public Integer j = 0;
	public TextView Question;
	public View view;
	public View view1;
	public View view2;
	public View view3;
	public View view4;
	public TextView TxtResult;
	public int resulttrue = 0;
	public int resultfalse = 0;
	public int totalresult = 0;
	public TextView intdegeri;
	Cursor ca = null;
	Cursor ca2 = null;
	int totali = 1;
	String total = "";

	public void secenek() {

		i = i + 1;
		if (i > 50) {

			Intent myIntent = new Intent(getApplicationContext(), Sonuc.class);
			myIntent.putExtra("totalresult", totalresult);
			myIntent.putExtra("resulttrue", resulttrue);
			startActivity(myIntent);

		} else {

			if (i <= j) {
				FistSelection.setClickable(false);
				SecondSelection.setClickable(false);
				ThirdSelection.setClickable(false);
				FourthSelection.setClickable(false);
				FifthSelection.setClickable(false);

				DatabaseHelper myDbHelper = new DatabaseHelper(
						getApplicationContext());
				try {

					myDbHelper.createDataBase();

				} catch (IOException ioe) {

					throw new Error("Unable to create database");

				}

				try {

					myDbHelper.openDataBase();

				} catch (SQLException sqle) {

					throw sqle;

				}

				ca = myDbHelper.query(i);
				if (ca.moveToFirst()) {
					do {
						String soru = ca.getString(1);
						String cevap = ca.getString(2);
						String sec1 = ca.getString(3);
						String sec2 = ca.getString(4);
						String sec3 = ca.getString(5);
						String sec4 = ca.getString(6);
						String sec5 = ca.getString(7);
						// display on text view
						FistSelection.setText(sec1);
						SecondSelection.setText(sec2);
						ThirdSelection.setText(sec3);
						FourthSelection.setText(sec4);
						FifthSelection.setText(sec5);
						Question.setText(soru);
						Answer.setText(cevap);
					} while (ca.moveToNext());
				}

			} else {

				j = j + 1;

			}
			FistSelection.setTextColor(Color.GRAY);
			SecondSelection.setTextColor(Color.GRAY);
			ThirdSelection.setTextColor(Color.GRAY);
			FourthSelection.setTextColor(Color.GRAY);
			FifthSelection.setTextColor(Color.GRAY);

			FistSelection.setClickable(true);
			SecondSelection.setClickable(true);
			ThirdSelection.setClickable(true);
			FourthSelection.setClickable(true);
			FifthSelection.setClickable(true);

			DatabaseHelper myDbHelper = new DatabaseHelper(
					getApplicationContext());
			try {

				myDbHelper.createDataBase();

			} catch (IOException ioe) {

				throw new Error("Unable to create database");

			}

			try {

				myDbHelper.openDataBase();

			} catch (SQLException sqle) {

				throw sqle;

			}
			ca = myDbHelper.query(i);
			if (ca.moveToFirst()) {
				do {
					String soru = ca.getString(1);
					String cevap = ca.getString(2);
					String sec1 = ca.getString(3);
					String sec2 = ca.getString(4);
					String sec3 = ca.getString(5);
					String sec4 = ca.getString(6);
					String sec5 = ca.getString(7);
					// display on text view
					FistSelection.setText(sec1);
					SecondSelection.setText(sec2);
					ThirdSelection.setText(sec3);
					FourthSelection.setText(sec4);
					FifthSelection.setText(sec5);
					Question.setText(soru);
					Answer.setText(cevap);
				} while (ca.moveToNext());
			}

			FistSelection.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					totalresult = totalresult + 1;

					String sec1 = (String) FistSelection.getText();
					String sec2 = (String) SecondSelection.getText();
					String sec3 = (String) ThirdSelection.getText();
					String sec4 = (String) FourthSelection.getText();
					String sec5 = (String) FifthSelection.getText();
					String cevap = (String) Answer.getText();

					if (sec1.equals(cevap)) {
						resulttrue = resulttrue + 1;
						// Toast.makeText(getApplicationContext(),
						// "Do�ru Cevap "+
						// resulttrue,
						// Toast.LENGTH_SHORT).show();
						// TxtResult.setText(getString(result));
						FistSelection.setTextColor(Color.parseColor("#00CC00"));
					} else {
						// Toast.makeText(getApplicationContext(),
						// "Yanl�� Cevap",
						// Toast.LENGTH_SHORT).show();
						FistSelection.setTextColor(Color.RED);
						if (sec2.equals(cevap)) {
							SecondSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else if (sec3.equals(cevap)) {
							ThirdSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else if (sec4.equals(cevap)) {
							FourthSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else if (sec5.equals(cevap)) {
							FifthSelection.setTextColor(Color
									.parseColor("#00CC00"));
						}

					}
					FistSelection.setClickable(false);
					SecondSelection.setClickable(false);
					ThirdSelection.setClickable(false);
					FourthSelection.setClickable(false);
					FifthSelection.setClickable(false);

				}
			});

			SecondSelection.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					totalresult = totalresult + 1;

					String sec1 = (String) FistSelection.getText();
					String sec2 = (String) SecondSelection.getText();
					String sec3 = (String) ThirdSelection.getText();
					String sec4 = (String) FourthSelection.getText();
					String sec5 = (String) FifthSelection.getText();
					String cevap = (String) Answer.getText();

					if (sec2.equals(cevap)) {
						resulttrue = resulttrue + 1;
						// Toast.makeText(getApplicationContext(),
						// "Do�ru Cevap "+
						// resulttrue,
						// Toast.LENGTH_SHORT).show();
						SecondSelection.setTextColor(Color
								.parseColor("#00CC00"));
					} else {
						// Toast.makeText(getApplicationContext(),
						// "Yanl�� Cevap",
						// Toast.LENGTH_SHORT).show();
						SecondSelection.setTextColor(Color.RED);
						if (sec1.equals(cevap)) {
							FistSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else if (sec3.equals(cevap)) {
							ThirdSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else if (sec4.equals(cevap)) {
							FourthSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else if (sec5.equals(cevap)) {
							FifthSelection.setTextColor(Color
									.parseColor("#00CC00"));
						}

					}
					FistSelection.setClickable(false);
					SecondSelection.setClickable(false);
					ThirdSelection.setClickable(false);
					FourthSelection.setClickable(false);
					FifthSelection.setClickable(false);
				}
			});

			ThirdSelection.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					totalresult = totalresult + 1;

					String sec1 = (String) FistSelection.getText();
					String sec2 = (String) SecondSelection.getText();
					String sec3 = (String) ThirdSelection.getText();
					String sec4 = (String) FourthSelection.getText();
					String sec5 = (String) FifthSelection.getText();
					String cevap = (String) Answer.getText();

					if (sec3.equals(cevap)) {
						resulttrue = resulttrue + 1;
						// Toast.makeText(getApplicationContext(),
						// "Do�ru Cevap "+
						// resulttrue,
						// Toast.LENGTH_SHORT).show();
						String Result = Integer.toString(resulttrue);
						TxtResult.setText("Do�ru Cevap Say�s�= " + Result + " "
								+ "Toplam cevap say�s�" + totalresult);
						ThirdSelection.setTextColor(Color.parseColor("#00CC00"));

					} else {
						// Toast.makeText(getApplicationContext(),
						// "Yanl�� Cevap",
						// Toast.LENGTH_SHORT).show();
						ThirdSelection.setTextColor(Color.RED);
						if (sec1.equals(cevap)) {
							FistSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else {
							SecondSelection.setTextColor(Color
									.parseColor("#00CC00"));
						}

					}
					FistSelection.setClickable(false);
					SecondSelection.setClickable(false);
					ThirdSelection.setClickable(false);
					FourthSelection.setClickable(false);
					FifthSelection.setClickable(false);
				}
			});
			FourthSelection.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					totalresult = totalresult + 1;

					String sec1 = (String) FistSelection.getText();
					String sec2 = (String) SecondSelection.getText();
					String sec3 = (String) ThirdSelection.getText();
					String sec4 = (String) FourthSelection.getText();
					String sec5 = (String) FifthSelection.getText();

					String cevap = (String) Answer.getText();

					if (sec4.equals(cevap)) {
						resulttrue = resulttrue + 1;
						// Toast.makeText(getApplicationContext(),
						// "Do�ru Cevap "+
						// resulttrue,
						// Toast.LENGTH_SHORT).show();
						String Result = Integer.toString(resulttrue);
						TxtResult.setText("Do�ru Cevap Say�s�= " + Result + " "
								+ "Toplam cevap say�s�" + totalresult);
						FourthSelection.setTextColor(Color
								.parseColor("#00CC00"));

					} else {
						// Toast.makeText(getApplicationContext(),
						// "Yanl�� Cevap",
						// Toast.LENGTH_SHORT).show();
						FourthSelection.setTextColor(Color.RED);
						if (sec1.equals(cevap)) {
							FistSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else if (sec2.equals(cevap)) {
							SecondSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else if (sec3.equals(cevap)) {
							ThirdSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else {
							FifthSelection.setTextColor(Color
									.parseColor("#00CC00"));
						}
					}
					FistSelection.setClickable(false);
					SecondSelection.setClickable(false);
					ThirdSelection.setClickable(false);
					FourthSelection.setClickable(false);
					FifthSelection.setClickable(false);
				}
			});
			FifthSelection.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					totalresult = totalresult + 1;

					String sec1 = (String) FistSelection.getText();
					String sec2 = (String) SecondSelection.getText();
					String sec3 = (String) ThirdSelection.getText();
					String sec4 = (String) FourthSelection.getText();
					String sec5 = (String) FifthSelection.getText();

					String cevap = (String) Answer.getText();

					if (sec5.equals(cevap)) {
						resulttrue = resulttrue + 1;
						// Toast.makeText(getApplicationContext(),
						// "Do�ru Cevap "+
						// resulttrue,
						// Toast.LENGTH_SHORT).show();
						String Result = Integer.toString(resulttrue);
						TxtResult.setText("Do�ru Cevap Say�s�= " + Result + " "
								+ "Toplam cevap say�s�" + totalresult);
						FifthSelection.setTextColor(Color.parseColor("#00CC00"));

					} else {
						// Toast.makeText(getApplicationContext(),
						// "Yanl�� Cevap",
						// Toast.LENGTH_SHORT).show();
						FifthSelection.setTextColor(Color.RED);
						if (sec1.equals(cevap)) {
							FistSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else if (sec2.equals(cevap)) {
							SecondSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else if (sec3.equals(cevap)) {
							ThirdSelection.setTextColor(Color
									.parseColor("#00CC00"));
						} else {
							FourthSelection.setTextColor(Color
									.parseColor("#00CC00"));
						}
					}
					FistSelection.setClickable(false);
					SecondSelection.setClickable(false);
					ThirdSelection.setClickable(false);
					FourthSelection.setClickable(false);
					FifthSelection.setClickable(false);
				}
			});
		}
	}

	public void init() {
		Question = (TextView) findViewById(R.id.text1);
		FistSelection = (TextView) findViewById(R.id.text2);
		SecondSelection = (TextView) findViewById(R.id.text3);
		ThirdSelection = (TextView) findViewById(R.id.text4);
		FourthSelection = (TextView) findViewById(R.id.text5);
		FifthSelection = (TextView) findViewById(R.id.text6);
		BtnNext = (Button) findViewById(R.id.BtnNext);
		BtnBefore = (Button) findViewById(R.id.BtnBefore);
		Answer = (TextView) findViewById(R.id.textView1);
		view = (RelativeLayout) findViewById(R.id.view);
		view2 = (LinearLayout) findViewById(R.id.pn2);
		view3 = (LinearLayout) findViewById(R.id.pnl);
		view4 = (LinearLayout) findViewById(R.id.pn4);
		TxtResult = (TextView) findViewById(R.id.textView4);
		BtnNext.setText(">");
		BtnBefore.setText("<");
		intdegeri = (TextView) findViewById(R.id.textView6);
		BtnSonuc = (Button) findViewById(R.id.ButtonSnc);
		BtnSonuc.setText("Sonu�");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		secenek();

		BtnSonuc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Toast.makeText(
						getApplicationContext(),
						"Toplam Cevap Say�s�: " + totalresult + "\n"
								+ "Toplam Do�ru Cevap Say�s�: " + resulttrue
								+ "\n" + "Toplam Yanl�� Cevap Say�s�: "
								+ ((totalresult) - (resulttrue)) + "\n",
						Toast.LENGTH_SHORT).show();
			}
		});

		BtnBefore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				FistSelection.setTextColor(Color.GRAY);
				SecondSelection.setTextColor(Color.GRAY);
				ThirdSelection.setTextColor(Color.GRAY);
				FourthSelection.setTextColor(Color.GRAY);
				FifthSelection.setTextColor(Color.GRAY);

				FistSelection.setClickable(false);
				SecondSelection.setClickable(false);
				ThirdSelection.setClickable(false);
				FourthSelection.setClickable(false);
				FifthSelection.setClickable(false);

				if (i > 1)
					i = i - 1;
				else
					i = 1;

				DatabaseHelper myDbHelper = new DatabaseHelper(
						getApplicationContext());
				try {

					myDbHelper.createDataBase();

				} catch (IOException ioe) {

					throw new Error("Unable to create database");

				}

				try {

					myDbHelper.openDataBase();

				} catch (SQLException sqle) {

					throw sqle;

				}
				// Toast.makeText(getApplicationContext(), "Success",
				// Toast.LENGTH_SHORT).show();

				// Count hesab�n� yapt�k

				ca = myDbHelper.querycount();
				if (ca.moveToFirst()) {
					do {
						Question.setText("");
						FistSelection.setText("");
						SecondSelection.setText("");
						ThirdSelection.setText("");
						Answer.setText("");
						String total = ca.getString(0);
						// int totali = Integer.parseInt(total);
						int totali = Integer.parseInt(total);
						// Toast.makeText(getApplicationContext(),
						// total + " ve i=" + i, Toast.LENGTH_SHORT)
						// .show();
					} while (ca.moveToNext());
				}
				// Toast.makeText(getApplicationContext(),total+" ve i="+i ,
				// Toast.LENGTH_SHORT).show();

				// Count i'den k���k ise exit

				// if (totali >= i) {
				ca = myDbHelper.query(i);
				if (ca.moveToFirst()) {
					do {
						String soru = ca.getString(1);
						String cevap = ca.getString(2);
						String sec1 = ca.getString(3);
						String sec2 = ca.getString(4);
						String sec3 = ca.getString(5);
						String sec4 = ca.getString(6);
						String sec5 = ca.getString(7);
						// display on text view
						FistSelection.setText(sec1);
						SecondSelection.setText(sec2);
						ThirdSelection.setText(sec3);
						FourthSelection.setText(sec4);
						FifthSelection.setText(sec5);
						Question.setText(soru);
						Answer.setText(cevap);
					} while (ca.moveToNext());
				}
			}
		});

		BtnNext.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				secenek();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
