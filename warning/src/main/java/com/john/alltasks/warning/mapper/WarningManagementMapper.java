package com.john.alltasks.warning.mapper;

import com.john.alltasks.warning.models.Warning;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WarningManagementMapper {

    void saveWarning(@Param("warning") Warning warning);

    void removeWarning(@Param("id") Long id);

    void updateWarning(@Param("warning") Warning warning);

    List<Warning> queryWarningByTenant(@Param("tenant") String tenant);

    Warning queryWarningByOwner(@Param("owner") String owner, @Param("name") String name);
}
