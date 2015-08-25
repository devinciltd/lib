package com.devinci.lib.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import javax.inject.Singleton;

@Scope
@Singleton
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
