package com.devinci.lib.robolectric;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.robolectric.res.Attribute;
import org.robolectric.res.ResName;
import org.robolectric.res.ResourceLoader;
import org.robolectric.shadows.RoboAttributeSet;

import static org.robolectric.Shadows.shadowOf;

public class AttributeSetBuilder {
  private final String packageName;
  private final ResourceLoader resourceLoader;
  private final List<Attribute> attributes;

  @Nonnull public static AttributeSetBuilder from(@Nonnull Context context) {
    return new AttributeSetBuilder(context);
  }

  private AttributeSetBuilder(@Nonnull Context context) {
    this.packageName = context.getPackageName();
    this.resourceLoader = shadowOf(context.getResources()).getResourceLoader();
    this.attributes = new ArrayList<>();
  }

  public AttributeSetBuilder addAttribute(@Nonnull String name, @Nonnull String value) {
    attributes.add(new Attribute(new ResName(packageName, "attr", name), value, packageName));
    return this;
  }

  @Nonnull public AttributeSet build() {
    return new RoboAttributeSet(attributes, resourceLoader);
  }
}
