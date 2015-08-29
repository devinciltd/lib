package com.devinci.lib.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;

public class IconTabLayout extends TabLayout {
  public IconTabLayout(Context context) {
    this(context, null);
  }

  public IconTabLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public IconTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override public void setTabsFromPagerAdapter(@NonNull PagerAdapter adapter) {
    super.setTabsFromPagerAdapter(adapter);

    LayoutViewPager.LayoutPagerAdapter layoutPagerAdapter =
        (LayoutViewPager.LayoutPagerAdapter) adapter;

    for (int i = 0; i < getTabCount(); ++i) {
      Drawable pageIcon = layoutPagerAdapter.getPageIcon(i);
      if (pageIcon != null) {
        getTabAt(i).setIcon(pageIcon);
      }
    }
  }
}
