package com.example.carlosottoboni.bookcase;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.core.internal.deps.guava.base.Preconditions;
import android.support.test.espresso.matcher.CursorMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.example.carlosottoboni.bookcase.books.BooksActivity;
import com.example.carlosottoboni.bookcase.data.Book;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class BooksListTest {
   private Matcher<View> withItemText(final String itemText) {
       Preconditions.checkArgument(!TextUtils.isEmpty(itemText), "title cannot be null or empty");
       return new TypeSafeMatcher<View>() {
           @Override
           protected boolean matchesSafely(View item) {
               return Matchers.allOf(
                   ViewMatchers.isDescendantOfA(ViewMatchers.isAssignableFrom(RecyclerView.class)),
                   ViewMatchers.withText(itemText)).matches(item);
           }

           @Override
           public void describeTo(Description description) {
               description.appendText("is isDecendantOA RV with text " + itemText);
           }
       };
   }

   @Rule
    public ActivityTestRule<BooksActivity> mBooksActivityTestRule = new ActivityTestRule<BooksActivity>
       (BooksActivity.class);

   @Test
    public void clickOnABookItem_OpenBookDetailUI() throws Exception {

       Thread.sleep(5000);

       Espresso.onView(ViewMatchers.withId(R.id.list)).perform(RecyclerViewActions.actionOnItemAtPosition
           (0, ViewActions.click()));

       Espresso.onView(ViewMatchers.withId(R.id.textContainer)).check(ViewAssertions.matches(ViewMatchers
           .isDisplayed()));
   }
}
