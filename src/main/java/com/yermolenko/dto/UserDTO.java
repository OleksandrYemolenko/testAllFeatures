package com.yermolenko.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.yermolenko.models.IUser;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements IUser {

    private UUID guid;

    private String email;

    private String name;

    private String nickname;

    private String phoneNumber;
}
