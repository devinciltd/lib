package com.devinci.lib.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
    expectedBackground = ViewUtils.getDrawable(context, R.drawable.lib_button_sign_in);
    expectedForeground =
        ViewUtils.getDrawable(context, R.drawable.lib_button_sign_in_pressed_selector);
  }

  @Test public void shouldCreateSignInButtonFromContext() throws Exception {
    SignInButton signInButton = new SignInButton(context);

    assertThat(signInButton.getForeground()).isEqualTo(expectedForeground);
    assertThat(signInButton.getBackground()).isEqualTo(expectedBackground);
    assertThat(signInButton.getText()).isEmpty();
    assertThat(signInButton.getIcon()).isNull();
  }

  @Test public void shouldObtainStyledAttributesFromAttrs() throws Exception {
    ResourceLoader resourceLoader = shadowOf(context.getResources()).getResourceLoader();
    String expectedTitle = context.getString(R.string.lib_sign_in_with_google);
    Drawable expectedIcon = ViewUtils.getDrawable(context, R.drawable.lib_ic_sign_in_google);
    List<Attribute> attributes = new ArrayList<>(2);
    attributes.add(new Attribute(BuildConfig.APPLICATION_ID + ":attr/lib_signInText",
        "@string/lib_sign_in_with_google", BuildConfig.APPLICATION_ID));
    attributes.add(new Attribute(BuildConfig.APPLICATION_ID + ":attr/lib_signInIcon",
        "@drawable/lib_ic_sign_in_google", BuildConfig.APPLICATION_ID));
    AttributeSet attributeSet = new RoboAttributeSet(attributes, resourceLoader);

    SignInButton signInButton = new SignInButton(context, attributeSet);

    assertThat(signInButton.getForeground()).isEqualTo(expectedForeground);
    assertThat(signInButton.getBackground()).isEqualTo(expectedBackground);
    assertThat(signInButton.getText()).isEqualTo(expectedTitle);
    assertThat(signInButton.getIcon()).isEqualTo(expectedIcon);
  }

  @Test public void shouldSetIcon() throws Exception {
    SignInButton signInButton = new SignInButton(context);
    Drawable expectedIcon = ViewUtils.getDrawable(context, R.drawable.lib_ic_sign_in_google);

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
