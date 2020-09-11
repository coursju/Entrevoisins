package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
        import android.support.test.rule.ActivityTestRule;
        import android.support.test.runner.AndroidJUnit4;

        import com.openclassrooms.entrevoisins.R;
        import com.openclassrooms.entrevoisins.di.DI;
        import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

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
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
        import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
        import static org.hamcrest.core.IsNull.notNullValue;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NeighbourNewFonctionsTest {

    private ListNeighbourActivity mActivity;
    private NeighbourApiService mService;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityTestRule.getActivity();
        assertThat(mActivity, notNullValue());

        mService = DI.getNeighbourApiService();
        assertThat(mService, notNullValue());
    }

    @Test
    public void ListFavoriteAddFavoriteTest() {
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

    @Test
    public void ListFavoriteRemoveItemTest() {
        //navigation sur l onglet "favories"
        onView(withContentDescription("Favorites")).perform(click());
        //click sur effacer le seul favorie
        onView(ViewMatchers.withId(R.id.list_favorites)).check(withItemCount(1));
        onView(ViewMatchers.withId(R.id.list_favorites))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));
        //verification que la liste de favorie est vide
        onView(ViewMatchers.withId(R.id.list_favorites)).check(withItemCount(0));
    }

    @Test
    public void neighbourDetailPageAndNameTest() {
        //Click sur un element de la liste
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(actionOnItemAtPosition(0, click()));
        //verification que l' activite "details" est bien lancee
        onView(withId(R.id.neighbours_details)).check(matches(isDisplayed()));
        //verification que le nom affiche dans le textview est bien celui clique dans la liste
        onView(withId(R.id.details_header_name)).check(matches(withText(mService.getNeighbours().get(0).getName())));
    }
}
