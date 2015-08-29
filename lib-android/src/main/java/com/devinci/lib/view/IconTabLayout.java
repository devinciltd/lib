package com.devinci.lib.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

    if (isLayoutPagerAdapterInstance(adapter)) {
      setTabIconsFromLayoutPagerAdapter((LayoutViewPager.LayoutPagerAdapter) adapter);
    }
  }

  private boolean isLayoutPagerAdapterInstance(@NonNull PagerAdapter adapter) {
    return adapter instanceof LayoutViewPager.LayoutPagerAdapter;
  }

  public void setTabIconsFromLayoutPagerAdapter(
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
