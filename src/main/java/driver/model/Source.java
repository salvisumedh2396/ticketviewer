package driver.model;

public class Source {

    Object from;
    Object to;
    Object rel;

    public Source() {
    }

    public Source(Object from, Object to, Object rel) {
        this.from = from;
        this.to = to;
        this.rel = rel;
    }

    public Object getFrom() {
        return from;
    }

    public void setFrom(Object from) {
        this.from = from;
    }

    public Object getTo() {
        return to;
    }

    public void setTo(Object to) {
        this.to = to;
    }

    public Object getRel() {
        return rel;
    }

    public void setRel(Object rel) {
        this.rel = rel;
    }
}
