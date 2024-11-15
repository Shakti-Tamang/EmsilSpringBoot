package com.nextstep.project.service;

import com.nextstep.project.model.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public List<User>getUser();
    public void deleteById(int id);
    public User getDetailById(int id);
    public void updateUser(User user);
}
