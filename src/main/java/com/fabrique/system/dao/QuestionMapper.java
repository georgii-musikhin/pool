package com.fabrique.system.dao;

import com.fabrique.system.entity.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Question mapper.
 */
@Mapper
@Repository
public interface QuestionMapper {

    /**
     * Save int.
     *
     * @param question the question
     * @return the int
     */
    @Insert(" INSERT INTO question(question_text, question_type, pool_id) " +
            " VALUES (#{questionText}, #{questionType}, #{poolId}) ")
    int saveQuestion(Question question);

    /**
     * Gets by id.
     *
     * @param questionId the question id
     * @return the by id
     */
    @Select({" SELECT question_id, question_text, question_type, pool_id" +
             "        FROM question" +
             "        WHERE question_id = #{questionId}"})
    Optional<Question> getQuestionById(@Param("questionId") Long questionId);

    /**
     * Gets all questions.
     *
     * @return the all questions
     */
    @Select(" SELECT question_id, question_text, question_type, pool_id" +
            "        FROM question")
    List<Question> getAllQuestions();

    /**
     * Update question long.
     *
     * @param question the question
     * @return the long
     */
    int updateQuestion(Question question);
}
