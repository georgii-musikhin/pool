package com.fabrique.system.dao;

import com.fabrique.system.entity.Pool;
import com.fabrique.system.entity.Question;
import com.fabrique.system.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties
@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSaveUser() {
        User user = new User();
        int rowNumber = userMapper.saveUser(user);

        assertEquals(1, rowNumber);
        assertEquals(3L, user.getUserId());
    }

    @Test
    public void testGetUserById() {
        User expected = new User();
        expected.setUserId(2L);
        Pool expectedPool = new Pool();
        expectedPool.setPoolId(1L);
        expectedPool.setName("testPool");
        expectedPool.setCreateDate(LocalDate.parse("2021-05-15"));
        expectedPool.setQuestionList(Arrays.asList(
                new Question(1L, "questionOneText", 0L, 1L),
                new Question(2L, "questionTWOText", 2L, 1L)
        ));
        expected.setPools(Collections.singletonList(expectedPool));

        Optional<User> actual = userMapper.getUserById(2L);

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    void testGetAllUsers() {
        List<User> expected = Arrays.asList(
                new User(1L, null),
                new User(2L, null)
        );

        List<User> actual = userMapper.getAllUsers();

        assertEquals(expected, actual);
    }
}
