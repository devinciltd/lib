package com.devinci.lib.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.devinci.lib.crash.CrashReporting;
import com.devinci.lib.sample.app.App;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

  @Inject CrashReporting crashReporting;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ((App) getApplication()).getBaseComponent().inject(this);
  }
}
