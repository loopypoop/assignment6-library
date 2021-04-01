package edu.iitu.library.library.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "author")
@Component
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String about;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "authors_books", joinColumns = {
            @JoinColumn(name = "author_id", referencedColumnName = "id",
            nullable = false, updatable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "id",
            nullable = false, updatable = false)})
    private Set<Book> books = new HashSet<>();


}
