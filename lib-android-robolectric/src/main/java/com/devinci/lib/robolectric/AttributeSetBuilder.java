package com.devinci.lib.robolectric;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.robolectric.res.Attribute;
import org.robolectric.res.ResName;
import org.robolectric.shadows.RoboAttributeSet;

import static com.devinci.lib.util.Preconditions.checkNotNull;
import static org.robolectric.Shadows.shadowOf;

public class AttributeSetBuilder {
  private final Context context;
  private final List<Attribute> attributes;

  @Nonnull public static AttributeSetBuilder from(@Nonnull Context context) {
    return new AttributeSetBuilder(context);
  }

  private AttributeSetBuilder(@Nonnull Context context) {
    this.context = checkNotNull(context);
    this.attributes = new ArrayList<>();
  }

  public AttributeSetBuilder addAttribute(@Nonnull String name, @Nonnull String value) {
    attributes.add(new Attribute(new ResName(context.getPackageName(), "attr", name), value,
        context.getPackageName()));
    return this;
  }

  @Nonnull public AttributeSet build() {
    return new RoboAttributeSet(attributes, shadowOf(context.getResources()).getResourceLoader());
  }
}
