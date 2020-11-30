package com.yermolenko.models;

import java.util.UUID;

public interface IItem {

    ICategory getCategory();

    String getDescription();

    String getImageUrl();

    UUID getGuid();
}
