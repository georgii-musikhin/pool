package com.fabrique.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type User.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * User id.
     */
    private Long userId;

    /**
     * User pools.
     */
    private List<Pool> pools;
}
