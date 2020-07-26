package com.wunderbar.BuildModel.MediatorPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/3/16 15:35
 * @description
 */

@Slf4j
public class MediaPatternDemo {

    public static void main(String[] args) {
        Colleague colleagueTenant = new ColleagueTenant();
        Colleague colleagueLandlord = new ColleagueLandlord();

        ConcreteMediator concreteMediator = new ConcreteMediator(colleagueTenant, colleagueLandlord);

        boolean result = concreteMediator.notifyColleagueTenant("想租2室一厅的房子么，超便宜的");

        if (result) {
            concreteMediator.notifyColleagueLandlord("租客对房子满意。。。");
        } else {
            concreteMediator.notifyColleagueLandlord("租客对地理位置不满意");
        }

    }
}
