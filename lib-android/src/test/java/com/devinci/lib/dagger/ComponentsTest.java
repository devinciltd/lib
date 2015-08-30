package com.devinci.lib.dagger;

import android.app.Application;
import android.support.annotation.NonNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = ComponentsTest.TestApplication.class) public class ComponentsTest {

  @Test public void shouldGetComponentFromContext() {
    // when
    Object component = Components.fromContext(RuntimeEnvironment.application);

    // then
    TestApplication testApplication = (TestApplication) RuntimeEnvironment.application;
    assertThat(component).isEqualTo(testApplication.getComponent());
  }

  public static class TestApplication extends Application implements HasComponent<Object> {

    private final Object component = new Object();

    @NonNull @Override public Object getComponent() {
      return component;
    }
  }
}
