package ch.anoop.joke.android;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import ch.anoop.joke.backend.myApi.MyApi;


public class JokeFetcher {
    private JokeFetchListener jokeFetcherListener;

    public JokeFetcher(JokeFetchListener jokeFetcherListener) {
        this.jokeFetcherListener = jokeFetcherListener;
    }

    public interface JokeFetchListener {
        void onJokeFetched(String joke);
    }

    public EndpointsAsyncTask fetchJoke(Integer index) {
        EndpointsAsyncTask jokeTask = new EndpointsAsyncTask();
        jokeTask.execute(index);
        return jokeTask;
    }

    public class EndpointsAsyncTask extends AsyncTask<Integer, Void, String> {
        private MyApi myApi = null;
        private Integer index;

        @Override
        protected String doInBackground(Integer... params) {
            if (myApi == null) {
                MyApi.Builder builder = new MyApi.Builder(
                        AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(),
                        null
                ).setRootUrl("https://sacred-temple-134323.appspot.com/_ah/api/");

                myApi = builder.build();
            }

            index = params[0];

            try {
                return myApi.fetchJoke(index).execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            jokeFetcherListener.onJokeFetched(result);
        }
    }
}
