package driver.model;

public class SatisfactionRating {
    private String comment;
    private long id;
    private String score;

    public SatisfactionRating() {
    }

    public SatisfactionRating(String comment, long id, String score) {
        this.comment = comment;
        this.id = id;
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
