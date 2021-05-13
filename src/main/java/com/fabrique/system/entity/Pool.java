package com.fabrique.system.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Pool.
 */
@Data
@RequiredArgsConstructor
public class Pool {

    /**
     * Name of the pool.
     */
    private String name;

    /**
     * Start date of the pool.
     */
    private final LocalDate createDate;

    /**
     * Finish date of the pool.
     */
    private LocalDate finishDate;

    /**
     * List of questions in the pool.
     */
    private List<Question> questionList;
}
