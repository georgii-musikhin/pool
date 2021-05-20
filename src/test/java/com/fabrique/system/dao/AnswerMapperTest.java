package com.fabrique.system.dao;

import com.fabrique.system.entity.Answer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

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
public class AnswerMapperTest {

    @Resource
    private AnswerMapper answerMapper;

    @Test
    void testSaveAnswer() {
        Answer answerToSave = new Answer();
        answerToSave.setQuestionId(2L);
        answerToSave.setUserId(1L);

        int rowAffected = answerMapper.saveAnswer(answerToSave);

        assertEquals(1, rowAffected);
    }

    @Test
    void testGetAnswerById() {
        Answer expected = new Answer(1L, 1L, "firstAnswer");

        Optional<Answer> actual = answerMapper.getAnswerById(1L, 1L);

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    void testGetAllAnswerByQuestion() {
        List<Answer> expected = Arrays.asList(
                new Answer(1L, 1L, "firstAnswer"),
                new Answer(1L, 2L, "secondAnswer")
        );

        List<Answer> actual = answerMapper.getAllAnswerByQuestion(1L);

        assertEquals(expected, actual);
    }
}
