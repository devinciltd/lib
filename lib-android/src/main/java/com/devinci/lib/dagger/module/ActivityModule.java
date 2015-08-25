package com.devinci.lib.dagger.module;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.devinci.lib.dagger.PerActivity;
import dagger.Module;
import dagger.Provides;

import static com.devinci.lib.util.Preconditions.checkNotNull;

@Module public class ActivityModule {

  private final Activity activity;

  public static ActivityModule from(@NonNull Activity activity) {
    return new ActivityModule(activity);
  }

  private ActivityModule(Activity activity) {
    this.activity = checkNotNull(activity);
  }

  @Provides @PerActivity Activity activity() {
    return activity;
  }
}
