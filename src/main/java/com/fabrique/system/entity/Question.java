package com.fabrique.system.entity;

import lombok.Data;

/**
 * The type Question.
 */
@Data
public class Question {

    /**
     * Identifier of the question.
     */
    private Long questionId;

    /**
     * Text of the question.
     */
    private String questionText;

    /**
     * Type of the question.
     */
    private QuestionType questionType;

    /**
     * The enum Question type.
     */
    public enum QuestionType {
        /**
         * Full question question type.
         */
        FULL_QUESTION(0L),
        /**
         * Closed question question type.
         */
        CLOSED_QUESTION(1L),
        /**
         * Multiple choice question question type.
         */
        MULTIPLE_CHOICE_QUESTION(2L);

        private Long id;

        QuestionType(Long id) {
            this.id = id;
        }
    }
}
