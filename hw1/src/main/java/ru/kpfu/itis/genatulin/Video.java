package ru.kpfu.itis.genatulin;

public class Video {
    private String title;
    private String duration;
    private String amountOfViews;

    public Video(String title, String duration, String amountOfViews) {
        this.title = title;
        this.duration = duration;
        this.amountOfViews = amountOfViews;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", amountOfViews='" + amountOfViews + '\'' +
                '}';
    }
}
