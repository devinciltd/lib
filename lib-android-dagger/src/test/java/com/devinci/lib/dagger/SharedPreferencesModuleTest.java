package com.devinci.lib.dagger;

import android.content.SharedPreferences;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(RobolectricGradleTestRunner.class) public class SharedPreferencesModuleTest {

  private SharedPreferencesModule sharedPreferencesModule;

  @Before public void setUp() {
    sharedPreferencesModule = new SharedPreferencesModule();
  }

  @Test public void shouldNotBeNull() {
    SharedPreferences sharedPreferences =
        sharedPreferencesModule.provideSharedPreferences(RuntimeEnvironment.application);

    assertThat(sharedPreferences).isNotNull();
  }

  @Test public void shouldThrowWhenApplicationIsNull() {
    @SuppressWarnings({ "ThrowableResultOfMethodCallIgnored", "ConstantConditions" }) Throwable
        throwable = catchThrowable(() -> sharedPreferencesModule.provideSharedPreferences(null));

    assertThat(throwable).isExactlyInstanceOf(NullPointerException.class).hasNoCause();
  }
}
