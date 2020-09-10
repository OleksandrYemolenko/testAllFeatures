package com.yermolenko.mappers;

import com.yermolenko.dto.UserDTO;
import com.yermolenko.models.IUser;
import com.yermolenko.models.impl.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toUser(IUser iUser);

    UserDTO toUserDTO(IUser user);
}
