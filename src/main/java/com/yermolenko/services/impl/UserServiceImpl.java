package com.yermolenko.services.impl;

import java.util.UUID;

import com.yermolenko.mappers.IUserMapper;
import com.yermolenko.models.IUser;
import com.yermolenko.models.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yermolenko.repositories.IUserRepository;
import com.yermolenko.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    //TODO: add logger

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public IUser create(IUser iUser) throws Exception {
        try {
            final User user = IUserMapper.INSTANCE.toUser(iUser);

            user.setGuid(UUID.randomUUID());

            final User createdUser = userRepository.saveAndFlush(user);

            return createdUser;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public IUser update(IUser iUser, String guid) throws Exception {
        User currentUser = userRepository.getByGuid(UUID.fromString(guid));

        try {
            currentUser.setEmail(iUser.getEmail());
            currentUser.setName(iUser.getName());
            currentUser.setNickname(iUser.getNickname());
            currentUser.setPhoneNumber(iUser.getPhoneNumber());

            final User updatedUser = userRepository.saveAndFlush(currentUser);

            return updatedUser;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public IUser getUserByGuid(String guid) {
        User currentUser = userRepository.getByGuid(UUID.fromString(guid));

        return currentUser;
    }

    @Override
    public void delete(String guid) {
        User currentUser = userRepository.getByGuid(UUID.fromString(guid));

        userRepository.delete(currentUser);
    }
}
