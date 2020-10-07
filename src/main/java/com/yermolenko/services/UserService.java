package com.yermolenko.services;

import java.util.UUID;

import com.yermolenko.models.IUser;

public interface UserService {

    public IUser create(IUser user) throws Exception;

    public IUser update(IUser user, String guid) throws Exception;

    public IUser getUserByGuid(String guid);

    public void delete(String guid);
}
