package com.fabrique.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Question dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    /**
     * Identifier of the question.
     */
    private Long questionId;

    /**
     * Text of the question.
     */
    private String questionText;

    /**
     * Identifier of type of the question.
     */
    private Long questionType;

    /**
     * Identifier of the pool.
     */
    private Long poolId;
}
