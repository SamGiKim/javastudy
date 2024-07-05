package CategoryPractice;

import com.example.phoneb.PhoneBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAllByNameContains(String name);
}
