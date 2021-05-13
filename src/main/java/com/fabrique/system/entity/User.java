package com.fabrique.system.entity;

import lombok.Data;

import java.util.List;

/**
 * The type User.
 */
@Data
public class User {

    /**
     * User id.
     */
    private Long id;

    /**
     * User pools.
     */
    private List<Pool> pools;
}
