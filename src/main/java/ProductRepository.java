import org.w3c.dom.ls.LSOutput;

public class ProductRepository {
    private Product[] repo = new Product[0];

    public void save(Product product) {

        Product[] item = new Product[repo.length + 1];
        for (int i = 0; i < repo.length; i++) {
            item[i] = repo[i];
        }
        item[item.length - 1] = product;
        repo = item;
    }

    public void removeById(int id) throws Exception {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }

        Product[] item = new Product[repo.length - 1];
        int index = 0;
        for (Product tmp : repo) {
            if (tmp.getId() != id) {
                item[index] = tmp;
                index++;
            }
            repo = item;
        }
    }

    public Product findById(int id) {
        for (Product item : repo) {
            if (item == null || item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return repo;
    }
}
