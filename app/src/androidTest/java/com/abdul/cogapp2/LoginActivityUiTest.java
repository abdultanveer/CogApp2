package com.abdul.cogapp2;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest   // tests which require more time to run
@RunWith(AndroidJUnit4.class)
public class LoginActivityUiTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testSubmitButtonClick() {
        onView(withId(R.id.etEmail))
                .perform(typeText("abdul ansari"), closeSoftKeyboard());
        onView(withId(R.id.btnSubmit)).perform(click());

        onView(withId(R.id.tvResult))
                .check(matches(withText("abdul ansari")));
    }
}
