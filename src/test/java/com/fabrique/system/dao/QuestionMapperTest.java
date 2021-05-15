package com.fabrique.system.dao;

import com.fabrique.system.entity.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties
@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class QuestionMapperTest {

    @Resource
    private QuestionMapper questionMapper;

    @Test
    public void testSaveQuestion() {
        Question question = new Question();
        question.setQuestionText("testText");
        question.setQuestionType(0L);
        question.setPoolId(1L);
        int rowNumber = questionMapper.saveQuestion(question);

        assertEquals(rowNumber, 1);
    }

    @Test
    public void testGetQuestionById() {
        Question expected = new Question(1L, "questionOneText", 0L, 1L);

        Optional<Question> actual = questionMapper.getQuestionById(1L);
        System.out.println(actual);
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    public void testGetAllQuestions() {
        List<Question> questions = questionMapper.getAllQuestions();

        System.out.println(questions);
        assertFalse(CollectionUtils.isEmpty(questions));
    }

    @Test
    public void testUpdateQuestion() {
        Question questionToUpdate = new Question(1L, "newQuestionText", 0L, 1L);

        int rowNumber = questionMapper.updateQuestion(questionToUpdate);
        assertEquals(rowNumber, 1);
    }
}
