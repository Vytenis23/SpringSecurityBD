package lt.codeacademy.basketblog.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "blogposts")
public class BlogPost {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    //@Type(type = "uuid-char")
    private UUID id;

    private String title;

    private String author;

    private LocalDateTime createdDate;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
}
