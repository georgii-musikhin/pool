package com.fabrique.system.dao;

import com.fabrique.system.entity.Pool;
import com.fabrique.system.entity.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties
@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PoolMapperTest {

    @Resource
    private PoolMapper poolMapper;

    @Test
    void testSavePool() {
        Pool poolToSave = new Pool();
        poolToSave.setName("testPool");
        poolToSave.setCreateDate(LocalDate.parse("2021-05-15"));

        int rowAffected = poolMapper.savePool(poolToSave);

        assertEquals(1, rowAffected);
    }

    @Test
    void testGetPoolById() {
        Pool expected = new Pool();
        expected.setPoolId(1L);
        expected.setName("testPool");
        expected.setCreateDate(LocalDate.parse("2021-05-15"));
        expected.setQuestionList(Arrays.asList(
                new Question(1L, "questionOneText", 0L, 1L),
                new Question(2L, "questionTWOText", 2L, 1L)
        ));

        Optional<Pool> actual = poolMapper.getPoolById(1L);

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    void testGetAllPools() {
        List<Pool> expected = Arrays.asList(
                new Pool(1L, "testPool", LocalDate.parse("2021-05-15"), null, null),
                new Pool(2L, "testTwoPool", LocalDate.parse("2021-05-16"), null, null)
        );

        List<Pool> actual = poolMapper.getAllPools();

        assertEquals(expected, actual);
    }

    @Test
    public void testUpdatePool() {
        Pool poolToUpdate = new Pool(1L, "newTestPool", LocalDate.parse("2021-05-15"),
                LocalDate.parse("2021-05-16"), null);

        int rowNumber = poolMapper.updatePool(poolToUpdate);
        assertEquals(rowNumber, 1);
    }
}
