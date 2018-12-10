package cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cnpm.domain.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Integer> {
	AppRole findByName(String name);
}
