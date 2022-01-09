package com.codeify.springboot01.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * @author codeify
 * @since 2021/10/21 01:03
 */
public class UserDataEventListener extends AnalysisEventListener<UserData> {
    @Override
    public void invoke(UserData data, AnalysisContext context) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
