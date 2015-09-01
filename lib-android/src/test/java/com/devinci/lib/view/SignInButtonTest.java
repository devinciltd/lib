package com.devinci.lib.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
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
  private Drawable expectedBackground;
  private Drawable expectedForeground;

  @Before public void setUp() throws Exception {
    context = RuntimeEnvironment.application;
    expectedBackground =
        ResourcesCompat.getDrawable(context.getResources(), R.drawable.lib_button_sign_in,
            context.getTheme());
    expectedForeground = ResourcesCompat.getDrawable(context.getResources(),
        R.drawable.lib_button_sign_in_pressed_selector, context.getTheme());
  }

  @Test public void shouldCreateSignInButtonFromContext() throws Exception {
    // when
    SignInButton signInButton = new SignInButton(context);

    // then
    assertThat(signInButton.getText()).isEmpty();
    assertThat(signInButton.getIcon()).isNull();
    assertThat(signInButton.getForeground()).isEqualTo(expectedForeground);
    assertThat(signInButton.getBackground()).isEqualTo(expectedBackground);
  }

  @Test public void shouldObtainTextFromAttrs() throws Exception {
    ResourceLoader resourceLoader = shadowOf(context.getResources()).getResourceLoader();
    String expectedTitle = context.getString(R.string.lib_sign_in_with_google);
    List<Attribute> attributes = new ArrayList<>(1);
    attributes.add(new Attribute(BuildConfig.APPLICATION_ID + ":attr/lib_signInText",
        "@string/lib_sign_in_with_google", BuildConfig.APPLICATION_ID));
    AttributeSet attributeSet = new RoboAttributeSet(attributes, resourceLoader);

    SignInButton signInButton = new SignInButton(context, attributeSet);

    assertThat(signInButton.getText()).isEqualTo(expectedTitle);
    assertThat(signInButton.getIcon()).isNull();
    assertThat(signInButton.getBackground()).isEqualTo(expectedBackground);
    assertThat(signInButton.getForeground()).isEqualTo(expectedForeground);
  }

  @Test public void shouldObtainIconFromAttrs() throws Exception {
    ResourceLoader resourceLoader = shadowOf(context.getResources()).getResourceLoader();
    Drawable expectedIcon =
        ResourcesCompat.getDrawable(context.getResources(), R.drawable.lib_ic_sign_in_google,
            context.getTheme());
    List<Attribute> attributes = new ArrayList<>(1);
    attributes.add(new Attribute(BuildConfig.APPLICATION_ID + ":attr/lib_signInIcon",
        "@drawable/lib_ic_sign_in_google", BuildConfig.APPLICATION_ID));
    AttributeSet attributeSet = new RoboAttributeSet(attributes, resourceLoader);

    SignInButton signInButton = new SignInButton(context, attributeSet);

    assertThat(signInButton.getIcon()).isEqualTo(expectedIcon);
    assertThat(signInButton.getText()).isEmpty();
    assertThat(signInButton.getBackground()).isEqualTo(expectedBackground);
    assertThat(signInButton.getForeground()).isEqualTo(expectedForeground);
  }

  @Test public void shouldSetIcon() throws Exception {
    SignInButton signInButton = new SignInButton(context);
    Drawable expectedIcon =
        ResourcesCompat.getDrawable(context.getResources(), R.drawable.lib_ic_sign_in_google,
            context.getTheme());

    signInButton.setIcon(R.drawable.lib_ic_sign_in_google);

    assertThat(signInButton.getIcon()).isEqualTo(expectedIcon);
  }

  @Test public void shouldSetText() throws Exception {
    SignInButton signInButton = new SignInButton(context);
    String expectedText = context.getString(R.string.lib_sign_in_with_google);

    signInButton.setText(R.string.lib_sign_in_with_google);

    assertThat(signInButton.getText()).isEqualTo(expectedText);
  }
}
