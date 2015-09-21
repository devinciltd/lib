package com.devinci.lib.robolectric;

import android.annotation.NonNull;
import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.robolectric.res.Attribute;
import org.robolectric.res.ResName;
import org.robolectric.res.ResourceLoader;
import org.robolectric.shadows.RoboAttributeSet;

import static org.robolectric.Shadows.shadowOf;

public class AttributeSetBuilder {
  private final String packageName;
  private final ResourceLoader resourceLoader;
  private final List<Attribute> attributes;

  @NonNull public static AttributeSetBuilder from(@NonNull Context context) {
    return new AttributeSetBuilder(context);
  }

  private AttributeSetBuilder(@NonNull Context context) {
    this.packageName = context.getPackageName();
    this.resourceLoader = shadowOf(context.getResources()).getResourceLoader();
    this.attributes = new ArrayList<>();
  }

  public AttributeSetBuilder addAttribute(@NonNull String name, @NonNull String value) {
    attributes.add(new Attribute(new ResName(packageName, "attr", name), value, packageName));
    return this;
  }

  @NonNull public AttributeSet build() {
    return new RoboAttributeSet(attributes, resourceLoader);
  }
}
