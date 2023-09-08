package repository;

import entity.BookBackupEntity;
import entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookBackupEntity> findByAuthor(String author);

    @Query(value = "Select b from BookEntity b where b.name like ?1%")
    List<BookEntity> getBookNameStartWith(String name);

    @Query(value = "Select * from BookEntity b where b.price > ?1", nativeQuery = true)
    List<BookEntity> getBookPriceMore(double price);

   // BookEntity findOne(int i);
}
