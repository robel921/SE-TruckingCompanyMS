package edu.miu.cs.cs425.webapp.homib_tcms.service;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address save(Address address);
    Address findById(Long aId);
    void delete(Long aId);
}
