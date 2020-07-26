package com.wunderbar.BuildModel.StatePattern;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rommel
 * @date 2020/3/16 13:10
 * @description 上下文状态
 */

@Setter
@Getter
public class Context {

    private AbstractState state ;

    public Context(AbstractState state) {
        this.state = state;
    }

    public void action(){
        this.state.action(this);
    }
}
