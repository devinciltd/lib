package com.devinci.lib.crash;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

import static com.devinci.lib.util.Preconditions.checkNotNull;

/**
 * Crash reporting with Crashlytics.
 * <p>
 * The extra data is sent with the crash to Crashlytics and you can view it in the issue details
 * screen. Please note, Crashlytics limits you to 64 key/values pairs though might allow more if
 * you contact support.
 * <p>
 * Extra setup required:
 * <p>
 * - apply plugin to Android app module
 * <p>
 * {@code apply plugin: 'io.fabric'}
 * <p>
 * - add plugin to the classpath
 * <pre>
 * buildscript {
 *  repositories {
 *    maven { url 'https://maven.fabric.io/public' }
 *  }
 *  dependencies {
 *    classpath 'io.fabric.tools:gradle:1.19.2'
 *  }
 * }
 * </pre>
 */
public class CrashlyticsCrashReporting implements CrashReporting {

  private boolean initialized;

  @Override public void initialize(@NonNull Context context) {
    if (initialized) {
      throw new IllegalStateException("Crashlytics already initialized");
    }
    checkNotNull(context);
    Fabric.with(context, new Crashlytics());
    initialized = true;
  }

  @Override public void sendException(@NonNull Throwable throwable) {
    Crashlytics.getInstance().core.logException(throwable);
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, boolean extra) {
    Crashlytics.getInstance().core.setBool(key, extra);
    return this;
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, double extra) {
    Crashlytics.getInstance().core.setDouble(key, extra);
    return this;
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, float extra) {
    Crashlytics.getInstance().core.setFloat(key, extra);
    return this;
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, int extra) {
    Crashlytics.getInstance().core.setInt(key, extra);
    return this;
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, long extra) {
    Crashlytics.getInstance().core.setLong(key, extra);
    return this;
  }

  @NonNull @Override public CrashReporting addExtra(@NonNull String key, @Nullable String extra) {
    Crashlytics.getInstance().core.setString(key, extra);
    return this;
  }

  @NonNull @Override public CrashReporting setUser(@Nullable String user) {
    Crashlytics.getInstance().core.setUserIdentifier(user);
    return this;
  }
}
