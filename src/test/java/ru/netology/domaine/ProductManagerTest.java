package ru.netology.domaine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product smart = new Smartphone(1, "tel1", 999,  "china");
    Product smart1 = new Smartphone(2, "tel2", 1999,  "rus");
    Product book = new Book (3,"kniga",100,"popov");
    Product book1 = new Book (4,"kniga1",100,"popov1");

    @BeforeEach
            void save() {
        /*repository.save(smart);
        repository.save(smart1);
        repository.save(book);
        repository.save(book1);*/
        manager.add(smart);
        manager.add(smart1);
        manager.add(book);
        manager.add(book1);

    }



    @Test
    public void shouldSearchByNameSmart() {

        Product[] actual = manager.searchBy("tel1");
        Product[] expected =  {smart};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByManufacturerSmart() {

        Product[] actual = manager.searchBy("rus");
        Product[] expected =  {smart1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameBook() {

        Product[] actual = manager.searchBy("kniga1");
        Product[] expected = {book1};
        assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldSearchByAuthorBook() {

        Product[] actual = manager.searchBy("popov1");
        Product[] expected = {book1};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAll() {
        Product[] expected = new Product[]{smart,smart1,book,book1};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldNotFound() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("tel1000");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFSave() {
        Product[] expected = {smart,smart1,book,book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}

