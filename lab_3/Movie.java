class Movie {
    private final String title;
    private final String time;

    public Movie(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Movie name: " + title;
    }
}