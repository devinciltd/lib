package com.devinci.lib.robolectric.shadows.design;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;
import org.robolectric.annotation.Resetter;

import static com.devinci.lib.robolectric.shadows.design.Shadows.shadowOf;
import static org.robolectric.util.ReflectionHelpers.ClassParameter.from;
import static org.robolectric.util.ReflectionHelpers.callConstructor;
import static org.robolectric.util.ReflectionHelpers.callStaticMethod;

@Implements(Snackbar.class) public class ShadowSnackbar {
  private static List<Snackbar> shownSnackbars = new ArrayList<>();

  @RealObject private Snackbar snackbar;
  private String text;

  @Implementation
  public static Snackbar make(@NonNull View view, @NonNull CharSequence text, int duration) {
    Snackbar snackbar =
        callConstructor(Snackbar.class, from(ViewGroup.class, findSuitableParent(view)));
    snackbar.setText(text);
    snackbar.setDuration(duration);
    shownSnackbars.add(snackbar);

    shadowOf(snackbar).text = text.toString();

    return snackbar;
  }

  private static ViewGroup findSuitableParent(View view) {
    return callStaticMethod(Snackbar.class, "findSuitableParent", from(View.class, view));
  }

  @Resetter public static void reset() {
    shownSnackbars.clear();
  }

  public static int shownSnackbarCount() {
    return shownSnackbars.size();
  }

  @NonNull public static List<Snackbar> getShownSnackbars() {
    return new ArrayList<>(shownSnackbars);
  }

  @Nullable public static Snackbar getLatestSnackbar() {
    return !shownSnackbars.isEmpty() ? shownSnackbars.get(shownSnackbars.size() - 1) : null;
  }

  @Nullable public String getText() {
    return text;
  }
}
