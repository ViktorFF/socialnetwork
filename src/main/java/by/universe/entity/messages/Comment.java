package by.universe.entity.messages;

public class Comment extends Message {
    private int id = icrId++;

    public Comment() {
    }

    public Comment(String userName, String commentText, String date) {
        super(userName, commentText, date);
    }
}
