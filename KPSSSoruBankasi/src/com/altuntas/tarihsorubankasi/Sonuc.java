package com.altuntas.tarihsorubankasi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Sonuc extends Activity {

	public Intent myIntent;
	public TextView TotalResult;
	public TextView TotalTrueResult;
	public TextView TotalFalseResult;
	public TextView Explanation;
	public TextView Sonuc;


	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sonuc);
		TotalResult = (TextView) findViewById(R.id.textView12);
		TotalTrueResult = (TextView) findViewById(R.id.textView22);
		TotalFalseResult = (TextView) findViewById(R.id.textView32);
		Explanation = (TextView) findViewById(R.id.textView42);
		Sonuc = (TextView) findViewById(R.id.textView52);

		
		TotalTrueResult.setTextColor(Color.parseColor("#00CC00"));
		TotalFalseResult.setTextColor(Color.RED);
		//Explanation.setTextColor(Color.parseColor("#3BB9FF"));
		Sonuc.setTextColor(Color.parseColor("#3BB9FF"));

		

		
		Intent mIntent = getIntent();
		int total = mIntent.getIntExtra("totalresult", 0);
		int trueresult = mIntent.getIntExtra("resulttrue", 0);

		TotalResult.setText("Toplam Cevap Say�s�: "+ total);
		TotalTrueResult.setText("Toplam Do�ru Cevap Say�s�: "+ trueresult);
		TotalFalseResult.setText("Toplam Yanl�� Cevap Say�s�: "+ ((total) - (trueresult)));

				
	}
}
