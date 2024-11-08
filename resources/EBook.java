package resources;

import interfejses.Digital;

public class EBook extends Book implements Digital {
    private double size;
    private int numberOfDownloads;

    public EBook(String title, String publisher, int resourceId, String author, double size) {
        super(title, publisher, resourceId, author);
        this.size = size;
        this.numberOfDownloads = 0;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Size: " + size + "MB");
    }

    @Override
    public void download() {
        numberOfDownloads++;
        this.status = Status.DIGITAL;
    }

    public int getNumberOfDownloads() {
        return numberOfDownloads;
    }
}
