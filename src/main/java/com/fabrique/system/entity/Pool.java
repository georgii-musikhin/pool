package com.fabrique.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Pool.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pool {

    /**
     * Identifier of the pool.
     */
    private Long poolId;

    /**
     * Name of the pool.
     */
    private String name;

    /**
     * Start date of the pool.
     */
    private LocalDate createDate;

    /**
     * Finish date of the pool.
     */
    private LocalDate finishDate;

    /**
     * List of questions in the pool.
     */
    private List<Question> questionList;
}
