package com.devinci.lib.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.devinci.lib.activity.BaseActivity;
import com.devinci.lib.dagger.Components;
import com.devinci.lib.dagger.HasComponent;
import com.devinci.lib.dagger.module.ActivityModule;
import com.devinci.lib.sample.app.AppComponent;

public class MainActivity extends BaseActivity implements HasComponent<MainActivityComponent> {

  private MainActivityComponent mainActivityComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mainActivityComponent = DaggerMainActivityComponent.builder()
        .appComponent(Components.<AppComponent>fromContext(this))
        .activityModule(ActivityModule.from(this))
        .build()
        .inject(this)
        .getComponent();

    // Crash reporting should be injected (crashReporting != null)
    crashReporting.sendException(new RuntimeException());
  }

  @NonNull @Override public MainActivityComponent getComponent() {
    return mainActivityComponent;
  }
}
