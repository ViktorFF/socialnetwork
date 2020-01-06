package by.universe.entity.messages;

import java.util.LinkedList;

public class Post extends Message {
    private int id = icrId++;
    private LinkedList<Comment> comments = new LinkedList<>();

    public Post() {
    }

    public Post(String userName, String commentText, String date) {
        super(userName, commentText, date);
    }

    public Post(String userName, String text, String date, LinkedList<Comment> comments) {
        super(userName, text, date);
        this.comments = comments;
    }

    public LinkedList<Comment> getComments() {
        return comments;
    }

    public void setComments(LinkedList<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", comments=" + comments +
                '}';
    }
}
