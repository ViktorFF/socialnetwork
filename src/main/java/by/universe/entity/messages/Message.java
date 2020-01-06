package by.universe.entity.messages;

import java.util.Objects;

public abstract class Message {
    static int icrId = 1;
    private int id = icrId++;
    private String userName;
    private String text;
    private String date;

    Message() {
    }

    Message(String userName, String text, String date) {
        this.userName = userName;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentText() {
        return text;
    }

    public void setCommentText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", commentText='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
