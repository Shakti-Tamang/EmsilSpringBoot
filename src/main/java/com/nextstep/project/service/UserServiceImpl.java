package com.nextstep.project.service;

import com.nextstep.project.model.User;
import com.nextstep.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {

userRepository.save(user);
    }

    @Override
    public List<User> getUser() {

        List<User>list=userRepository.findAll();
        return list.isEmpty()?new ArrayList<>():list;
    }

    @Override
    public void deleteById(int id) {
userRepository.deleteById(id);
    }

    @Override
    public User getDetailById(int id) {

        Optional<User> user=userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public void updateUser(User user) {

User user1=getDetailById(user.getId());
if(user1!=null){
    user1.setName(user.getName());
    user1.setAddress(user.getAddress());
    user1.setReligion(user.getReligion());
    user1.setContactNumber(user.getContactNumber());
    userRepository.save(user1);
}
    }
}
