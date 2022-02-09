package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
     ProductRepository repo = new ProductRepository();
     Product phone1 = new Smartphone(1, "Samsung Galaxy S22", 100000, "Samsung");
     Product phone2 = new Smartphone(2, "Iphone 13", 110000, "Apple");
     Product phone3 = new Smartphone(3, "Huawei P50 Pro", 80000, "Huawei");
     Product book1 = new Book(4, "Transhumanism inc", 800, "Victor Pelevin");
     Product book2 = new Book(5, "The ritual", 600, "Adam Nevill");
     Product book3 = new Book(6, "Lost Echoes", 700, "Joe Lansdale");

    @BeforeEach
    void setUp() {
        repo.save(phone1);
        repo.save(phone2);
        repo.save(phone3);
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

    }

    @Test
    void shouldRemoveByIdPositive() {
        repo.removeById(4);
        Product[] expected = {phone1, phone2, phone3, book2, book3 };
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNegative() {

        assertThrows(NotFoundException.class, () -> repo.removeById(7));
    }


}