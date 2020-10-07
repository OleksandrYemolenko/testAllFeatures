package com.yermolenko.mappers;

import com.yermolenko.dto.UserDTO;
import com.yermolenko.models.IUser;
import com.yermolenko.models.impl.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(IUser iUser);

    UserDTO toUserDTO(IUser user);
}
