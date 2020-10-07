package com.yermolenko.models;

import java.util.UUID;

public interface IAddress {

    public UUID getGuid();

    public String getAddress();

    public String getDetails();
}
