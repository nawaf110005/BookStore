package nawaf.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String category;
    private String Img;
    private String author;
    private Double price;
    private LocalDate releaseDate;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<OrderB> orders;
}
