package com.devinci.lib.preference;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.devinci.lib.util.Preconditions.checkNotNull;

abstract class BasePreference<T> {

  private final boolean commit;
  final T defaultValue;
  final String key;
  final SharedPreferences sharedPreferences;

  public BasePreference(@NonNull SharedPreferences sharedPreferences, @NonNull String key,
      @Nullable T defaultValue, boolean commit) {
    this.sharedPreferences = checkNotNull(sharedPreferences);
    this.key = checkNotNull(key);
    this.commit = commit;
    this.defaultValue = defaultValue;
  }

  public boolean isSet() {
    return sharedPreferences.contains(key);
  }

  @SuppressLint("CommitPrefEdits") public void set(T value) {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    putValue(value, editor);
    if (commit) {
      editor.commit();
    } else {
      editor.apply();
    }
  }

  @SuppressLint("CommitPrefEdits") public void delete() {
    SharedPreferences.Editor editor = sharedPreferences.edit().remove(key);
    if (commit) {
      editor.commit();
    } else {
      editor.apply();
    }
  }

  abstract void putValue(@Nullable T value, @NonNull SharedPreferences.Editor editor);

  public abstract T get();
}
