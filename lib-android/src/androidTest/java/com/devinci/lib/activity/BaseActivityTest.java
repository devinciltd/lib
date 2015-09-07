package com.devinci.lib.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.devinci.lib.test.TestBaseActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(AndroidJUnit4.class) public class BaseActivityTest {

  @Rule public ActivityTestRule<TestBaseActivity> activityRule =
      new ActivityTestRule<>(TestBaseActivity.class);

  private TestBaseActivity baseActivity;

  @Before public void setUp() {
    baseActivity = activityRule.getActivity();
  }

  @Test public void shouldInjectCrashReporting() {
    // then
    assertThat(baseActivity.crashReporting).isNotNull();
  }
}
