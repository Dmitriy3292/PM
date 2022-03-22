package ru.netology.domaine;

import org.junit.jupiter.api.Test;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void shouldSearchByName() {
        Product smart = new Smartphone(1, "tel1", 999, "zvonilka", "china");
        Product smart1 = new Smartphone(2, "tel2", 1999, "gudelka", "rus");


        ProductRepository repository = new ProductRepository();
        repository.save(smart);
        repository.save(smart1);

        ProductManager manager = new ProductManager(repository);
        manager.searchBy("smart");





        Product[] actual = manager.searchBy("smart");
        Product[] expected = new Product[]{smart, smart1};
        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchByNameBook() {
        Product book1 = new Book(1,"kniga",100,"popov",600,2022);
        Product book2 = new Book(2,"kniga2",101,"popov2",601,2021);


        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);


        ProductManager manager = new ProductManager(repository);
        manager.searchBy("popov");



        Product[] actual = manager.searchBy("popov");
        Product[] expected = new Product[]{book1, book2};
        assertArrayEquals(expected, actual);


    }
}

