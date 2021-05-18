package com.fabrique.system.dao;

import com.fabrique.system.entity.Pool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Pool mapper.
 */
@Mapper
@Repository
public interface PoolMapper {

    /**
     * Save pool int.
     *
     * @param pool the pool
     * @return the int
     */
    int savePool(Pool pool);

    /**
     * Gets pool by id.
     *
     * @param poolId the pool id
     * @return the pool by id
     */
    Optional<Pool> getPoolById(@Param("poolId") Long poolId);

    /**
     * Gets all pools.
     *
     * @return the all pools
     */
    List<Pool> getAllPools();

    /**
     * Update pool int.
     *
     * @param pool the pool
     * @return the int
     */
    int updatePool(Pool pool);
}
