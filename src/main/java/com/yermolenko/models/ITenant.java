package com.yermolenko.models;

import java.util.UUID;

public interface ITenant {

    public IUser getTenantOwner();

    public UUID getGuid();

    public String getName();
}
