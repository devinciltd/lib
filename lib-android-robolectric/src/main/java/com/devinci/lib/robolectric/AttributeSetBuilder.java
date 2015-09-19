package com.devinci.lib.robolectric;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.robolectric.res.Attribute;
import org.robolectric.res.ResName;
import org.robolectric.shadows.RoboAttributeSet;

import static com.devinci.lib.util.Preconditions.checkNotNull;
import static org.robolectric.Shadows.shadowOf;

public class AttributeSetBuilder {
  private final Context context;
  private final List<Attribute> attributes;

  @NonNull public static AttributeSetBuilder from(@NonNull Context context) {
    return new AttributeSetBuilder(context);
  }

  private AttributeSetBuilder(@NonNull Context context) {
    this.context = checkNotNull(context);
    this.attributes = new ArrayList<>();
  }

  public AttributeSetBuilder addAttribute(@NonNull String name, @NonNull String value) {
    attributes.add(new Attribute(new ResName(context.getPackageName(), "attr", name), value,
        context.getPackageName()));
    return this;
  }

  @NonNull public AttributeSet build() {
    return new RoboAttributeSet(attributes, shadowOf(context.getResources()).getResourceLoader());
  }
}
