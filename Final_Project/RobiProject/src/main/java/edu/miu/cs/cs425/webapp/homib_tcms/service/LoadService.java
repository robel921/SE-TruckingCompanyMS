package edu.miu.cs.cs425.webapp.homib_tcms.service;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;

import java.util.List;

public interface LoadService {

    public abstract List<Load> fetchAllLoads();
    public abstract Load saveLoads(Load load);
    public abstract Load getLoadById(Long loadId);
    public abstract void deleteLoadById(Long loadId);
}
