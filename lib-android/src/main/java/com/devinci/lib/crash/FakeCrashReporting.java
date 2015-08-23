package com.devinci.lib.crash;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Crash reporting implementation that does nothing.
 */
public enum FakeCrashReporting implements CrashReporting {
  INSTANCE;

  @Override public void initialize(@NonNull Context context) {
    // Does nothing intentionally
  }

  @Override public void sendException(@NonNull Throwable throwable) {
    // Does nothing intentionally
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, boolean extra) {
    return this;
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, double extra) {
    return this;
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, float extra) {
    return this;
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, int extra) {
    return this;
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, long extra) {
    return this;
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, @Nullable String extra) {
    return this;
  }

  @NonNull @Override public CrashReporting setUser(@Nullable String user) {
    return this;
  }
}
