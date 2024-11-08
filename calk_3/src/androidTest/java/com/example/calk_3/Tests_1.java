package com.example.calk_3;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import org.junit.Test;
import org.junit.Rule;
import android.support.test.rule.ActivityTestRule;

public class Tests_1 {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickButtonHome(){
        onView(withId(R.id.Five)).perform(click()).check(matches(isDisplayed()));
    }
}
