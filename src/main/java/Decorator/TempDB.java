package Decorator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-27 14:29
 **/
public class TempDB {
    private TempDB() {
    }
    /**
     * 记录每个人的月度销售额，只用了人员，月份没有用
     */
    public static Map<String,Double> mapMonthSaleMoney = new HashMap<String,Double>();

    static {
        //填充测试数据
        mapMonthSaleMoney.put("张三",10000.0);
        mapMonthSaleMoney.put("李四",20000.0);
        mapMonthSaleMoney.put("王五",30000.0);
    }
}
