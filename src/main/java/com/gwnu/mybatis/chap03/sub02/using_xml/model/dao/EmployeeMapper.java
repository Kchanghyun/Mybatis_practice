package com.gwnu.mybatis.chap03.sub02.using_xml.model.dao;

import com.gwnu.mybatis.chap03.sub02.using_xml.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeMapper {

    List<EmployeeDto> selectAllEmployee();

    int insertEmployee(EmployeeDto employeeDto);

    int deleteEmployee(EmployeeDto employeeDto);

    int updateEmployee(EmployeeDto employeeDto);
}
