package com.wunderbar.BuildModel.FlyweightPattern;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Rommel
 * @date 2020/3/14 20:54
 * @description 批量生产内存的工厂方法
 */
@Slf4j
public class MemoryFactory {

    //生产的内存对象放入list
    private static List<Memory> memoryList = new ArrayList<Memory>();

    public static Memory getMemory(int size) {//特定大小的内存，单位MB
        Memory memory = null;

        for (int i = 0; i < memoryList.size(); i++) {
            memory = memoryList.get(i);
            //如果存在和目标size一样大且未使用的内存，直接返回
            if (memory.getSize() == size && memory.isIssued() == false) {//没被占用
                memory.setIssued(true);//被占用了
                memoryList.set(i, memory);
                log.info("get memory from memoryList:" + JSON.toJSONString(memory));
                break;

            }


        }

        if (memory == null) {
            memory = new Memory(32, false, UUID.randomUUID().toString());
            log.info("create a new memory from system and add to memoryList:" + JSON.toJSONString(memory));
            memoryList.add(memory);//新建的内存，加入内存列表
        }

        return memory;


    }

    public static void releaseMemory(String id) {
        for (int i = 0; i < memoryList.size(); i++) {
            Memory memory = memoryList.get(i);
            //如果存在和需求size一样大小的并且未使用的内存，则直接返回
            if (memory.getId().equalsIgnoreCase(id)) {
                memory.setIssued(false);
                memoryList.set(i, memory);
                log.info("release memory:" + id);
                break;

            }
        }

    }

}


