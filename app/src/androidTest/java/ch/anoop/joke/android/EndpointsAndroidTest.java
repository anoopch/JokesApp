package ch.anoop.joke.android;

import android.content.Context;
import android.test.AndroidTestCase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class EndpointsAndroidTest extends AndroidTestCase {

    Context mContext;

    @Override
    protected void setUp() throws Exception {
        mContext = getContext();
    }

    public void testVerifyEndpointsAsyncTaskResult() {
        String joke = "";
        try {
            JokeFetcher jokeTask = new JokeFetcher(new JokeFetcher.JokeFetchListener() {
                @Override
                public void onJokeFetched(String joke) {
                    if (joke == null) {
                        fail("Joke is Null");
                    }
                }
            });
            Random rand = new Random();
            joke = jokeTask.fetchJoke(rand.nextInt()).get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            fail("Timed out");
        }

        assertNotNull("No Joke fetched from server", joke);
        assertTrue("Joke fetched from server has no Joke at all :) !", joke.length() > 0);
    }
}
