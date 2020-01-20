package com.john.alltasks.warning.mapper;

import com.john.alltasks.warning.models.WarningListVO;
import com.john.alltasks.warning.models.WarningPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WarningManagementMapper {

    void saveWarning(@Param("warning") WarningPO warning);

    void removeWarning(@Param("id") Long id, @Param("operator") String operator);

    void updateWarning(@Param("warning") WarningPO warning);

    List<WarningListVO> queryWarningByTenant(@Param("tenant") String tenant);

    WarningPO queryWarningByOwner(@Param("owner") String owner, @Param("name") String name);
}
