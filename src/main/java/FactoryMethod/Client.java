package FactoryMethod;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-12 17:49
 **/
public class Client {

    public static void main(String[] args) {
        //创建需要使用的Creator对象
        ExportOperate operate = new ExportOperate();
        //调用输出数据的功能方法，传入选择到处类型的参数
        operate.export(1,"测试数据");
    }
}
