package com.fabrique.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * The type Pool dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoolDTO {

    /**
     * Identifier of the pool.
     */
    private Long poolId;

    /**
     * Name of the pool.
     */
    @NotNull
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
    @NotEmpty
    private List<QuestionDTO> questionList;
}
