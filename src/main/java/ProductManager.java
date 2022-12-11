public class ProductManager {
    private ProductRepository repos;

    public ProductManager(ProductRepository repos) {
        this.repos = repos;
    }

    public void add(Product product) {
        repos.save(product);
    }

    public Product[] findAllManager() {
        return repos.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[1];
        for (Product product : repos.findAll()) {
            if (product.matches(text)) {
                result[0] = product;
            }
        }

        return result;
    }

    public void removeManager(int id) throws Exception{
        repos.removeById(id);
    }
}
