package com.samsung.hyunjaee.kim.boostcamp.main;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.samsung.hyunjaee.kim.boostcamp.R;
import com.squareup.rx2.idler.Rx2Idler;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.reactivex.plugins.RxJavaPlugins;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);


    @Before
    public void setup() {
        RxJavaPlugins.setInitIoSchedulerHandler(Rx2Idler.create("RxJava 2.x IO Scheduler"));
    }

    @After
    public void cleanUp() {
    }


    @Test
    public void validateEditText() {
        onView(withId(R.id.search_edit_text))
                .perform(typeText("Joker"), closeSoftKeyboard())
                .check(matches(withText("Joker")));
    }


    /**
     * https://medium.com/androiddevelopers/adapterviews-and-espresso-f4172aa853cf
     */
    @Test
    public void clickItem() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.movie_list))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition(0, click())
                );
        onView(withText("Test"))
                .check(matches(isDisplayed()));
    }


}