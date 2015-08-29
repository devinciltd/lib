package com.devinci.lib.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.devinci.lib.R;

public class LayoutViewPager extends ViewPager {
  public LayoutViewPager(Context context) {
    this(context, null);
  }

  public LayoutViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
    TypedArray typedArray =
        getContext().obtainStyledAttributes(attrs, R.styleable.lib_LayoutViewPager_LayoutParams);
    try {
      return new LayoutViewPager.LayoutParams(getContext(), attrs,
          typedArray.getResourceId(R.styleable.lib_LayoutViewPager_LayoutParams_lib_pageIcon, 0),
          typedArray.getString(R.styleable.lib_LayoutViewPager_LayoutParams_lib_pageTitle));
    } finally {
      typedArray.recycle();
    }
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    setAdapter(new LayoutPagerAdapter());
  }

  public class LayoutPagerAdapter extends PagerAdapter {

    @Override public int getCount() {
      return getChildCount();
    }

    @Override public boolean isViewFromObject(View view, Object object) {
      return view == object;
    }

    @Override public Object instantiateItem(ViewGroup container, int position) {
      return container.getChildAt(position);
    }

    @Override public CharSequence getPageTitle(int position) {
      return ((LayoutParams) getChildAt(position).getLayoutParams()).pageTitle;
    }

    @Nullable public Drawable getPageIcon(int position) {
      try {
        return ResourcesCompat.getDrawable(getResources(),
            ((LayoutParams) getChildAt(position).getLayoutParams()).pageIconResId, null);
      } catch (Resources.NotFoundException e) {
        return null;
      }
    }
  }

  private static class LayoutParams extends android.support.v4.view.ViewPager.LayoutParams {

    @DrawableRes private int pageIconResId;
    private final String pageTitle;

    public LayoutParams(Context context, AttributeSet attrs, @DrawableRes int pageIconResId,
        @Nullable String pageTitle) {
      super(context, attrs);
      this.pageIconResId = pageIconResId;
      this.pageTitle = pageTitle;
    }
  }
}
