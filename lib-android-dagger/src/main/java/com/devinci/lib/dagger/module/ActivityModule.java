package com.devinci.lib.dagger.module;

import android.app.Activity;
import android.support.annotation.NonNull;
import dagger.Module;
import dagger.Provides;

import static com.devinci.lib.util.Preconditions.checkNotNull;

@Module public class ActivityModule {

  private final Activity activity;

  public ActivityModule(@NonNull Activity activity) {
    this.activity = checkNotNull(activity);
  }

  @Provides Activity provideActivity() {
    return activity;
  }
}
