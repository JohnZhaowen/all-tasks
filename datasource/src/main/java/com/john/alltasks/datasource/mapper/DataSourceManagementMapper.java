package com.john.alltasks.datasource.mapper;

import com.john.alltasks.datasource.models.DataSourceListVO;
import com.john.alltasks.datasource.models.DataSourcePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DataSourceManagementMapper {

    void saveDataSource(@Param("dataSource") DataSourcePO dataSource);

    void removeDataSource(@Param("id") Long id, @Param("operator") String operator);

    void updateDataSource(@Param("dataSource") DataSourcePO dataSource);

    List<DataSourceListVO> queryDataSourceByTenant(@Param("tenant") String tenant);

    DataSourcePO queryDataSourceByOwner(@Param("owner") String owner, @Param("name") String name);
}
