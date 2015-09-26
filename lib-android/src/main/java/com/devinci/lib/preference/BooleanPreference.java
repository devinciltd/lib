package com.devinci.lib.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;

import static com.devinci.lib.util.Preconditions.checkNotNull;

/**
 * Shared preference with {@code boolean} value.
 */
public class BooleanPreference extends BasePreference<Boolean> {

  private BooleanPreference(@NonNull SharedPreferences sharedPreferences, @NonNull String key,
      boolean defaultValue, boolean commit) {
    super(sharedPreferences, key, defaultValue, commit);
  }

  /**
   * Creates a new instance that uses {@link Editor#apply()} to save changes.
   */
  public static BooleanPreference newInstance(@NonNull SharedPreferences preferences,
      @NonNull String key, boolean defaultValue) {
    return newInstance(preferences, key, defaultValue, false);
  }

  public static BooleanPreference newInstance(@NonNull SharedPreferences preferences,
      @NonNull String key, boolean defaultValue, boolean commit) {
    return new BooleanPreference(preferences, key, defaultValue, commit);
  }

  @SuppressWarnings("NullableProblems") @Override void putValue(@NonNull Boolean value,
      @NonNull Editor editor) {
    editor.putBoolean(key, checkNotNull(value));
  }

  @SuppressWarnings("ConstantConditions") @Override public Boolean get() {
    return sharedPreferences.getBoolean(key, defaultValue);
  }
}
