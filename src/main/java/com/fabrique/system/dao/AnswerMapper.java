package com.fabrique.system.dao;

import com.fabrique.system.entity.Answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

/**
 * The interface Answer mapper.
 */
public interface AnswerMapper {

    /**
     * Save answer int.
     *
     * @param answer the answer
     * @return the int
     */
    @Insert(" INSERT INTO answer(question_id, user_id, answer)" +
            " VALUES (#{questionId}, #{userId}, #{answer} )")
    int saveAnswer(Answer answer);

    /**
     * Gets answer by id.
     *
     * @param questionId the question id
     * @param userId     the user id
     * @return the answer by id
     */
    @Select(" SELECT answer.question_id, answer.user_id, answer.answer " +
            " FROM answer " +
            " WHERE question_id = #{questionId} AND user_id = #{userId};")
    Optional<Answer> getAnswerById(@Param("questionId") Long questionId,
                                  @Param("userId") Long userId);

    /**
     * Gets all answer by question.
     *
     * @param questionId the question id
     * @return the all answer by question
     */
    @Select(" SELECT answer.question_id, answer.user_id, answer.answer " +
            " FROM answer " +
            " WHERE question_id = #{questionId};")
    List<Answer> getAllAnswerByQuestion(@Param("questionId") Long questionId);

}
