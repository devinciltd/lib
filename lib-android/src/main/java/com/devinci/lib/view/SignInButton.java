package com.devinci.lib.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.devinci.lib.R;

import static com.devinci.lib.util.Preconditions.checkState;

public class SignInButton extends FrameLayout {

  private int height;
  private TextView buttonText;

  public SignInButton(Context context) {
    this(context, null);
  }

  public SignInButton(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public SignInButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    inflate(context, R.layout.lib_button_sign_in, this);
    buttonText = (TextView) findViewById(R.id.lib_button_sign_in_text);

    if (isInEditMode()) {
      return;
    }

    setForeground(
        ContextCompat.getDrawable(context, R.drawable.lib_button_sign_in_pressed_selector));
    setBackgroundResource(R.drawable.lib_button_sign_in);

    if (attrs != null) {
      int color;
      Drawable icon;
      String text;
      ColorStateList textColor;
      int textSize;
      TypedArray typedArray =
          context.obtainStyledAttributes(attrs, R.styleable.lib_SignInButton, defStyleAttr,
              R.style.lib_Base_Widget_SignInButton);

      try {
        color = typedArray.getColor(R.styleable.lib_SignInButton_lib_signInColor, 0);
        text = typedArray.getString(R.styleable.lib_SignInButton_lib_signInText);
        textSize =
            typedArray.getDimensionPixelSize(R.styleable.lib_SignInButton_lib_signInTextSize, 0);
        textColor = typedArray.getColorStateList(R.styleable.lib_SignInButton_lib_signInTextColor);
        icon = typedArray.getDrawable(R.styleable.lib_SignInButton_lib_signInIcon);
        height = typedArray.getDimensionPixelSize(R.styleable.lib_SignInButton_lib_signInHeight, 0);
      } finally {
        typedArray.recycle();
      }

      checkState(textSize > 0, "Default text size must be defined in style");
      checkState(textColor != null, "Default text color must be defined in style");
      checkState(height > 0, "Default height must be defined in style");

      setTextColorInternal(textColor.getDefaultColor());
      setTextSizeInternal(textSize);
      if (text != null) {
        setTextInternal(text);
      }
      if (color != 0) {
        setColorInternal(color);
      }
      if (icon != null) {
        setIconInternal(icon);
      }
    }
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, height);
  }

  public void setText(@StringRes int text) {
    setTextInternal(getResources().getString(text));
  }

  private void setTextInternal(String text) {
    buttonText.setText(text);
  }

  @VisibleForTesting String getText() {
    return buttonText.getText().toString();
  }

  public void setTextSize(@DimenRes int textSize) {
    setTextSizeInternal(getResources().getDimensionPixelSize(textSize));
  }

  private void setTextSizeInternal(int textSize) {
    buttonText.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
  }

  public void setColor(@ColorRes int color) {
    setColorInternal(ContextCompat.getColor(getContext(), color));
  }

  private void setColorInternal(@ColorInt int color) {
    getBackground().mutate().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
  }

  public void setIcon(@DrawableRes int icon) {
    setIconInternal(ContextCompat.getDrawable(getContext(), icon));
  }

  private void setIconInternal(Drawable icon) {
    ((ImageView) findViewById(R.id.lib_button_sign_in_icon)).setImageDrawable(icon);
  }

  @VisibleForTesting Drawable getIcon() {
    return ((ImageView) findViewById(R.id.lib_button_sign_in_icon)).getDrawable();
  }

  public void setTextColor(@ColorRes int textColor) {
    setTextColorInternal(ContextCompat.getColor(getContext(), textColor));
  }

  private void setTextColorInternal(@ColorInt int textColor) {
    buttonText.setTextColor(textColor);
  }

  @VisibleForTesting int getTextColor() {
    return buttonText.getCurrentTextColor();
  }
}
