package com.tumblr.bookends;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * An implementation of {@link Bookends} that accounts for spans in a {@link GridLayoutManager} when
 * creating headers and footers.
 * <p/>
 * This class performs a {@link android.support.v7.widget.GridLayoutManager.SpanSizeLookup} using either
 * the span count returned by the {@link GridLayoutManager} or a custom implementation. By default
 * headers and footers will fill the span count of the {@link GridLayoutManager}.
 * <p/>
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
	 * 		the adapter to wrap
	 * @param gridLayoutManager
	 * 		the grid layout manager to perform a span size lookup on
	 */
	public GridBookends(final RecyclerView.Adapter base, @NonNull final GridLayoutManager gridLayoutManager) {
		this(base);
		gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
			@Override
			public int getSpanSize(int position) {
				return (position < getHeaderCount() || position >= getItemCount() - getFooterCount())
						? gridLayoutManager.getSpanCount()
						: 1;
			}
		});
	}

	/**
	 * Constructor.
	 *
	 * @param base
	 * 		the adapter to wrap
	 * @param gridLayoutManager
	 * 		the grid layout manager to perform a span size lookup on
	 * @param spanSizeLookup
	 * 		the span size lookup to perform
	 */
	public GridBookends(final RecyclerView.Adapter base, @NonNull final GridLayoutManager gridLayoutManager,
	                    @NonNull GridLayoutManager.SpanSizeLookup spanSizeLookup) {
		this(base);
		gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
	}
}
