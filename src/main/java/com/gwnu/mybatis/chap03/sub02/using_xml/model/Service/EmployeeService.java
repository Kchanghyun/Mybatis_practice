package com.gwnu.mybatis.chap03.sub02.using_xml.model.Service;

import com.gwnu.mybatis.chap03.sub02.using_xml.model.dao.EmployeeMapper;
import com.gwnu.mybatis.chap03.sub02.using_xml.model.dto.EmployeeDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.gwnu.mybatis.chap03.sub02.using_xml.common.template.getSqlSession;

public class EmployeeService {

    public List<EmployeeDto> selectAllEmployee() {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<EmployeeDto> tmp = mapper.selectAllEmployee();
        session.close();
        return tmp;
    }

    public int insertEmployee(EmployeeDto employeeDto) {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        int result = mapper.insertEmployee(employeeDto);
        if (result > 0) session.commit();
        else session.rollback();

        session.close();

        return result;
    }

    public int deleteEmployee(EmployeeDto employeeDto) {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int result = mapper.deleteEmployee(employeeDto);

        if (result > 0) session.commit();
        else session.rollback();

        session.close();

        return result;
    }

    public int updateEmployee(EmployeeDto employeeDto) {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        int result = mapper.updateEmployee(employeeDto);
        if (result > 0) session.commit();
        else session.rollback();

        session.close();

        return result;
    }
}
