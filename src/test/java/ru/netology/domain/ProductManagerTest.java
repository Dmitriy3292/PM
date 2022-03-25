package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product smart = new Smartphone(1, "tel1", 999,  "china");
    Product smart1 = new Smartphone(2, "tel2", 1999,  "rus");
    Product smart2 = new Smartphone(3, "tel2", 1999,  "zx");
    Product smart3 = new Smartphone(4, "tel3", 1999,  "zx");
    Product smart4 = new Smartphone(4, "tel2", 1999,  "zx");
    Product book = new Book (3,"kniga",100,"popov");
    Product book1 = new Book (4,"kniga1",100,"ivanov");
    Product book2 = new Book(5,"tel1",500,"qwerty");


    @BeforeEach
            void save() {
        /*repository.save(smart);
        repository.save(smart1);
        repository.save(book);
        repository.save(book1);*/
        manager.add(smart);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        manager.add(smart4);
        manager.add(book);
        manager.add(book1);
        manager.add(book2);


    }



    @Test
    public void shouldSearchByNameSmart() {

        Product[] actual = manager.searchBy("china");
        Product[] expected =  {smart};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByNameSmart4() {

        Product[] actual = manager.searchBy("tel1");
        Product[] expected =  {smart,book2};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByManufacturerSmart() {

        Product[] actual = manager.searchBy("rus");
        Product[] expected =  {smart1};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByManufacturerSmart2() {

        Product[] actual = manager.searchBy("zx");
        Product[] expected =  {smart2,smart3,smart4};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByNameSmart2() {

        Product[] actual = manager.searchBy("tel2");
        Product[] expected =  {smart1,smart2,smart4};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByNSeveralSmart() {

        Product[] actual = manager.searchBy("tel2");
        Product[] expected =  {smart1,smart2,smart4};
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

        Product[] actual = manager.searchBy("popov");
        Product[] expected = {book};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAll() {
        Product[] expected = new Product[]{smart,smart1,smart2,smart3,smart4,book,book1,book2};
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
        Product[] expected = {smart,smart1,smart2,smart3,smart4,book,book1,book2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}

