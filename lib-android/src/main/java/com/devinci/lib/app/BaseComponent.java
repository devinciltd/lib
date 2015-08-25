package com.devinci.lib.app;

import com.devinci.lib.crash.CrashReporting;
import com.devinci.lib.dagger.module.FakeCrashReportingModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Base dagger component with global dependencies.
 * <p>
 * Components extending {@link BaseComponent} should define all of the modules defined in base
 * component using {@link Component#modules()}.
 */
@Singleton @Component(modules = {
    FakeCrashReportingModule.class
}) public interface BaseComponent {

  CrashReporting crashReporting();
}
