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

@RunWith(RobolectricGradleTestRunner.class) public class StringPreferenceTest {

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

  @Test public void shouldReturnDefaultNullValue() {
    StringPreference stringPreference =
        StringPreference.newInstance(mockSharedPreferences, "key", null);

    String value = stringPreference.get();

    assertThat(value).isNull();
  }

  @SuppressLint("CommitPrefEdits") @Test public void shouldApplySetOperationByDefault() {
    StringPreference stringPreference =
        StringPreference.newInstance(mockSharedPreferences, "key", "default_value");
    String newValue = "new_value";

    stringPreference.set(newValue);

    verify(mockEditor).putString("key", newValue);
    verify(mockEditor).apply();
  }

  @SuppressLint("CommitPrefEdits") @Test public void shouldApplySetOperation() {
    StringPreference stringPreference =
        StringPreference.newInstance(mockSharedPreferences, "key", "default_value", false);
    String newValue = "new_value";

    stringPreference.set(newValue);

    verify(mockEditor).putString("key", newValue);
    verify(mockEditor).apply();
  }

  @SuppressLint("CommitPrefEdits") @Test public void shouldCommitSetOperation() {
    String newValue = "new_value";
    StringPreference stringPreference =
        StringPreference.newInstance(mockSharedPreferences, "key", "default_value", true);

    stringPreference.set(newValue);

    verify(mockEditor).putString("key", newValue);
    verify(mockEditor).commit();
  }

  @Test public void shouldReturnStringAsDefaultValue() {
    String defaultValue = "default_value";
    StringPreference stringPreference =
        StringPreference.newInstance(sharedPreferences, "key", defaultValue);

    assertThat(stringPreference.get()).isEqualTo(defaultValue);
  }

  @Test public void shouldBeSetToNewValue() {
    String newValue = "new_value";
    StringPreference stringPreference =
        StringPreference.newInstance(sharedPreferences, "key", "old_value");

    stringPreference.set(newValue);

    assertThat(stringPreference.isSet()).isTrue();
    assertThat(stringPreference.get()).isEqualTo(newValue);
  }

  @Test public void shouldNotBeSetWhenNewValueIsNull() {
    StringPreference stringPreference =
        StringPreference.newInstance(sharedPreferences, "key", null);
    stringPreference.set("old_value");

    stringPreference.set(null);

    assertThat(stringPreference.isSet()).isFalse();
    assertThat(stringPreference.get()).isNull();
  }
}
