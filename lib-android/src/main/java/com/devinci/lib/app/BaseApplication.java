package com.devinci.lib.app;

import android.app.Application;
import android.support.annotation.NonNull;
import com.devinci.lib.dagger.HasComponent;

/**
 * Base application with global state.
 */
public abstract class BaseApplication<T extends BaseComponent> extends Application implements
    HasComponent<T> {

  private T baseComponent;

  @Override public void onCreate() {
    super.onCreate();
    baseComponent = createBaseComponent();
    baseComponent.crashReporting().initialize(this);
  }

  @NonNull protected abstract T createBaseComponent();

  @NonNull @Override public T getComponent() {
    return baseComponent;
  }
}
