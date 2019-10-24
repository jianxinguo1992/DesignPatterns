package Decorator;

import java.util.Date;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-25 21:35
 **/
public class Decorator extends Component {

    /**
     * 持有被装饰的组件对象
     */
    protected Component c;
    /**
     * 通过构造方法传入被装饰的对象
     * @param c
     */
    public Decorator(Component c){
        this.c = c;
    }
    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //转调组件对象的方法
        return c.calcPrize(user, begin, end);
    }
}
