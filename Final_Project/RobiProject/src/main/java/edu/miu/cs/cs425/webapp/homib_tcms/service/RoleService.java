package edu.miu.cs.cs425.webapp.homib_tcms.service;

import edu.miu.cs.cs425.webapp.homib_tcms.module.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role save(Role role);
    Role findById(Long rId);
    void delete(Long rId);
}
