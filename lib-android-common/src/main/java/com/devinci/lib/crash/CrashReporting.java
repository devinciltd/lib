package com.devinci.lib.crash;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Interface with generic methods for crash reporting.
 */
public interface CrashReporting {

  void initialize(@NonNull Context context);

  void sendException(@NonNull Throwable throwable);

  @NonNull CrashReporting addExtra(@NonNull String key, boolean extra);

  @NonNull CrashReporting addExtra(@NonNull String key, double extra);

  @NonNull CrashReporting addExtra(@NonNull String key, float extra);

  @NonNull CrashReporting addExtra(@NonNull String key, int extra);

  @NonNull CrashReporting addExtra(@NonNull String key, long extra);

  @NonNull CrashReporting addExtra(@NonNull String key, @Nullable String extra);

  @NonNull CrashReporting setUser(@Nullable String user);
}
