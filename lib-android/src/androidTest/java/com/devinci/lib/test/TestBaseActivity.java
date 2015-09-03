package com.devinci.lib.test;

import android.os.Bundle;
import com.devinci.lib.R;
import com.devinci.lib.activity.BaseActivity;

public class TestBaseActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    setTheme(R.style.lib_Theme_Light_NoActionBar);
    super.onCreate(savedInstanceState);
  }
}
