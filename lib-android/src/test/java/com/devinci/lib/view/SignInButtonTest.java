package com.devinci.lib.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import com.devinci.lib.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;

import static com.devinci.lib.AttributeSetUtils.createAttributeSet;
import static com.devinci.lib.AttributeSetUtils.withAttribute;
import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class) public class SignInButtonTest {

  private Context context;

  @Before public void setUp() {
    context = RuntimeEnvironment.application;
  }

  @Test public void shouldCreateSignInButtonFromContext() {
    // when
    SignInButton signInButton = new SignInButton(context);

    // then
    assertThat(signInButton.getTextColor()).isNotEqualTo(0);
    assertThat(signInButton.getText()).isEmpty();
    assertThat(signInButton.getIcon()).isNull();
    assertThat(shadowOf(signInButton.getForeground()).getCreatedFromResId()).isEqualTo(
        R.drawable.lib_button_sign_in_pressed_selector);
    assertThat(shadowOf(signInButton.getBackground()).getCreatedFromResId()).isEqualTo(
        R.drawable.lib_button_sign_in);
  }

  @Test public void shouldObtainTextFromAttrs() {
    String expectedTitle = context.getString(R.string.lib_sign_in_with_google);
    AttributeSet attributeSet = createAttributeSet(context,
        withAttribute("lib_signInText", "@string/lib_sign_in_with_google"));

    SignInButton signInButton = new SignInButton(context, attributeSet);

    assertThat(signInButton.getText()).isEqualTo(expectedTitle);
  }

  @Test public void shouldObtainIconFromAttrs() {
    AttributeSet attributeSet = createAttributeSet(context,
        withAttribute("lib_signInIcon", "@drawable/lib_ic_sign_in_google"));

    SignInButton signInButton = new SignInButton(context, attributeSet);

    assertThat(shadowOf(signInButton.getIcon()).getCreatedFromResId()).isEqualTo(
        R.drawable.lib_ic_sign_in_google);
  }

  @Test public void shouldObtainTextColorFromAttrs() {
    int expectedTextColor = ContextCompat.getColor(context, R.color.lib_black);
    AttributeSet attributeSet =
        createAttributeSet(context, withAttribute("lib_signInTextColor", "@color/lib_black"));

    SignInButton signInButton = new SignInButton(context, attributeSet);

    assertThat(signInButton.getTextColor()).isEqualTo(expectedTextColor);
  }

  @Test public void shouldSetIcon() {
    SignInButton signInButton = new SignInButton(context);

    signInButton.setIcon(android.R.drawable.ic_btn_speak_now);

    assertThat(shadowOf(signInButton.getIcon()).getCreatedFromResId()).isEqualTo(
        android.R.drawable.ic_btn_speak_now);
  }

  @Test public void shouldSetText() {
    SignInButton signInButton = new SignInButton(context);
    String expectedText = context.getString(android.R.string.ok);

    signInButton.setText(android.R.string.ok);

    assertThat(signInButton.getText()).isEqualTo(expectedText);
  }

  @Test public void shouldSetTextColor() {
    SignInButton signInButton = new SignInButton(context);
    int expectedColor = ContextCompat.getColor(context, android.R.color.darker_gray);

    signInButton.setTextColor(android.R.color.darker_gray);

    assertThat(signInButton.getTextColor()).isEqualTo(expectedColor);
  }
}
