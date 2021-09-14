package com.bluecloak.sample.multi.datasource.mybatis.mapper.primary;

import com.bluecloak.sample.multi.datasource.mybatis.entity.SampleDataEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrimaryMapper {
    void insertSampleData(SampleDataEntity data);
}
