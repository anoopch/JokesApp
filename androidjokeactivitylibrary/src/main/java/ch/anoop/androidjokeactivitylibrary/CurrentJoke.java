package ch.anoop.androidjokeactivitylibrary;

/**
 * Created by anoop.ch on 6/15/2016.
 */
public class CurrentJoke {
    int id;
    String questionString;
    String answerString;

    public CurrentJoke(){}

    public CurrentJoke(int id, String questionString, String answerString) {
        this.id = id;
        this.questionString = questionString;
        this.answerString = answerString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public String getAnswerString() {
        return answerString;
    }

    public void setAnswerString(String answerString) {
        this.answerString = answerString;
    }
}
