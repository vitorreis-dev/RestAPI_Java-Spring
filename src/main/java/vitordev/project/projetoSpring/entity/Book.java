package vitordev.project.projetoSpring.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private LocalDate year;
    @ManyToMany()
    @JoinTable(name = "tb_book_theme", joinColumns = @JoinColumn(name="book_id"), inverseJoinColumns = @JoinColumn(name = "theme_id"))
    private Set<BookThemes> bookThemes = new HashSet<>();

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public Set<BookThemes> getBookThemes() {
        return bookThemes;
    }

    public void setBookThemes(Set<BookThemes> bookThemes) {
        this.bookThemes = bookThemes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(year, book.year) && Objects.equals(bookThemes, book.bookThemes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, year, bookThemes);
    }
}