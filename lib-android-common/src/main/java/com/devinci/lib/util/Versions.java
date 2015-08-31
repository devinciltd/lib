package com.devinci.lib.util;

import android.os.Build;

/**
 * Utility methods to check Android version.
 */
public enum Versions {
  ;

  /**
   * Checks if the device is at least Marshmallow 6.0 API23.
   *
   * @return true if the device is API >= 23, false otherwise
   */
  public static boolean isMarshmallow() {
    //TODO t.rozbicki 31.08.15 replace with Marshmallow version code
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
  }

  /**
   * Checks if the device is at least Lollipop 5.1 API22.
   *
   * @return true if the device is API >= 22, false otherwise
   */
  public static boolean isLollipopMR1() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1;
  }

  /**
   * Checks if the device is at least Lollipop 5.0 API21.
   *
   * @return true if the device is API >= 21, false otherwise
   */
  public static boolean isLollipop() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
  }
}
