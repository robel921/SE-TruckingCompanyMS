package edu.miu.cs.cs425.webapp.homib_tcms.service;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Credential;

import java.util.List;

public interface CredentialService {
    List<Credential> findAll();
    Credential save(Credential credential);
    Credential findById(Long cId);
    void delete(Long cId);
}
