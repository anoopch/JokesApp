package ch.anoop.joke.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import ch.anoop.androidjokeactivitylibrary.JokeActivity;


public class MainActivity extends AppCompatActivity implements JokeFetcher.JokeFetchListener {

    Random mJokeIndexRandGen;
    ProgressBar mSpinner;
    TextView mInstructionsTextView;
    Button mTellJokeButton;
    boolean mStopSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJokeIndexRandGen = new Random();
    }


    public void onShowJokeClicked(View view) {
        if (view != null) {
            View rootView = view.getRootView();
            mTellJokeButton = (Button) view;
            mInstructionsTextView = (TextView) rootView.findViewById(R.id.instructions_text_view);
            mSpinner = (ProgressBar) rootView.findViewById(R.id.progress_bar_joke);
        }
        startJokeTask();
    }

    private void startSpinner() {
        if (mTellJokeButton != null) {
            mTellJokeButton.setVisibility(View.GONE);
            mInstructionsTextView.setVisibility(View.GONE);
            mSpinner.setVisibility(View.VISIBLE);
        }
    }

    private void stopSpinner() {
        if (mSpinner != null) {
            mSpinner.setVisibility(View.GONE);
            mInstructionsTextView.setVisibility(View.VISIBLE);
            mTellJokeButton.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mStopSpinner) {
            stopSpinner();
            mStopSpinner = false;
        }
    }


    private void startJokeTask() {
        startSpinner();
        new JokeFetcher(this).fetchJoke(mJokeIndexRandGen.nextInt(11));
    }

    @Override
    public void onJokeFetched(String joke) {
        Intent i = new Intent(this, JokeActivity.class);
        i.putExtra(JokeActivity.INTENT_EXTRA_JOKE, joke);
        startActivity(i);
        mStopSpinner = true;
    }
}
