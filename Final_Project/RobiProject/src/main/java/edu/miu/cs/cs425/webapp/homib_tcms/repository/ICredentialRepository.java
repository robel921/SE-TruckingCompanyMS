package edu.miu.cs.cs425.webapp.homib_tcms.repository;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICredentialRepository  extends JpaRepository<Credential, Long> {
    Optional<Credential> findByUserName(String username);
}
