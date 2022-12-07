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

//    public boolean matches(Product product, String search) {
//        return product.getName().contains(search);
//    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[1];
        for (Product product : repos.findAll()) {
            if (product.matches(text)) {
                result[0] = product;
            }
        }

        return result;
    }

    public void removeManager(int id) {
        repos.removeById(id);
    }
}
