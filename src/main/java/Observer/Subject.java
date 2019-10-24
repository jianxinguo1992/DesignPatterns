package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-25 15:37
 **/
public class Subject {

    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> observers = new ArrayList<Observer>();
    /**
     * 注册观察者对象
     * @param observer 观察者对象
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }
    /**
     * 删除观察者对象
     * @param observer 观察者对象
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    /**
     * 通知所有注册的观察者对象
     */
    protected void notifyObservers() {
        for(Observer observer : observers){
            observer.update(this);
        }
    }
}
