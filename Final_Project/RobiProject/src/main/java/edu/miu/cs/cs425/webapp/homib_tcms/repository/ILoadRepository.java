package edu.miu.cs.cs425.webapp.homib_tcms.repository;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoadRepository extends JpaRepository<Load, Long> {
}
