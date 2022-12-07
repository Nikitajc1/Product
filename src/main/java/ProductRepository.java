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

    public void removeById(int id) {
        Product[] item = new Product[repo.length - 1];
        int index = 0;
        for (Product tmp : repo) {
            if (tmp.getId() != id){
                item[index] = tmp;
                index++;
            }
            repo = item;
        }
    }

    public Product[] findAll(){
        return repo;
    }
}
