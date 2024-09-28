package com.gwnu.mybatis.chap03.sub01.using_interface.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
    private Long employeeId;
    private String employeeName;
    private Long departmentId;
}
