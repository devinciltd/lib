package com.devinci.lib.dagger.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class SharedPreferencesModule {

  @Provides @Singleton SharedPreferences provideSharedPreferences(Application app) {
    return PreferenceManager.getDefaultSharedPreferences(app);
  }
}
