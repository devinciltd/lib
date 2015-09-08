package com.devinci.lib.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.devinci.lib.R;
import com.devinci.lib.app.BaseApplication;
import com.devinci.lib.app.BaseComponent;
import com.devinci.lib.app.DaggerBaseComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = BaseActivityTest.TestBaseApplication.class) public class BaseActivityTest {

  @Test public void shouldInjectCrashReporting() {
    BaseActivity activity = Robolectric.setupActivity(TestBaseActivity.class);

    assertThat(activity.crashReporting).isNotNull();
  }

  private static class TestBaseActivity extends BaseActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setTheme(R.style.lib_Theme_Light_NoActionBar);
    }
  }

  public static class TestBaseApplication extends BaseApplication<BaseComponent> {

    @NonNull @Override protected BaseComponent createBaseComponent() {
      return DaggerBaseComponent.create();
    }
  }
}
