package Decorator;

import java.util.Date;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-25 21:34
 **/
public class ConcreteComponent extends Component {
    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //只是一个默认的实现，默认没有奖金
        return 0;
    }


}
