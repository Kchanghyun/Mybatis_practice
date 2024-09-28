package com.gwnu.mybatis.chap03.sub02.using_xml.model.dto;

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
