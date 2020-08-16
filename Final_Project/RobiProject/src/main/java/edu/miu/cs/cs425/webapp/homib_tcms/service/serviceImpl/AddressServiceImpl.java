package edu.miu.cs.cs425.webapp.homib_tcms.service.serviceImpl;

import edu.miu.cs.cs425.webapp.homib_tcms.module.Address;
import edu.miu.cs.cs425.webapp.homib_tcms.repository.IAddressRepository;
import edu.miu.cs.cs425.webapp.homib_tcms.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

   private IAddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long aId) {
        return addressRepository.findById(aId).orElse(null);
    }

    @Override
    public void delete(Long aId) {
        addressRepository.deleteById(aId);
    }
}
