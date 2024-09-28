package com.gwnu.mybatis.chap03.sub01.using_interface.model.service;

import com.gwnu.mybatis.chap03.sub01.using_interface.model.dao.DepartmentMapper;
import com.gwnu.mybatis.chap03.sub01.using_interface.model.dao.EmployeeMapper;
import com.gwnu.mybatis.chap03.sub01.using_interface.model.dto.DepartmentDto;
import com.gwnu.mybatis.chap03.sub01.using_interface.model.dto.EmployeeDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.gwnu.mybatis.chap03.sub01.using_interface.common.Template.getSqlSession;

public class EmployeeService {
    // 부서의 목록을 조회해오는 로직 작성(select)
    public List<DepartmentDto> selectDepartmentList() {
        SqlSession session = getSqlSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);

        List<DepartmentDto> departmentList = mapper.selectDepartmentList();
        session.close();

        return departmentList;
    }

    public List<EmployeeDto> selectAllEmployeeList() {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        List<EmployeeDto> employeeList = mapper.selectAllEmployeeList();
        session.close();

        return employeeList;
    }

    public List<EmployeeDto> selectEmployeeList(String employeeName) {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        List<EmployeeDto> employeeList = mapper.selectEmployee(employeeName);
        session.close();

        return employeeList;
    }

    public int insertNewEmployee(EmployeeDto employeeDto) {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        // PreparedStatement를 사용한다.
        int result = 0; // 처리된 튜플의 개수가 반환된다.
        try {
            result = mapper.insertEmployee(employeeDto);
            session.commit(); // 수행 완료 시 커밋
        } catch(Exception e) {
            session.rollback(); // 수행 실패 시 롤백하여 쿼리 취소
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

        return result;
    }

    public int updateEmployee(EmployeeDto employeeDto) {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        int result = 0;
        try {
            result = mapper.update_Employee(employeeDto);
            session.commit();
        } catch(Exception e) {
            System.out.println("error");
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

        return result;
    }

    public int deleteEmployee(Long employeeId) {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        int result = 0;
        try {
            result = mapper.delete_Employee(employeeId);
            session.commit();
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

        return result;
    }

//    public int updateNewEmployee(EmployeeDto employeeDto) {
//        SqlSession session = getSqlSession();
//        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
//
//        int result = 0;
//    }
}
