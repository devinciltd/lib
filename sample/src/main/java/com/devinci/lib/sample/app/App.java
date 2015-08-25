package com.devinci.lib.sample.app;

import android.support.annotation.NonNull;
import com.devinci.lib.app.BaseApplication;

public class App extends BaseApplication<AppComponent> {

  @NonNull @Override protected AppComponent createBaseComponent() {
    return DaggerAppComponent.create();
  }
}
