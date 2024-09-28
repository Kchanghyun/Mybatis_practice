package com.gwnu.mybatis.chap03.sub02.using_xml.model.Service;

import com.gwnu.mybatis.chap03.sub02.using_xml.model.dto.DepartmentDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {
    private DepartmentService departmentService;

    @BeforeEach
    void initializeDI() {
        departmentService = new DepartmentService();
    }

    @Test
    @DisplayName("전체 부서 목록 가져오기 테스트")
    void selectAllDepartmentsTest() {
        List<DepartmentDto> departmentDtos = departmentService.selectAllDepartments();

        System.out.println(departmentDtos);

        assertNotNull(departmentDtos);
    }

    @Test
    @DisplayName("신규 부서 추가 테스트")
    void insertNewDepartmentTest() {
        // 1. given : ~가 주어진다.
        String newDepartment = "운영팀";
        DepartmentDto newDepartmentDto = new DepartmentDto();
        newDepartmentDto.setDepartmentName(newDepartment);

        // 2. when : ~를 수행했을 때
        departmentService.insertNewDepartment(newDepartmentDto);

        System.out.println(departmentService.selectAllDepartments());
    }
}