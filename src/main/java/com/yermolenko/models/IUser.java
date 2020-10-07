package com.yermolenko.models;

import java.util.UUID;

/**
 * Interface for User data exchange with service and public api layers
 */
public interface IUser {

    public UUID getGuid();

    public String getEmail();

    public String getName();

    public String getPhoneNumber();
}
