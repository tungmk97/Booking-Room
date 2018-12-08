package cnpm.repository;

import cnpm.domain.Error;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<Error,String> {
}
