package com.devinci.lib.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Shared preference with {@link String} value.
 */
public class StringPreference extends BasePreference<String> {

  public StringPreference(@NonNull SharedPreferences sharedPreferences, @NonNull String key,
      @Nullable String defaultValue, boolean commit) {
    super(sharedPreferences, key, defaultValue, commit);
  }

  /**
   * Creates a new instance that uses {@link Editor#apply()} to save changes.
   */
  public static StringPreference newInstance(@NonNull SharedPreferences preferences,
      @NonNull String key, @Nullable String defaultValue) {
    return newInstance(preferences, key, defaultValue, false);
  }

  public static StringPreference newInstance(@NonNull SharedPreferences preferences,
      @NonNull String key, @Nullable String defaultValue, boolean commit) {
    return new StringPreference(preferences, key, defaultValue, commit);
  }

  @Nullable public String get() {
    return sharedPreferences.getString(key, defaultValue);
  }

  @Override void putValue(@Nullable String value, @NonNull Editor editor) {
    // Workaround for bug https://code.google.com/p/android/issues/detail?id=64563
    if (value == null) {
      editor.remove(key);
    } else {
      editor.putString(key, value);
    }
  }
}
