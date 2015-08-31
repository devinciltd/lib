package com.devinci.lib.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import com.devinci.lib.util.Versions;

public enum ViewUtils {
  ;

  @TargetApi(Build.VERSION_CODES.LOLLIPOP) @SuppressWarnings("deprecation")
  public static Drawable getDrawable(Context context, @DrawableRes int drawable) {
    Resources resources = context.getResources();
    if (Versions.isLollipop()) {
      return resources.getDrawable(drawable, context.getTheme());
    } else {
      return resources.getDrawable(drawable);
    }
  }

  @TargetApi(Build.VERSION_CODES.M) @SuppressWarnings("deprecation")
  public static int getColor(Context context, @ColorRes int color) {
    Resources resources = context.getResources();
    if (Versions.isMarshmallow()) {
      return resources.getColor(color, context.getTheme());
    } else {
      return resources.getColor(color);
    }
  }
}
