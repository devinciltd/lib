package com.devinci.lib.dagger.module;

import android.app.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricGradleTestRunner.class) public class ActivityModuleTest {

  @Test public void shouldProvidePassedActivity() {
    Activity activity = mock(Activity.class);

    ActivityModule activityModule = new ActivityModule(activity);

    assertThat(activityModule.provideActivity()).isSameAs(activity);
  }

  @SuppressWarnings("ConstantConditions") @Test public void shouldThrowWhenActivityIsNull() {
    Throwable throwable = catchThrowable(() -> new ActivityModule(null));

    assertThat(throwable).isExactlyInstanceOf(NullPointerException.class).hasNoCause();
  }
}
