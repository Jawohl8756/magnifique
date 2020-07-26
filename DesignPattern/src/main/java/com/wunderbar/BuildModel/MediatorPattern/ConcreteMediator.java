package com.wunderbar.BuildModel.MediatorPattern;

/**
 * @author Rommel
 * @date 2020/3/16 15:32
 * @description
 */
public class ConcreteMediator extends Mediator {
    public ConcreteMediator(Colleague colleagueTenant, Colleague colleagueLandlord) {
        super(colleagueTenant,colleagueLandlord );
    }

    public boolean notifyColleagueTenant(String message) {

        if(colleagueTenant!=null){
            return colleagueTenant.operation(message);

        }
        return false;
    }

    public boolean notifyColleagueLandlord(String message) {
        if(colleagueLandlord!=null){
            return colleagueLandlord.operation(message);

        }
        return false;
    }
}
