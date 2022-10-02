package com.bts.recruiting.servicies;

import com.bts.recruiting.dtos.UserDto;
import com.bts.recruiting.enums.UserDecision;
import com.bts.recruiting.enums.UserQueueLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {

    UserDto addUser(UserDto userDto);

    UserDto addUserDecision(UserDecision userDecision, Integer userId);

    Page<UserDto> findAllByStatus(UserQueueLevel userQueueLevel, Pageable pageable);
}
