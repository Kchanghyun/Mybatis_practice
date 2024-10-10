package com.gwnu.mybatis.chap03.sub02.using_xml.model.dao;

import com.gwnu.mybatis.chap03.sub02.using_xml.model.dto.DepartmentDto;

import java.util.List;

public interface DepartmentMapper {
    List<DepartmentDto> selectAllDepartments();

    int insertNewDepartment(DepartmentDto departmentDto);

    int deleteDepartment(DepartmentDto departmentDto);

    int updateDepartment(DepartmentDto departmentDto);
}
