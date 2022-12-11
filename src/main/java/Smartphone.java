public class Smartphone extends Product {
    private String madeBy;

    public Smartphone(int id, String name, int price, String madeBy) {
        super(id, name, price);
        this.madeBy = madeBy;
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

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    @Override
    public boolean matches(String search) {
        if (!super.matches(search)) {
            return this.getMadeBy().contains(search);
        }
        return true;
    }
}
