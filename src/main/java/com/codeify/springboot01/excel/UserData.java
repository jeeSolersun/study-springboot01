package com.codeify.springboot01.excel;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author codeify
 * @since 2021/10/21 00:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @ExcelProperty(value = "id")
    private String id;

    @ExcelProperty(value = "name")
    private String name;

    @ExcelProperty(value = "age")
    private Integer age;
}
