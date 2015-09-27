package com.devinci.lib.dagger;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

import static com.devinci.lib.util.Preconditions.checkNotNull;

@Module public class SharedPreferencesModule {

  @Provides @Singleton SharedPreferences provideSharedPreferences(@NonNull Application app) {
    return PreferenceManager.getDefaultSharedPreferences(checkNotNull(app));
  }
}
