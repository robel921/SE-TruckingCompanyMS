package edu.miu.cs.cs425.webapp.homib_tcms.repository;

import edu.miu.cs.cs425.webapp.homib_tcms.module.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User, Long> {
}
