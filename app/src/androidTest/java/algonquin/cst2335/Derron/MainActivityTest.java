package algonquin.cst2335.Derron;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * testing if the password does not pass as a complex password
     */
    @Test
    public void mainActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText = onView( withId(R.id.editText) );
        appCompatEditText.perform(replaceText("12345"), closeSoftKeyboard());


        ViewInteraction materialButton = onView( withId(R.id.button) );
        materialButton.perform(click());


        ViewInteraction textView = onView( withId(R.id.textView) );
        textView.check(matches(withText("YOU SHALL NOT PASS!")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    /**
     * This test is testing to find if the password is missing an upper case
     */
    @Test
    public void testFindMissingUpperCase() {
        //Find the view
        ViewInteraction appCompatEditText = onView( withId(R.id.editText) );
        //Type in password123#$*
        appCompatEditText.perform(replaceText("password123#%*"), closeSoftKeyboard());

        //find the button
        ViewInteraction materialButton = onView( withId(R.id.button) );
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView( withId(R.id.textView) );
        //check the text
        textView.check(matches(withText("YOU SHALL NOT PASS!")));
    }

    /**
     * this test is to find if the password is missing a lower case
     */
    @Test
    public void testFindMissingLowerCase() {
        //Find the view
        ViewInteraction appCompatEditText = onView( withId(R.id.editText) );
        //Type in PASSWORD123#$*
        appCompatEditText.perform(replaceText("PASSWORD123#%*"), closeSoftKeyboard());

        //find the button
        ViewInteraction materialButton = onView( withId(R.id.button) );
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView( withId(R.id.textView) );
        //check the text
        textView.check(matches(withText("YOU SHALL NOT PASS!")));
    }

    /**
     * this test is to find if there is a missing number
     */
    @Test
    public void testFindMissingNumberCase() {
        //Find the view
        ViewInteraction appCompatEditText = onView( withId(R.id.editText) );
        //Type in password#$*
        appCompatEditText.perform(replaceText("password#%*"), closeSoftKeyboard());

        //find the button
        ViewInteraction materialButton = onView( withId(R.id.button) );
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView( withId(R.id.textView) );
        //check the text
        textView.check(matches(withText("YOU SHALL NOT PASS!")));
    }

    /**
     * this test is to find if there is a missing special character
     */
    @Test
    public void testFindMissingSpecialCharacterCase() {
        //Find the view
        ViewInteraction appCompatEditText = onView( withId(R.id.editText) );
        //Type in password123
        appCompatEditText.perform(replaceText("password123"), closeSoftKeyboard());

        //find the button
        ViewInteraction materialButton = onView( withId(R.id.button) );
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView( withId(R.id.textView) );
        //check the text
        textView.check(matches(withText("YOU SHALL NOT PASS!")));
    }
}
