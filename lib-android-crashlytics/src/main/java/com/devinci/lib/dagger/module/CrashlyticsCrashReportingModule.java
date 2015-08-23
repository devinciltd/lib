package com.devinci.lib.dagger.module;

import com.crashlytics.android.Crashlytics;
import com.devinci.lib.crash.CrashReporting;
import com.devinci.lib.crash.CrashlyticsCrashReporting;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Module with {@link Crashlytics} crash reporting dependency.
 */
@Module public class CrashlyticsCrashReportingModule {

  @Provides @Singleton CrashReporting provideCrashReporting() {
    return new CrashlyticsCrashReporting();
  }
}
