package com.devinci.lib.app;

import android.content.Context;
import android.support.annotation.NonNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = BaseApplicationTest.TestBaseApplication.class)
public class BaseApplicationTest {

  @Test public void shouldInitializeCrashReportingFromBaseComponent() {
    // given
    TestBaseApplication testBaseApplication = (TestBaseApplication) RuntimeEnvironment.application;

    // then
    verify(testBaseApplication.getComponent().crashReporting()).initialize(isA(Context.class));
  }

  public static class TestBaseApplication extends BaseApplication<BaseComponent> {

    @NonNull @Override protected BaseComponent createBaseComponent() {
      return mock(BaseComponent.class, RETURNS_DEEP_STUBS);
    }
  }
}
