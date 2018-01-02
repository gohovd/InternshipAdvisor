package core;

public class Topic {

    // TODO Initially we thought of having a description plus an array of tags related to the topic.
    // TODO To keep it simple we just use one single tag (e.g. biology, cinema,..)

    String tag;

    public Topic() {}

    public Topic(String tag) {
        //TODO Add guards!

        this.tag = tag;
    }
}
