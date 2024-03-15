package umbcs680.multicastdesign;

public class Comment {
    private String commenterName;
    private String commentText;

    public Comment(String commenterName, String commentText) {
        this.commenterName = commenterName;
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return commenterName + ": " + commentText;
    }
}
