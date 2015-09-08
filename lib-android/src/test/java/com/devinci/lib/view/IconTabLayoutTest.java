package com.devinci.lib.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import com.devinci.lib.BuildConfig;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.res.Attribute;
import org.robolectric.shadows.RoboAttributeSet;

import static org.assertj.android.design.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class) public class IconTabLayoutTest {

  @Mock private PagerAdapter pagerAdapter;
  @Mock private LayoutViewPager.LayoutPagerAdapter layoutPagerAdapter;

  @Before public void setUp() {
    initMocks(this);
    configureMock(pagerAdapter);
    configureMock(layoutPagerAdapter);
    given(layoutPagerAdapter.getPageIcon(0)).willReturn(mock(Drawable.class));
    given(layoutPagerAdapter.getPageIcon(1)).willReturn(mock(Drawable.class));
  }

  @Test public void shouldSetTabsFromPagerAdapterInstance() {
    // given
    IconTabLayout iconTabLayout = new IconTabLayout(RuntimeEnvironment.application);
    given(pagerAdapter.getCount()).willReturn(2);

    // when
    iconTabLayout.setTabsFromPagerAdapter(pagerAdapter);

    // then
    assertThat(iconTabLayout.getTabAt(0)).hasIcon(null).hasText("barbers");
    assertThat(iconTabLayout.getTabAt(1)).hasIcon(null).hasText("lumberjacks");
  }

  @Test public void shouldSetPageTitlesAndIconsByDefault() {
    // given
    IconTabLayout iconTabLayout = new IconTabLayout(RuntimeEnvironment.application);

    // when
    iconTabLayout.setTabsFromPagerAdapter(layoutPagerAdapter);

    // then
    assertThat(iconTabLayout.getTabAt(0)).hasText("barbers")
        .hasIcon(layoutPagerAdapter.getPageIcon(0));
    assertThat(iconTabLayout.getTabAt(1)).hasText("lumberjacks")
        .hasIcon(layoutPagerAdapter.getPageIcon(1));
  }

  @Test public void shouldNotSetPageTitlesIfAttributeSetToFalse() {
    // given
    Context context = RuntimeEnvironment.application;
    AttributeSet attributeSet = createAttributeSetWithPageTitlesVisible(context, false);
    IconTabLayout iconTabLayout = new IconTabLayout(context, attributeSet);

    // when
    iconTabLayout.setTabsFromPagerAdapter(layoutPagerAdapter);

    // then
    assertThat(iconTabLayout.getTabAt(0)).hasText(null).hasIcon(layoutPagerAdapter.getPageIcon(0));
    assertThat(iconTabLayout.getTabAt(1)).hasText(null).hasIcon(layoutPagerAdapter.getPageIcon(1));
  }

  private void configureMock(@NonNull PagerAdapter pagerAdapter) {
    given(pagerAdapter.getCount()).willReturn(2);
    given(pagerAdapter.getPageTitle(0)).willReturn("barbers");
    given(pagerAdapter.getPageTitle(1)).willReturn("lumberjacks");
  }

  @NonNull private AttributeSet createAttributeSetWithPageTitlesVisible(@NonNull Context context,
      boolean pageTitlesVisible) {
    return new RoboAttributeSet(Lists.newArrayList(
        new Attribute(BuildConfig.APPLICATION_ID + ":attr/lib_pageTitlesVisible",
            String.valueOf(pageTitlesVisible), BuildConfig.APPLICATION_ID)),
        shadowOf(context.getResources()).getResourceLoader());
  }
}
