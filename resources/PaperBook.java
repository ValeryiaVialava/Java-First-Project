package resources;

import java.time.LocalDate;
import users.*;
import interfejses.Rentable;
import exceptions.NoAvailableResourceException;

public class PaperBook extends Book implements Rentable {
    private int pages;
    private LocalDate rentDate;
    private LocalDate dueDate;
    private User user;

    public PaperBook(String title, String publisher, int resourceId, String author, int pages) {
        super(title, publisher, resourceId, author);
        this.pages = pages;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Pages: " + pages);
    }

    @Override
    public void rent(User user) throws NoAvailableResourceException {
        if (this.status == Status.UNAVAILABLE) {
            throw new NoAvailableResourceException("Book is already rented.");
        }
        this.user = user;
        this.rentDate = LocalDate.now();
        this.dueDate = (user instanceof Student) ? rentDate.plusMonths(1) : rentDate.plusMonths(3);
        this.status = Status.UNAVAILABLE;
    }

    public User getUser() {
        return user;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }


}
