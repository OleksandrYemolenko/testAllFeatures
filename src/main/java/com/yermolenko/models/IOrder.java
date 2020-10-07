package com.yermolenko.models;

import java.util.UUID;

public interface IOrder {

    public IAddress getAddress();

    public UUID getGuid();

    public String getStatus();
}
