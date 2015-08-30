package com.devinci.lib.view;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import static com.devinci.lib.util.Preconditions.checkNotNull;

public final class ToolbarUtils {

  public static void setupPageSelectionNotifications(@NonNull final Toolbar toolbar,
      @NonNull final ViewPager viewPager) {
    checkNotNull(toolbar);
    checkNotNull(viewPager);

    viewPager.addOnPageChangeListener(
        new InitiallyNotifyingOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
          @Override public void onPageSelected(int position) {
            toolbar.setTitle(viewPager.getAdapter().getPageTitle(position));
          }
        }));
  }
}
