package com.fabrique.system.dao;

import com.fabrique.system.entity.Pool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface PoolMapper {

    int savePool(Pool pool);

    Optional<Pool> getPoolById(@Param("poolId") Long poolId);

    List<Pool> getAllPools();

    int updatePool(Pool pool);
}
