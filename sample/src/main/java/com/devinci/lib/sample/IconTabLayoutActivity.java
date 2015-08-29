package com.devinci.lib.sample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import static com.devinci.lib.view.ToolbarUtils.setupPageSelectionNotifications;

public class IconTabLayoutActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_icontablayout);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    TabLayout tabLayout = (TabLayout) findViewById(R.id.icon_tab_layout);
    ViewPager viewPager = (ViewPager) findViewById(R.id.layout_view_pager);
    tabLayout.setupWithViewPager(viewPager);

    setupPageSelectionNotifications(toolbar, viewPager);
  }
}
