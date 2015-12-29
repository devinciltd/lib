package com.devinci.lib.robolectric.shadows.design;

import android.support.design.widget.Snackbar;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;

import static com.devinci.lib.robolectric.shadows.design.Shadows.shadowOf;
import static org.assertj.android.design.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class) public class ShadowSnackbarTest {

  private FrameLayout view;
  private final String text = "Zośka";
  private final int duration = Snackbar.LENGTH_INDEFINITE;

  @Before public void setUp() {
    view = new FrameLayout(RuntimeEnvironment.application);
  }

  @Test public void shouldReturnNullIfNoSnackbarShown() {
    // expected
    assertThat(ShadowSnackbar.shownSnackbarCount()).isZero();

    // then
    assertThat(ShadowSnackbar.getLatestSnackbar()).isNull();
  }

  @Test public void shouldGetLatestSnackbarMadeWithText() {
    // expected
    assertThat(ShadowSnackbar.shownSnackbarCount()).isZero();

    // when
    Snackbar snackbar = Snackbar.make(view, text, duration);
    snackbar.show();

    // then
    Snackbar retrievedSnackbar = ShadowSnackbar.getLatestSnackbar();
    assertThat(retrievedSnackbar).isEqualTo(snackbar)
        .hasDuration(duration)
        .hasView(snackbar.getView());
    assertThat(shadowOf(retrievedSnackbar).getText()).isEqualTo(text);
  }

  @Test public void shouldGetLatestSnackbarMadeWithResId() {
    // given
    int resId = android.R.string.ok;
    String text = RuntimeEnvironment.application.getString(resId);

    // expected
    assertThat(ShadowSnackbar.shownSnackbarCount()).isZero();

    // when
    Snackbar snackbar = Snackbar.make(view, resId, duration);
    snackbar.show();

    // then
    Snackbar retrievedSnackbar = ShadowSnackbar.getLatestSnackbar();
    assertThat(retrievedSnackbar).isEqualTo(snackbar)
        .hasDuration(duration)
        .hasView(snackbar.getView());
    assertThat(shadowOf(retrievedSnackbar).getText()).isEqualTo(text);
  }

  @Test public void shouldGetShownSnackbars() {
    // given
    int snackbarCount = 10;
    List<Snackbar> expectedSnackbars = new ArrayList<>();

    // expected
    assertThat(ShadowSnackbar.shownSnackbarCount()).isZero();

    // when
    for (int i = 0; i < snackbarCount; ++i) {
      Snackbar snackbar = Snackbar.make(view, text, duration);
      snackbar.show();
      expectedSnackbars.add(snackbar);
    }

    // then
    assertThat(ShadowSnackbar.shownSnackbarCount()).isEqualTo(snackbarCount);
    assertThat(ShadowSnackbar.getShownSnackbars()).isEqualTo(expectedSnackbars);
  }
}
