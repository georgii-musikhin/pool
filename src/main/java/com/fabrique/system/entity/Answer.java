package com.fabrique.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Answer.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    /**
     * Identifier of the question.
     */
    private Long questionId;

    /**
     * Identifier of the user.
     */
    private Long userId;

    /**
     * Text of the answer.
     */
    private String answer;
}
