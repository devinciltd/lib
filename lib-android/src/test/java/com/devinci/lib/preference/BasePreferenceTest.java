package com.devinci.lib.preference;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowPreferenceManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(RobolectricGradleTestRunner.class) public class BasePreferenceTest {

  @Mock private SharedPreferences mockSharedPreferences;
  @Mock private SharedPreferences.Editor mockEditor;
  private SharedPreferences sharedPreferences;

  @SuppressLint("CommitPrefEdits") @Before public void setUp() {
    sharedPreferences =
        ShadowPreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.application);
    initMocks(this);
    given(mockSharedPreferences.edit()).willReturn(mockEditor);
    given(mockEditor.remove(anyString())).willReturn(mockEditor);
  }

  @SuppressWarnings({ "ThrowableResultOfMethodCallIgnored", "ConstantConditions" }) @Test
  public void shouldThrowOnNullSharedPreferences() {
    Throwable throwable = catchThrowable(() -> BooleanPreference.newInstance(null, "key", true));

    assertThat(throwable).isExactlyInstanceOf(NullPointerException.class).hasNoCause();
  }

  @SuppressWarnings({ "ThrowableResultOfMethodCallIgnored", "ConstantConditions" }) @Test
  public void shouldThrowOnNullKey() {
    Throwable throwable =
        catchThrowable(() -> BooleanPreference.newInstance(sharedPreferences, null, true));

    assertThat(throwable).isExactlyInstanceOf(NullPointerException.class).hasNoCause();
  }

  @Test public void shouldNotBeSet() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(sharedPreferences, "key", true);

    assertThat(booleanPreference.isSet()).isFalse();
  }

  @Test public void shouldNotBeSetWhenDeleted() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(sharedPreferences, "key", true);
    booleanPreference.set(true);

    booleanPreference.delete();

    assertThat(booleanPreference.isSet()).isFalse();
  }

  @SuppressLint("CommitPrefEdits") @Test public void shouldCommitDeleteOperation() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(mockSharedPreferences, "key", false, true);

    booleanPreference.delete();

    verify(mockEditor).remove("key");
    verify(mockEditor).commit();
  }

  @SuppressLint("CommitPrefEdits") @Test public void shouldApplyDeleteOperation() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(mockSharedPreferences, "key", false, false);

    booleanPreference.delete();

    verify(mockEditor).remove("key");
    verify(mockEditor).apply();
  }

  @SuppressLint("CommitPrefEdits") @Test public void shouldApplyDeleteOperationByDefault() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(mockSharedPreferences, "key", false);

    booleanPreference.delete();

    verify(mockEditor).remove("key");
    verify(mockEditor).apply();
  }
}
