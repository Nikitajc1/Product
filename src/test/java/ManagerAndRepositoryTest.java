import lombok.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerAndRepositoryTest {
    ProductRepository product = new ProductRepository();
    ProductManager manager = new ProductManager(product);

    Product item1 = new Product(1, "свитер", 999);
    Product item2 = new Product(2, "джинсы", 5999);
    Product item3 = new Product(3, "некробук", 9999);
    Book item4 = new Book(1,"1984", 3333, "Д. Кенеди");
    Smartphone item5 = new Smartphone(281, "Juice", 199999, "China");

    @Test
    public void saveTestAndFindAll() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = manager.findAllManager();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTest() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("джинсы");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeTest() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.removeManager(item3.getId());

        Product[] expected = {item1, item2};
        Product[] actual = manager.findAllManager();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void setIdTest() {
        manager.add(item1);

        int expected = 2;
        int actual = item1.setId(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void priceTest() {
        manager.add(item1);

        int expected = 999;
        int actual = item1.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void priceSetTest() {
        manager.add(item1);

        int expected = 0;
        int actual = item1.setPrice(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest() {
        manager.add(item1);

        String expected = "майка";
        String actual = item1.setName("майка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Book() {
        Book name = new Book(1,"1984", 3333, "Д. Кенеди");
    }

    @Test
    public void Smartphone() {
        Smartphone name = new Smartphone(2,"Mooba", 9333, "China");
    }

    @Test
    public void bookMatches() {

        manager.add(item4);

        boolean expected = true;
        boolean actual = item4.matches("Д. Кенеди");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void bookMatchesTrue() {

        manager.add(item4);

        boolean expected = true;
        boolean actual = item4.matches("1984");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void smartphoneMatches() {

        manager.add(item5);

        boolean expected = true;
        boolean actual = item5.matches("China");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void smartphoneMatchesTrue() {

        manager.add(item5);

        boolean expected = true;
        boolean actual = item5.matches("Juice");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setNameBook() {

        manager.add(item4);

        String expected = "Дебри Джавы";
        String actual = item4.setName("Дебри Джавы");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void setAuthorBook() {

        manager.add(item4);

        String expected = "Олег";
        String actual = item4.setAuthor("Олег");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void setNamePhone() {

        manager.add(item5);

        String expected = "Heaven";
        String actual = item5.setName("Heaven");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void setMadeByPhone() {

        manager.add(item5);
        item5.setMadeBy("India");

        String expected = "India";
        String actual = item5.getMadeBy();

        Assertions.assertEquals(expected, actual);

    }
}
