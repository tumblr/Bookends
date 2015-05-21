package com.tumblr.bookends;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Implementation of {@link Bookends} that works with {@link android.widget.GridLayout}.
 * Created by kevincoughlin on 5/21/15.
 */
public class GridBookends extends Bookends {
	/**
	 * Constructor.
	 *
	 * @param base
	 * 		the adapter to wrap
	 */
	public GridBookends(RecyclerView.Adapter base) {
		super(base);
	}

	/**
	 * Constructor.
	 *
	 * @param base
	 *      the adapter to wrap
	 * @param manager
	 *      the grid layout manager to perform a span size lookup on
	 */
	public GridBookends(final RecyclerView.Adapter base, @NonNull final GridLayoutManager manager) {
		this(base);

		manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
			@Override
			public int getSpanSize(int position ) {
				return (position < getHeaderCount() || position >= getItemCount() - getFooterCount())
						? manager.getSpanCount()
						: 1;
			}
		});
	}

	/**
	 * Constructor.
	 *
	 * @param base
	 *      the adapter to wrap
	 * @param manager
	 *      the grid layout manager to perform a span size lookup on
	 * @param lookup
	 *      the span size lookup to perform
	 */
	public GridBookends(final RecyclerView.Adapter base, @NonNull final GridLayoutManager manager,
	                    @NonNull GridLayoutManager.SpanSizeLookup lookup) {
		this(base);
		manager.setSpanSizeLookup(lookup);
	}
}
