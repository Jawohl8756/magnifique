package com.wunderbar.BuildModel.BuilderPattern;

import lombok.*;

/**
 * @author Rommel
 * @date 2020/3/14 10:52
 * @description 要组建的 Computer对象实体类
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    /**
     * CPU
     */
    private String cpu;
    /**
     * 内存
     */
    private String memory;
    /**
     * 硬盘
     */
    private String disk;
}
