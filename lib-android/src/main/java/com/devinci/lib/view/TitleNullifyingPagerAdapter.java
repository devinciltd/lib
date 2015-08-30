package com.devinci.lib.view;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import static com.devinci.lib.util.Preconditions.checkNotNull;

class TitleNullifyingPagerAdapter extends PagerAdapter {
  private final PagerAdapter delegate;

  @NonNull public static TitleNullifyingPagerAdapter from(@NonNull PagerAdapter adapter) {
    return new TitleNullifyingPagerAdapter(adapter);
  }

  private TitleNullifyingPagerAdapter(@NonNull PagerAdapter adapter) {
    this.delegate = checkNotNull(adapter);
  }

  @Override public int getCount() {
    return delegate.getCount();
  }

  @Override public void startUpdate(ViewGroup container) {
    delegate.startUpdate(container);
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    return delegate.instantiateItem(container, position);
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    delegate.destroyItem(container, position, object);
  }

  @Override public void setPrimaryItem(ViewGroup container, int position, Object object) {
    delegate.setPrimaryItem(container, position, object);
  }

  @Override public void finishUpdate(ViewGroup container) {
    delegate.finishUpdate(container);
  }

  @SuppressWarnings("deprecation") @Override public void startUpdate(View container) {
    delegate.startUpdate(container);
  }

  @SuppressWarnings("deprecation") @Override
  public Object instantiateItem(View container, int position) {
    return delegate.instantiateItem(container, position);
  }

  @SuppressWarnings("deprecation") @Override
  public void destroyItem(View container, int position, Object object) {
    delegate.destroyItem(container, position, object);
  }

  @SuppressWarnings("deprecation") @Override
  public void setPrimaryItem(View container, int position, Object object) {
    delegate.setPrimaryItem(container, position, object);
  }

  @SuppressWarnings("deprecation") @Override public void finishUpdate(View container) {
    delegate.finishUpdate(container);
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return delegate.isViewFromObject(view, object);
  }

  @Override public Parcelable saveState() {
    return delegate.saveState();
  }

  @Override public void restoreState(Parcelable state, ClassLoader loader) {
    delegate.restoreState(state, loader);
  }

  @Override public int getItemPosition(Object object) {
    return delegate.getItemPosition(object);
  }

  @Override public void notifyDataSetChanged() {
    delegate.notifyDataSetChanged();
  }

  @Override public void registerDataSetObserver(DataSetObserver observer) {
    delegate.registerDataSetObserver(observer);
  }

  @Override public void unregisterDataSetObserver(DataSetObserver observer) {
    delegate.unregisterDataSetObserver(observer);
  }

  @Override public CharSequence getPageTitle(int position) {
    return null;
  }

  @Override public float getPageWidth(int position) {
    return delegate.getPageWidth(position);
  }
}
