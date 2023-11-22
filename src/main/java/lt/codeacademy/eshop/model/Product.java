package lt.codeacademy.eshop.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    //@Type(type = "uuid-char")
    private UUID id;

    private String name;

    private Integer quantity;

    private BigDecimal price;

    private String description;
}
