package com.example.nikbin.wuerfelapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<WuerfelActivity> activityTestRule = new ActivityTestRule<WuerfelActivity>(WuerfelActivity.class);

    @Test
    public void name() throws Exception {
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.nikbin.wuerfelapp", appContext.getPackageName());
    }


    @Test
    public void testOnClickRollDice() throws Exception {
        onView(withId(R.id.activity_main_textview_rolldice)).perform(click()).check(matches(isEnabled()));
        onView(withId(R.id.activity_main_textview_rolldice)).perform(click()).check(matches(not(isEnabled())));
    }
}
