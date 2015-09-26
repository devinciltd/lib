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
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(RobolectricGradleTestRunner.class) public class BooleanPreferenceTest {

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

  @SuppressLint("CommitPrefEdits") @Test public void shouldApplySetOperationByDefault() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(mockSharedPreferences, "key", true);

    booleanPreference.set(false);

    verify(mockEditor).putBoolean("key", false);
    verify(mockEditor).apply();
  }

  @SuppressLint("CommitPrefEdits") @Test public void shouldCommitSetOperation() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(mockSharedPreferences, "key", false, true);

    booleanPreference.set(true);

    verify(mockEditor).putBoolean("key", true);
    verify(mockEditor).commit();
  }

  @SuppressLint("CommitPrefEdits") @Test public void shouldApplySetOperation() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(mockSharedPreferences, "key", false, false);

    booleanPreference.set(true);

    verify(mockEditor).putBoolean("key", true);
    verify(mockEditor).apply();
  }

  @Test public void shouldReturnTrueAsDefaultValue() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(sharedPreferences, "key", true);

    assertThat(booleanPreference.get()).isTrue();
  }

  @Test public void shouldReturnFalseAsDefaultValue() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(sharedPreferences, "key", false);

    assertThat(booleanPreference.get()).isFalse();
  }

  @Test public void shouldBeSetToTrue() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(sharedPreferences, "key", true);

    booleanPreference.set(true);

    assertThat(booleanPreference.isSet()).isTrue();
    assertThat(booleanPreference.get()).isTrue();
  }

  @Test public void shouldBeSetToFalse() {
    BooleanPreference booleanPreference =
        BooleanPreference.newInstance(sharedPreferences, "key", true);

    booleanPreference.set(true);

    assertThat(booleanPreference.isSet()).isTrue();
    assertThat(booleanPreference.get()).isTrue();
  }
}
