package com.codeify.springboot01.exercise.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author codeify
 * @since 2023/10/09 19:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Row {
    public String type;
    public String number;


    public static Map<String, List<Row>> groupByTypeAndSortNumber(List<Row> rows) {
        return rows.stream().collect(Collectors.groupingBy(val -> val.getType(), Collectors.collectingAndThen(Collectors.toList(), val -> {
            Collections.sort(val , Comparator.comparing((Row row) -> row.getNumber()));
            return val;
        })));
    }

    public static void main(String[] args) {
        List<Row> list = new ArrayList<>();
        list.add(new Row("a", "1"));
        list.add(new Row("a", "2"));
        list.add(new Row("b", "4"));
        list.add(new Row("b", "3"));
        Map<String, List<Row>> res = groupByTypeAndSortNumber(list);
        System.out.println("res = " + res);
    }
}
