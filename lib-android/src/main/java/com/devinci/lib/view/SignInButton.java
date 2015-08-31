package com.devinci.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.devinci.lib.R;

public class SignInButton extends FrameLayout {

  private int height;
  private int color;
  private String text;
  private Drawable icon;

  public SignInButton(Context context) {
    this(context, null);
  }

  public SignInButton(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public SignInButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    inflate(context, R.layout.lib_button_sign_in, this);
    if (!isInEditMode()) {
      setForeground(ViewUtils.getDrawable(context, R.drawable.lib_button_sign_in_pressed_selector));
      setBackgroundResource(R.drawable.lib_button_sign_in);
      height = getResources().getDimensionPixelSize(R.dimen.lib_button_sign_in_height);

      if (attrs != null) {
        obtainStyledAttributes(context, attrs);
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
  }

  private void obtainStyledAttributes(Context context, AttributeSet attrs) {
    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.lib_SignInButton);
    try {
      color = typedArray.getColor(R.styleable.lib_SignInButton_lib_signInColor, 0);
      text = typedArray.getString(R.styleable.lib_SignInButton_lib_signInText);
      icon = typedArray.getDrawable(R.styleable.lib_SignInButton_lib_signInIcon);
    } finally {
      typedArray.recycle();
    }
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, height);
  }

  public void setText(@StringRes int text) {
    setTextInternal(getResources().getString(text));
  }

  private void setTextInternal(String text) {
    ((TextView) findViewById(R.id.lib_button_sign_in_text)).setText(text);
  }

  private void setColor(@ColorRes int color) {
    setColorInternal(ViewUtils.getColor(getContext(), color));
  }

  private void setColorInternal(@ColorInt int color) {
    getBackground().mutate().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
  }

  private void setIcon(@DrawableRes int icon) {
    setIconInternal(ViewUtils.getDrawable(getContext(), icon));
  }

  private void setIconInternal(Drawable icon) {
    ((ImageView) findViewById(R.id.lib_button_sign_in_icon)).setImageDrawable(icon);
  }
}
