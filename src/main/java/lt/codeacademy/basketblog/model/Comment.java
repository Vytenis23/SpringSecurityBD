package lt.codeacademy.basketblog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private String text;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "blog_post_id") // Turi būti tikslus stulpelio pavadinimas, kuriame saugomas BlogPost ID
    private BlogPost blogPost;

}
