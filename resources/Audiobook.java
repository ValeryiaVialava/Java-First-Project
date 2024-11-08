package resources;

import interfejses.Digital;

public class Audiobook extends Book implements Digital {
    private int length;
    private int numberOfDownloads;

    public Audiobook(String title, String publisher, int resourceId, String author, int length) {
        super(title, publisher, resourceId, author);
        this.length = length;
        this.numberOfDownloads = 0;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Length: " + length + " minutes");
    }

    @Override
    public void download() {
        numberOfDownloads++;
        this.status = Status.DIGITAL;
    }
}

