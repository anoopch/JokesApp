package ch.anoop.androidjokeactivitylibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by anoop.ch on 6/15/2016.
 */
public class JokeActivity extends AppCompatActivity{
    public static final String INTENT_EXTRA_JOKE = "ch.anoop.androidjokeactivitylibrary.EXTRA_JOKE";
        private CurrentJoke currentJoke;
        private TextView answerTextView;
        private View imageView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_joke);
            if (getIntent().hasExtra(INTENT_EXTRA_JOKE)) {
                String rawJoke = getIntent().getStringExtra(INTENT_EXTRA_JOKE);
                String[] jokeSplit = rawJoke.split("AABBCC");
                currentJoke = new CurrentJoke(
                        Integer.parseInt(jokeSplit[0]),
                        jokeSplit[1] + "?",
                        jokeSplit[2]
                );
            }else {
                //Todo Later
                //finish();
            }

        }

        @Override
        protected void onResume() {
            super.onResume();
            TextView questionTextView = (TextView) findViewById(R.id.questionTextView);
            answerTextView = (TextView) findViewById(R.id.answerTextView);
            imageView = findViewById(R.id.showAnswerImageView);
            if (questionTextView != null) {
                questionTextView.setText(
                        currentJoke.getQuestionString()
                );
            }
        }

        public void onShowAnswerClicked(View clickedView) {
            if (imageView != null)
                imageView.setVisibility(
                        imageView.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE
                );

            if (answerTextView != null) {
                answerTextView.setVisibility(
                        answerTextView.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE
                );

                answerTextView.setText(
                        currentJoke.getAnswerString()
                );
            }
        }
    }
