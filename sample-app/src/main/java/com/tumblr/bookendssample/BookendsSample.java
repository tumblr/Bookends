package com.tumblr.bookendssample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.tumblr.bookends.Bookends;

public class BookendsSample extends ActionBarActivity {

	private RecyclerView mRecyclerView;
	private Bookends<SampleAdapter> mBookends;
	private RecyclerView.LayoutManager mLayoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bookends_sample);

		// Create a RecyclerView with a linear layout manager
		mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);

		// Make Bookends
		SampleAdapter sampleAdapter = new SampleAdapter();
		mBookends = new Bookends<>(sampleAdapter, getBaseContext());

		// Inflate header and footer views
		LayoutInflater inflater = LayoutInflater.from(getBaseContext());
		TextView header1 = (TextView) inflater.inflate(R.layout.sample_textview, mRecyclerView, false);
		header1.setBackgroundColor(Color.CYAN);
		header1.setText("This is a header");

		TextView header2 = (TextView) inflater.inflate(R.layout.sample_textview, mRecyclerView, false);
		header2.setBackgroundColor(Color.YELLOW);
		header2.setText("This is another header");

		TextView footer = (TextView) inflater.inflate(R.layout.sample_textview, mRecyclerView, false);
		footer.setBackgroundColor(Color.MAGENTA);
		footer.setText("This is a footer");

		// Attach header and footer views
		mBookends.addHeader(header1);
		mBookends.addHeader(header2);
		mBookends.addFooter(footer);

		mRecyclerView.setAdapter(mBookends);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_bookends_sample, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
