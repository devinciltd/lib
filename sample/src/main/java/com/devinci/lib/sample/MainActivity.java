package com.devinci.lib.sample;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.devinci.lib.activity.BaseActivity;

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.lib_toolbar);
    setSupportActionBar(toolbar);

    // Crash reporting should be injected (crashReporting != null)
    crashReporting.sendException(new RuntimeException());
  }
}
