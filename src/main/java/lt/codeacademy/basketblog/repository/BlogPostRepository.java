package lt.codeacademy.basketblog.repository;

        import lt.codeacademy.basketblog.model.BlogPost;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;
        import java.util.UUID;

public interface BlogPostRepository extends JpaRepository<BlogPost, UUID> {


    List<BlogPost> findByTitle(String title);
}
