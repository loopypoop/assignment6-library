package edu.iitu.library.library.repository;

import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.BookState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book getById(Integer id);

    List<Book> getAllByUserId(Integer userId);

    @Query(value = "select b from Book b join Author a on a.id = :id")
    List<Book> findAllByAuthorId(@Param("id") Integer id);

    @Query(value = "select b from Book b join Author a on a.name = :name")
    List<Book> findAllByAuthorName(@Param("name") String name);

    Book getBookByName(String name);

    List<Book> getAllByState(BookState state);
}
