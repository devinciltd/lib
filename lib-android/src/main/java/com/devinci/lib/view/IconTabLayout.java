package com.devinci.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import com.devinci.lib.R;

public class IconTabLayout extends TabLayout {
  private final boolean pageTitlesVisible;

  public IconTabLayout(Context context) {
    this(context, null);
  }

  public IconTabLayout(Context context, AttributeSet attrs) {
    this(context, attrs, R.attr.lib_iconTabLayoutStyle);
  }

  public IconTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    TypedArray typedArray =
        context.obtainStyledAttributes(attrs, R.styleable.lib_IconTabLayout, defStyleAttr,
            R.style.lib_IconTabLayout);
    try {
      pageTitlesVisible =
          typedArray.getBoolean(R.styleable.lib_IconTabLayout_lib_pageTitlesVisible, true);
    } finally {
      typedArray.recycle();
    }
  }

  @Override public void setTabsFromPagerAdapter(@NonNull PagerAdapter adapter) {
    super.setTabsFromPagerAdapter(
        pageTitlesVisible ? adapter : TitleNullifyingPagerAdapter.from(adapter));

    if (isLayoutPagerAdapterInstance(adapter)) {
      setTabIconsFromLayoutPagerAdapter((LayoutViewPager.LayoutPagerAdapter) adapter);
    }
  }

  private boolean isLayoutPagerAdapterInstance(@NonNull PagerAdapter adapter) {
    return adapter instanceof LayoutViewPager.LayoutPagerAdapter;
  }

  private void setTabIconsFromLayoutPagerAdapter(
      @NonNull LayoutViewPager.LayoutPagerAdapter adapter) {
    for (int i = 0; i < getTabCount(); ++i) {
      setTabIconAtPosition(i, adapter.getPageIcon(i));
    }
  }

  private void setTabIconAtPosition(int position, @Nullable Drawable pageIcon) {
    if (pageIcon != null) {
      Tab tabAt = getTabAt(position);
      if (tabAt != null) {
        tabAt.setIcon(pageIcon);
      }
    }
  }
}
