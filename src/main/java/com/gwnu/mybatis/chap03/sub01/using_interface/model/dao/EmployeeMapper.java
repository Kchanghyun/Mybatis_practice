package com.gwnu.mybatis.chap03.sub01.using_interface.model.dao;

import com.gwnu.mybatis.chap03.sub01.using_interface.model.dto.EmployeeDto;
import org.apache.ibatis.annotations.*;

import java.util.List;


// UPDATE 테이블명 SET 컬럼1 = 수정값1 [, 컬럼2 = 수정값2 ...] [WHERE 조건];
// UPDATE table_name SET name = '테스트 변경', country = '대한민국' WHERE id = 1105;
// INSERT INTO 테이블명 [컬럼1, 컬럼2, ...] VALUES (값1, 값2, ...);
// DELETE FROM 테이블명 [WHERE 조건];
/*
SELECT 열 이름
	FROM 테이블 이름
    WHERE 조건식
    GROUP BY 열 이름
    HAVING 조건식
    ORDER BY 열 이름
    LIMIT 숫자
 */

// 애노테이션 바로 아래에 메소드 넣어야되는거였넹..
public interface EmployeeMapper {
    @Insert("insert into tbl_employee(emp_name, dept_id) values (#{employeeName}, #{departmentId})") // emp_name, dept_id => 데이터베이스 내 이름,
    int insertEmployee(EmployeeDto employeeDto);

    @Update("update tbl_employee set emp_name = #{employeeName}, dept_id = #{departmentId} where emp_id = #{employeeId}")
    int update_Employee(EmployeeDto employeeDto);

    @Delete("delete from tbl_employee where emp_id = #{employeeId}")
    int delete_Employee(Long employeeId);

    @Select("select * from tbl_employee")
    @Results(
            id="employeeResultMap", value = {
                    @Result(id = true, property = "employeeId", column = "emp_id"),
                    @Result(property = "employeeName", column = "emp_name"),
                    @Result(property = "departmentId", column = "dept_id")
    }
    )
    List<EmployeeDto> selectAllEmployeeList();

    @Select("select * from tbl_employee where emp_name = #{employeeName}")
    @Results(
            id="employeeResultMap2", value = {
            @Result(id = true, property = "employeeId", column = "emp_id"),
            @Result(property = "employeeName", column = "emp_name"),
            @Result(property = "departmentId", column = "dept_id")
    }
    )
    List<EmployeeDto> selectEmployee(String employeeName);
}
