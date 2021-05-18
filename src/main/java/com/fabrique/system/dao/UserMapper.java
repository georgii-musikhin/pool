package com.fabrique.system.dao;


import com.fabrique.system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface User mapper.
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * Save user int.
     *
     * @param user the user
     * @return the int
     */
    int saveUser(User user);

    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    Optional<User> getUserById(@Param("userId") Long userId);

    /**
     * Gets all users.
     *
     * @return the all users
     */
    List<User> getAllUsers();
}
