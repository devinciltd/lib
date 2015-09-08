package com.devinci.lib;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import org.robolectric.res.Attribute;
import org.robolectric.shadows.RoboAttributeSet;

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.util.Preconditions.checkNotNull;
import static org.robolectric.Shadows.shadowOf;

public final class AttributeSetUtils {

  private AttributeSetUtils() {
  }

  @NonNull
  public static AttributeSet createAttributeSet(@NonNull Context context, Attribute... attributes) {
    return new RoboAttributeSet(newArrayList(attributes),
        shadowOf(context.getResources()).getResourceLoader());
  }

  @NonNull public static Attribute withAttribute(@NonNull String name, @NonNull String value) {
    checkNotNull(name);
    checkNotNull(value);
    return new Attribute(BuildConfig.APPLICATION_ID + ":attr/" + name, value,
        BuildConfig.APPLICATION_ID);
  }
}
