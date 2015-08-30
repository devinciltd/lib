package com.devinci.lib.view;

import android.support.v4.view.ViewPager;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InitiallyNotifyingOnPageChangeListenerTest {

  @Test public void shouldCallOnPageSelectedJustOnceWhenScrolled() {
    // given
    ViewPager.OnPageChangeListener onPageChangeListener =
        mock(ViewPager.OnPageChangeListener.class);
    InitiallyNotifyingOnPageChangeListener initiallyNotifyingOnPageChangeListener =
        new InitiallyNotifyingOnPageChangeListener(onPageChangeListener);

    // when
    initiallyNotifyingOnPageChangeListener.onPageScrolled(44, 0.0f, 0);
    initiallyNotifyingOnPageChangeListener.onPageScrolled(44, 1.0f, 0);

    // then
    verify(onPageChangeListener).onPageSelected(44);
  }
}
