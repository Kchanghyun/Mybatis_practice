package com.gwnu.mybatis.chap01.connection;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {
    @Select("select curdate()")
    Date getCurrentDate();
}
