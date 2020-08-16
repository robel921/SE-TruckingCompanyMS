package edu.miu.cs.cs425.webapp.homib_tcms.repository;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
