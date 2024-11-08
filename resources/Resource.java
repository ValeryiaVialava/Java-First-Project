package resources;
import java.time.LocalDate;


public abstract class Resource {
    protected String title;
    protected String publisher;
    protected int resourceId;
    protected Status status;
    private LocalDate dueDate;


    public Resource(String title, String publisher, int resourceId) {
        this.title = title;
        this.publisher = publisher;
        this.resourceId = resourceId;
        this.status = Status.AVAILABLE;
    }

    public abstract void print();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(getDueDate()) && status == Status.UNAVAILABLE;
    }
}
