package ch.anoop.joke.producer;

public class JokeProducer {
    /**
     * Format:
     * -------
     * <p/>
     * id-AABBCC-question-AABBCC-answer
     */
    private final static String[] mJokes = {
            "1AABBCCWhy do cows wear bellsAABBCCBecause their horns don't work",
            "2AABBCCWhat did the duck say when he bought lipstickAABBCCput it on my bill",
            "3AABBCCWhat is black and white and red all overAABBCCA sunburnt penguin.",
            "4AABBCCWhat did the elephant say to the naked manAABBCCHow do you breathe through something so small?",
            "5AABBCCDid you hear about the old chameleon that couldn't change colorAABBCCHe had a reptile dysfunction",
            "6AABBCCWhat do you call a fish that needs help with her vocalsAABBCCAutotuna",
            "7AABBCCWhy did the cat go to MinnesotaAABBCCTo get a mini soda!",
            "8AABBCCWhy did the cow cross the roadAABBCCTo get to the udder side.",
            "9AABBCCWhat happens to a frog's car when it breaks downAABBCCIt gets toad away.",
            "10AABBCCI invited a teddy bear to dinner yesterdayAABBCCI offered him some food, but he said no thanks I'm stuffed.",
            "11AABBCCWhy do fish live in salt waterAABBCCBecause pepper makes them sneeze!",
            "12AABBCCWhat did the pirate say when he turned 80AABBCCAye Matey.",
            "13AABBCCWhy does a chicken coop have two doorsAABBCCIf it had four doors it would be a chicken sedan.",
            "14AABBCCHow do you think the unthinkableAABBCCWith an itheberg.",
            "15AABBCCWhere do mice park their boatsAABBCCAt the hickory dickory dock"
    };

    public static String fetchJoke(int index) {
        if (index!=0 && index >= mJokes.length) {
            index = mJokes.length % index;
        }
        return mJokes[index];
    }
}
