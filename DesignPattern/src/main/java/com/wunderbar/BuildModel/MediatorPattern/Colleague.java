package com.wunderbar.BuildModel.MediatorPattern;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 14:56
 * @description
 */

@Setter
@Getter
@Slf4j
public abstract class Colleague {

    Mediator mediator ;

    public abstract boolean operation(String message);
}
