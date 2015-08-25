package com.devinci.lib.sample.app;

import com.devinci.lib.app.BaseComponent;
import com.devinci.lib.dagger.module.FakeCrashReportingModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Component with global dependencies.
 */
@Singleton @Component(modules = {
    FakeCrashReportingModule.class,
}) public interface AppComponent extends BaseComponent {
}
