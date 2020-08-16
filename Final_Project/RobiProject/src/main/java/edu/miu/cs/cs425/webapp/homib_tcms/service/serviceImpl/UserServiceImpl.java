package edu.miu.cs.cs425.webapp.homib_tcms.service.serviceImpl;

import edu.miu.cs.cs425.webapp.homib_tcms.module.User;
import edu.miu.cs.cs425.webapp.homib_tcms.repository.IUserRepository;
import edu.miu.cs.cs425.webapp.homib_tcms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> fetchAllDrivers() {
        return userRepository.findAll();
    }

    @Override
    public User saveDrivers(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getDriverById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteDriverById(Long userId) {
            userRepository.deleteById(userId);
    }
}
