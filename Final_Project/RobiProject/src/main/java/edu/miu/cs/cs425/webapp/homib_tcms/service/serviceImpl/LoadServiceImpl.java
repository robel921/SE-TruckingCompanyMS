package edu.miu.cs.cs425.webapp.homib_tcms.service.serviceImpl;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;
import edu.miu.cs.cs425.webapp.homib_tcms.repository.ILoadRepository;
import edu.miu.cs.cs425.webapp.homib_tcms.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {

    private ILoadRepository loadRepository;
    @Autowired
    public LoadServiceImpl(ILoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    @Override
    public List<Load> fetchAllLoads() {
       return loadRepository.findAll();
    }

    @Override
    public Load saveLoads(Load load) {
        return loadRepository.save(load);
    }

    @Override
    public Load getLoadById(Long loadId) {
        return loadRepository.findById(loadId).orElse(null);
    }

    @Override
    public void deleteLoadById(Long loadId) {
        loadRepository.deleteById(loadId);
    }
}
