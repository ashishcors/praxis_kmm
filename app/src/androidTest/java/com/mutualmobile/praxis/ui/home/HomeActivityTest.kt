package com.mutualmobile.praxis.ui.home

import android.os.SystemClock
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.Visibility.GONE
import androidx.test.espresso.matcher.ViewMatchers.Visibility.INVISIBLE
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mutualmobile.praxis.R.id
import com.mutualmobile.praxis.R.string
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

  @Test
  fun test_initialState() {
    ActivityScenario.launch(HomeActivity::class.java)

    onView(withId(id.random_jokes_button_coroutine))
        .check(matches(isDisplayed()))

    onView(withId(id.about_button))
        .check(matches(isDisplayed()))

    // Progress bar shouldn't be visible
    onView(withId(id.progressbar))
        .check(matches(withEffectiveVisibility(INVISIBLE)))
  }

  @Test
  fun test_getJokeFlow() {
    ActivityScenario.launch(HomeActivity::class.java)

    onView(withId(id.random_jokes_button_coroutine))
        .perform(click())

    // progress bar should be visible
    onView(withId(id.progressbar))
        .check(matches(isDisplayed()))

    // Wait for api to succeed
    SystemClock.sleep(3000)

    // assert joke screen is visible
    onView(withId(id.jokeTV))
        .check(matches(isDisplayed()))

    // go back
    pressBack()

    // home screen should be visible
    onView(withText(string.heading))
        .check(matches(isDisplayed()))

    // progress bar should be hidden
    onView(withId(id.progressbar))
        .check(matches(withEffectiveVisibility(GONE)))
  }

  @Test
  fun test_aboutInfoFlow() {
    ActivityScenario.launch(HomeActivity::class.java)

    onView(withId(id.about_button))
        .perform(click())

    // assert about text is visible
    onView(withText(string.about_text))
        .check(matches(isDisplayed()))
  }

}