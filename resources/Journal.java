package resources;

import java.time.LocalDate;
import users.User;
import interfejses.Rentable;
import exceptions.NoAvailableResourceException;

public class Journal extends Resource implements Rentable {
    private LocalDate publishDate;
    private LocalDate rentDate;
    private LocalDate dueDate;
    private User user;

    public Journal(String title, String publisher, int resourceId, LocalDate publishDate) {
        super(title, publisher, resourceId);
        this.publishDate = publishDate;
    }

    @Override
    public void print() {
        System.out.println("Journal: " + title + ", published on: " + publishDate);
    }

    @Override
    public void rent(User user) throws NoAvailableResourceException {
        if (this.status == Status.UNAVAILABLE) {
            throw new NoAvailableResourceException("Journal is already rented.");
        }
        this.user = user;
        this.rentDate = LocalDate.now();
        this.dueDate = rentDate.plusDays(10);
        this.status = Status.UNAVAILABLE;
    }

    public User getUser() {
        return user;
    }
}

