package com.devinci.lib.test;

import android.support.annotation.NonNull;
import com.devinci.lib.app.BaseApplication;
import com.devinci.lib.app.BaseComponent;
import com.devinci.lib.app.DaggerBaseComponent;

public class TestBaseApplication extends BaseApplication<BaseComponent> {

  @NonNull @Override protected BaseComponent createBaseComponent() {
    return DaggerBaseComponent.create();
  }
}
