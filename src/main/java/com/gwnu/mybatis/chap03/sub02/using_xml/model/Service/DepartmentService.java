package com.gwnu.mybatis.chap03.sub02.using_xml.model.Service;



import com.gwnu.mybatis.chap03.sub02.using_xml.model.dao.DepartmentMapper;
import com.gwnu.mybatis.chap03.sub02.using_xml.model.dto.DepartmentDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.gwnu.mybatis.chap03.sub02.using_xml.common.template.getSqlSession;

public class DepartmentService {
    public List<DepartmentDto> selectAllDepartments() {
        SqlSession sqlSession = getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        List<DepartmentDto> departmentDtos = mapper.selectAllDepartments();

        sqlSession.close();

        return departmentDtos;
    }

    // 새로운 부서 추가
    public int insertNewDepartment(DepartmentDto department) {
        SqlSession sqlSession = getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        int result = mapper.insertNewDepartment(department);

        if (result > 0) sqlSession.commit();
        else sqlSession.rollback();

        sqlSession.close();

        return result;
    }
}
