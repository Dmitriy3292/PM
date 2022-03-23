package ru.netology.domaine;

import org.junit.jupiter.api.Test;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Product smart = new Smartphone(1, "tel1", 999, "zvonilka", "china");
    Product smart1 = new Smartphone(2, "tel2", 1999, "gudelka", "rus");
    Product book1 = new Book (3,"kniga",100,"popov");
    Product book2 = new Book (4,"kniga1",100,"popov1");

    @Test
    public void shouldSearchByName() {



        ProductRepository repository = new ProductRepository();
        repository.save(smart);
        repository.save(smart1);

        ProductManager manager = new ProductManager(repository);






        Product[] actual = manager.searchBy("rus");
        Product[] expected =  {smart1};
        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchByNameBook() {



        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);


        ProductManager manager = new ProductManager(repository);




        Product[] actual = manager.searchBy("kniga");
        Product[] expected = {book1};
        assertArrayEquals(expected, actual);


    }
}

