package com.wunderbar.BuildModel.VisitorPattern;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author Rommel
 * @date 2020/3/16 14:03
 * @description
 */

@Slf4j
public class CEOVisitor implements Visitor {
    public void visit(ProjectElement element) {

        log.info("CEO visitor element");
        element.signature("CEO",new Date());
        log.info(JSON.toJSONString(element));

    }
}
