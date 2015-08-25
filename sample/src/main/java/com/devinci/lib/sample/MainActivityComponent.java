package com.devinci.lib.sample;

import com.devinci.lib.dagger.PerActivity;
import com.devinci.lib.dagger.module.ActivityModule;
import com.devinci.lib.sample.app.AppComponent;
import dagger.Component;

@PerActivity @Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface MainActivityComponent {
  MainActivity inject(MainActivity mainActivity);
}
