package com.gwnu.mybatis.chap03.sub01.using_interface.model.dto;

import lombok.*;

// DTO(Data Transfer Object) - 데이터를 계층 간에 전송할 때 사용하는 객체. 로직 x, 데이터 전송에만 집중

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDto {
    private Long departmentId;
    private String departmentName;
}
