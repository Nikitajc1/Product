public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String setAuthor(String author) {
        this.author = author;
        return author;
    }

    @Override
    public boolean matches(String search) {
        if (!super.matches(search)) {
            return this.getAuthor().contains(search);
        }
        return true;
    }
}
