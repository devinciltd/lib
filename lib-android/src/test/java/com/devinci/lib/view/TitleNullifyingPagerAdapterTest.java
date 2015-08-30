package com.devinci.lib.view;

import android.support.v4.view.PagerAdapter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.MockitoAnnotations.initMocks;

public class TitleNullifyingPagerAdapterTest {

  @Mock private PagerAdapter pagerAdapter;

  @Before public void setUp() {
    initMocks(this);
  }

  @Test public void shouldNullifyPageTitle() {
    // given
    given(pagerAdapter.getPageTitle(anyInt())).willReturn("some title");
    TitleNullifyingPagerAdapter titleNullifyingPagerAdapter =
        TitleNullifyingPagerAdapter.from(pagerAdapter);

    // when
    CharSequence pageTitle = titleNullifyingPagerAdapter.getPageTitle(0);

    // then
    assertThat(pageTitle).isNull();
  }
}
