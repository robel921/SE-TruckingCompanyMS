package edu.miu.cs.cs425.webapp.homib_tcms.service;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;
import edu.miu.cs.cs425.webapp.homib_tcms.module.User;

import java.util.List;

public interface UserService {
    public abstract List<User> fetchAllDrivers();
    public abstract User saveDrivers(User user);
    public abstract User getDriverById(Long userId);
    public abstract void deleteDriverById(Long userId);
}
