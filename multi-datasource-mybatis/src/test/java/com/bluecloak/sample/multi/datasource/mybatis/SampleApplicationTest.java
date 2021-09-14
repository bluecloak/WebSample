package com.bluecloak.sample.multi.datasource.mybatis;

import com.bluecloak.sample.multi.datasource.mybatis.entity.SampleDataEntity;
import com.bluecloak.sample.multi.datasource.mybatis.mapper.primary.PrimaryMapper;
import com.bluecloak.sample.multi.datasource.mybatis.mapper.secondary.SecondaryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SampleApplicationTest {

    PrimaryMapper primaryMapper;
    SecondaryMapper secondaryMapper;

    @Test
    public void test() {
        SampleDataEntity data;

        data = new SampleDataEntity();
        data.setName("test1");
        primaryMapper.insertSampleData(data);

        data = new SampleDataEntity();
        data.setName("test2");
        primaryMapper.insertSampleData(data);
    }

    @Autowired
    public void setPrimaryMapper(PrimaryMapper primaryMapper) {
        this.primaryMapper = primaryMapper;
    }

    @Autowired
    public void setSecondaryMapper(SecondaryMapper secondaryMapper) {
        this.secondaryMapper = secondaryMapper;
    }
}
