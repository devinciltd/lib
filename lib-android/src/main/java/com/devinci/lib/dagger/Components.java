package com.devinci.lib.dagger;

import android.content.Context;
import android.support.annotation.NonNull;

import static com.devinci.lib.util.Preconditions.checkNotNull;

public final class Components {

  @NonNull @SuppressWarnings("unchecked")
  public static <T> T fromContext(@NonNull Context context) {
    checkNotNull(context);
    return ((HasComponent<T>) context.getApplicationContext()).getComponent();
  }
}
