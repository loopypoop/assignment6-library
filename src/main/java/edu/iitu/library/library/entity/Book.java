package edu.iitu.library.library.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
@Component
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

//    @Column(name = "author_id")
//    private Integer authorId;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private BookState state;

    @Column
    private Double price;

    @Column(name = "userId")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

//    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "authors_books", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "id",
                    nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Author> authors = new HashSet<>();

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", price=" + price +
                ", userId=" + userId +
                '}';
    }
}
