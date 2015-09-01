package com.devinci.lib.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import com.devinci.lib.BuildConfig;
import com.devinci.lib.R;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.res.Attribute;
import org.robolectric.res.ResourceLoader;
import org.robolectric.shadows.RoboAttributeSet;

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
    ResourceLoader resourceLoader = shadowOf(context.getResources()).getResourceLoader();
    String expectedTitle = context.getString(R.string.lib_sign_in_with_google);
    List<Attribute> attributes = new ArrayList<>(1);
    attributes.add(new Attribute(BuildConfig.APPLICATION_ID + ":attr/lib_signInText",
        "@string/lib_sign_in_with_google", BuildConfig.APPLICATION_ID));
    AttributeSet attributeSet = new RoboAttributeSet(attributes, resourceLoader);

    SignInButton signInButton = new SignInButton(context, attributeSet);

    assertThat(signInButton.getText()).isEqualTo(expectedTitle);
  }

  @Test public void shouldObtainIconFromAttrs() {
    ResourceLoader resourceLoader = shadowOf(context.getResources()).getResourceLoader();
    List<Attribute> attributes = new ArrayList<>(1);
    attributes.add(new Attribute(BuildConfig.APPLICATION_ID + ":attr/lib_signInIcon",
        "@drawable/lib_ic_sign_in_google", BuildConfig.APPLICATION_ID));
    AttributeSet attributeSet = new RoboAttributeSet(attributes, resourceLoader);

    SignInButton signInButton = new SignInButton(context, attributeSet);

    assertThat(shadowOf(signInButton.getIcon()).getCreatedFromResId()).isEqualTo(
        R.drawable.lib_ic_sign_in_google);
  }

  @Test public void shouldObtainTextColorFromAttrs() {
    ResourceLoader resourceLoader = shadowOf(context.getResources()).getResourceLoader();
    int expectedTextColor = ContextCompat.getColor(context, R.color.lib_black);
    List<Attribute> attributes = new ArrayList<>(1);
    attributes.add(
        new Attribute(BuildConfig.APPLICATION_ID + ":attr/lib_signInTextColor", "@color/lib_black",
            BuildConfig.APPLICATION_ID));
    AttributeSet attributeSet = new RoboAttributeSet(attributes, resourceLoader);

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
