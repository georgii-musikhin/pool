package com.fabrique.system.dao;

import com.fabrique.system.entity.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface QuestionMapper {

    @Insert("INSERT INTO user_id(user_id) VALUES(#{userId})")
    void save(Question question);

    @Select("SELECT * FROM question WHERE question.question_id = #{questionId}")
    Optional<Question> getById(Long questionId);
}
