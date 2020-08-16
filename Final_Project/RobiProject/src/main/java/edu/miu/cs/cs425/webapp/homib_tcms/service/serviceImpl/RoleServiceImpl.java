package edu.miu.cs.cs425.webapp.homib_tcms.service.serviceImpl;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Role;
import edu.miu.cs.cs425.webapp.homib_tcms.repository.IRoleRepository;
import edu.miu.cs.cs425.webapp.homib_tcms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private IRoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public List<Role> findAll() {

        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public Role findById(Long rId) {

        return roleRepository.findById(rId).orElse(null);
    }

    @Override
    public void delete(Long rId) {
        roleRepository.deleteById(rId);

    }
}
