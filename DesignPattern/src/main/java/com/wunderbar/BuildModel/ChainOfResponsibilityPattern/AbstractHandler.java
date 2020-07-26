package com.wunderbar.BuildModel.ChainOfResponsibilityPattern;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rommel
 * @date 2020/3/15 22:04
 * @description 抽象处理类
 */

@Getter
@Setter
public class AbstractHandler {

    private Handler handler;

}
