package com.fabrique.system.entity;

import lombok.Data;

/**
 * The type Question.
 */
@Data
public class Question {

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
        FULL_QUESTION,
        /**
         * Closed question question type.
         */
        CLOSED_QUESTION,
        /**
         * Multiple choice question question type.
         */
        MULTIPLE_CHOICE_QUESTION
    }
}
