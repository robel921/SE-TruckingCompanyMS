package edu.miu.cs.cs425.webapp.homib_tcms.repository;

import edu.miu.cs.cs425.webapp.homib_tcms.module.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRoleRepository extends JpaRepository<Role, Long> {
}
