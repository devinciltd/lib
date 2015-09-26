package com.devinci.lib.robolectric;

import org.robolectric.shadows.ShadowLog;

import static org.assertj.core.api.Assertions.assertThat;

public class Assertions {

  public static void assertLogged(int type, String tag, String msg, Throwable throwable) {
    ShadowLog.LogItem lastLog = ShadowLog.getLogs().get(0);
    assertThat(type).isEqualTo(lastLog.type);
    assertThat(msg).isEqualTo(lastLog.msg);
    assertThat(tag).isEqualTo(lastLog.tag);
    assertThat(throwable).isEqualTo(lastLog.throwable);
  }
}
