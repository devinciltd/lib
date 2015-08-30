package com.devinci.lib.sample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class IconTabLayoutActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_icontablayout);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.icon_tab_layout);
    ViewPager viewPager = (ViewPager) findViewById(R.id.layout_view_pager);
    tabLayout.setupWithViewPager(viewPager);
  }
}
