package com.tumblr.bookendssample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Simple adapter that makes a bunch of TextViews.
 */
public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {

	private static final int NUM_ITEMS = 100;

	private String[] mDataset;

	public static class ViewHolder extends RecyclerView.ViewHolder {
		private TextView mTextView;
		public ViewHolder(TextView v) {
			super(v);
			mTextView = v;
		}
	}

	public SampleAdapter() {
		mDataset = new String[NUM_ITEMS];
		for (int i = 0; i < NUM_ITEMS; i++) {
			mDataset[i] = String.valueOf(i);
		}
	}

	@Override
	public SampleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
												   int viewType) {
		TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(
				R.layout.sample_textview, parent, false);
		return new ViewHolder(textView);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.mTextView.setText("This is item " + mDataset[position]);
	}

	@Override
	public int getItemCount() {
		return mDataset.length;
	}
}
