package edu.miu.cs.cs425.webapp.homib_tcms.service.serviceImpl;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Credential;
import edu.miu.cs.cs425.webapp.homib_tcms.repository.ICredentialRepository;
import edu.miu.cs.cs425.webapp.homib_tcms.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialServiceImpl implements CredentialService {

    private ICredentialRepository credentialRepository;

    @Autowired
    public CredentialServiceImpl(ICredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }
    @Override
    public List<Credential> findAll() {

        return credentialRepository.findAll();
    }

    @Override
    public Credential save(Credential credential) {

        return credentialRepository.save(credential);
    }

    @Override
    public Credential findById(Long cId) {

        return credentialRepository.findById(cId).orElse(null);
    }

    @Override
    public void delete(Long cId) {
        credentialRepository.deleteById(cId);

    }
}
