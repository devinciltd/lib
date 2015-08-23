package com.devinci.lib.dagger.module;

import com.devinci.lib.crash.CrashReporting;
import com.devinci.lib.crash.FakeCrashReporting;
import dagger.Module;
import dagger.Provides;

/**
 * Module with fake crash reporting dependency which does nothing.
 */
@Module public final class FakeCrashReportingModule {

  @Provides CrashReporting provideCrashReporting() {
    return FakeCrashReporting.INSTANCE;
  }
}
