package com.devinci.lib.view;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;

import static com.devinci.lib.util.Preconditions.checkNotNull;

class InitiallyNotifyingOnPageChangeListener implements ViewPager.OnPageChangeListener {

  private final ViewPager.OnPageChangeListener delegate;
  public boolean shouldNotifyInitially;

  public InitiallyNotifyingOnPageChangeListener(
      @NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
    this.delegate = checkNotNull(onPageChangeListener);
    this.shouldNotifyInitially = true;
  }

  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    delegate.onPageScrolled(position, positionOffset, positionOffsetPixels);

    if (shouldNotifyInitially) {
      delegate.onPageSelected(position);
      shouldNotifyInitially = false;
    }
  }

  @Override public void onPageSelected(int position) {
    delegate.onPageSelected(position);
  }

  @Override public void onPageScrollStateChanged(int state) {
    delegate.onPageScrollStateChanged(state);
  }
}
