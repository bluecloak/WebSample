package com.bluecloak.sample.multi.datasource.mybatis.entity;

import com.bluecloak.sample.multi.datasource.mybatis.type.DataType;
import lombok.Data;

@Data
public class SampleDataEntity {
    Long id = null;
    String name = null;
    DataType dataType = null;
}
