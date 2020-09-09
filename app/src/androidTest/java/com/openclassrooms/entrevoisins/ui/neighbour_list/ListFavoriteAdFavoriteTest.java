package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ListFavoriteAdFavoriteTest {

    //attributs
    private ListNeighbourActivity mActivity;
    private NeighbourApiService mService;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        //recuperation de l' activite
        mActivity = mActivityTestRule.getActivity();
        assertThat(mActivity, notNullValue());

        //recuperation de la liste de Neighbour
        mService = DI.getNeighbourApiService();
        assertThat(mService, notNullValue());
    }

    @Test
    public void ListFavoriteAdFavoriteTest() {
        //Click sur un element de la liste
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(actionOnItemAtPosition(0, click()));
        //Click sur le bouton add favorite
        onView(withId(R.id.neighbours_details)).check(matches(isDisplayed()));
        onView(withId(R.id.add_neighbour_favorites)).check(matches(isDisplayed()));
        onView(withId(R.id.add_neighbour_favorites)).perform(click());
        //verification que l element a bien ete ajoute aux favories
        assertThat(mService.getFavorites(), notNullValue());
        onView(withId(R.id.details_header_name)).check(matches(withText(mService.getFavorites().get(0).getName())));

    }

}
