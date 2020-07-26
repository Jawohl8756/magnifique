装饰者模式(Decorator Pattern)，是指在不改变原有类和类的继承关系的前提下，动态扩展一个类的功能。
它通过装饰者来包裹真实的对象，并动态的向对象添加或者撤销功能。

//接口
public interface Sourceable{
//生产电脑的方法
void createComputer();
}

//真实类Source 继承接口，实现生产电脑的方法，但是不便于实现安系统的方法，让装饰者去实现
public class Source implements Sourceable{

@Override
public void createComputer(){

System.out.println("create computer by Source");
}
}

//装饰者类
public class Decorator implements Sourceable{

//注入引用真实对象Source
private Source source ;

public Decorator(Sourceable source){
this.source =source ;
}


@Override
public void createComputer(){//装饰者实现的接口方法，内部
source.createComputer();//内部还是调用真实者的方法

System.out.println("make system");//按系统

}
}


public class DecoratorPatternDemo{

public static void main(String[] args){
Sourceable source =new Source();
Sourceable decorator=new Decorator(source);//声明装饰者，传入真实对象
decorator.createComputer();


}

}