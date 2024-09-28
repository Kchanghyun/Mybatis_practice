package com.gwnu.mybatis.chap03.sub01.using_interface.model.dao;

import com.gwnu.mybatis.chap03.sub01.using_interface.model.dto.DepartmentDto;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// DAO(Data Access Object) - 데이터베이스의 상호작용을 담당하는 객체. CRUD 작업을 추상화한다.
public interface DepartmentMapper {
    @Select("select * from tbl_department")
    @Results(
            id="departmentResultMap", value = {
                    @Result(id = true, property = "departmentId", column = "dept_id"),
                    @Result(property = "departmentName", column = "dept_name")
    }
    )
    List<DepartmentDto> selectDepartmentList();
}
