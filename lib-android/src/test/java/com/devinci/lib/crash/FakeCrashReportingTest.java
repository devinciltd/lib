package com.devinci.lib.crash;

import android.util.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;

import static com.devinci.lib.robolectric.Assertions.assertLogged;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class) public class FakeCrashReportingTest {

  @SuppressWarnings("ConstantConditions") @Test public void shouldLogNullThrowable() {
    FakeCrashReporting.INSTANCE.sendException(null);

    assertLogged(Log.ERROR, FakeCrashReporting.class.getName(), "", null);
  }

  @SuppressWarnings("ConstantConditions") @Test public void shouldLogNullPointerException() {
    NullPointerException expectedException = new NullPointerException();

    FakeCrashReporting.INSTANCE.sendException(expectedException);

    assertLogged(Log.ERROR, FakeCrashReporting.class.getName(), "", expectedException);
  }

  @Test public void shouldInitializeWithoutExceptions() {
    FakeCrashReporting.INSTANCE.initialize(RuntimeEnvironment.application);
  }

  @Test public void shouldNotCrashWhenInitializedMoreThenOnce() {
    FakeCrashReporting.INSTANCE.initialize(RuntimeEnvironment.application);
    FakeCrashReporting.INSTANCE.initialize(RuntimeEnvironment.application);
  }

  @Test public void shouldReturnTheSameInstanceFromAddExtraString() {
    CrashReporting crashReporting = FakeCrashReporting.INSTANCE.addExtra("key", "string");

    assertThat(crashReporting).isSameAs(FakeCrashReporting.INSTANCE);
  }

  @Test public void shouldReturnTheSameInstanceFromAddExtraBoolean() {
    CrashReporting crashReporting = FakeCrashReporting.INSTANCE.addExtra("key", true);

    assertThat(crashReporting).isSameAs(FakeCrashReporting.INSTANCE);
  }

  @Test public void shouldReturnTheSameInstanceFromAddExtraLong() {
    CrashReporting crashReporting = FakeCrashReporting.INSTANCE.addExtra("key", 1L);

    assertThat(crashReporting).isSameAs(FakeCrashReporting.INSTANCE);
  }

  @Test public void shouldReturnTheSameInstanceFromAddExtraInt() {
    CrashReporting crashReporting = FakeCrashReporting.INSTANCE.addExtra("key", 1);

    assertThat(crashReporting).isSameAs(FakeCrashReporting.INSTANCE);
  }

  @Test public void shouldReturnTheSameInstanceFromAddExtraFloat() {
    CrashReporting crashReporting = FakeCrashReporting.INSTANCE.addExtra("key", 1f);

    assertThat(crashReporting).isSameAs(FakeCrashReporting.INSTANCE);
  }

  @Test public void shouldReturnTheSameInstanceFromAddExtraDouble() {
    CrashReporting crashReporting = FakeCrashReporting.INSTANCE.addExtra("key", 1d);

    assertThat(crashReporting).isSameAs(FakeCrashReporting.INSTANCE);
  }

  @Test public void shouldReturnTheSameInstanceFromSetUser() {
    CrashReporting crashReporting = FakeCrashReporting.INSTANCE.setUser("user");

    assertThat(crashReporting).isSameAs(FakeCrashReporting.INSTANCE);
  }

  @Test public void shouldNotCrashOnNullStringExtra() {
    FakeCrashReporting.INSTANCE.addExtra("key", null);
  }

  @Test public void shouldNotCrashOnNullUser() {
    FakeCrashReporting.INSTANCE.setUser(null);
  }

  @SuppressWarnings("ConstantConditions") @Test
  public void shouldNotCrashOnNullKeyFromAddExtraString() {
    FakeCrashReporting.INSTANCE.addExtra(null, "payload");
  }

  @SuppressWarnings("ConstantConditions") @Test
  public void shouldNotCrashOnNullKeyFromAddExtraBoolean() {
    FakeCrashReporting.INSTANCE.addExtra(null, "payload");
  }

  @SuppressWarnings("ConstantConditions") @Test
  public void shouldNotCrashOnNullKeyFromAddExtraLong() {
    FakeCrashReporting.INSTANCE.addExtra(null, "payload");
  }

  @SuppressWarnings("ConstantConditions") @Test
  public void shouldNotCrashOnNullKeyFromAddExtraInt() {
    FakeCrashReporting.INSTANCE.addExtra(null, "payload");
  }

  @SuppressWarnings("ConstantConditions") @Test
  public void shouldNotCrashOnNullKeyFromAddExtraFloat() {
    FakeCrashReporting.INSTANCE.addExtra(null, "payload");
  }

  @SuppressWarnings("ConstantConditions") @Test
  public void shouldNotCrashOnNullKeyFromAddExtraDouble() {
    FakeCrashReporting.INSTANCE.addExtra(null, "payload");
  }
}
