package com.yermolenko.models;

import java.util.UUID;

public interface IItem {

    public ICategory getCategory();

    public String getDetails();

    public String getImageUrl();

    public UUID getGuid();
}
