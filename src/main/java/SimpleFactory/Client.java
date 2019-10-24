package SimpleFactory;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-12 15:09
 **/
public class Client {

    public static void main(String[] args) {
        //通过简单工厂来获取接口对象
        Api api = Factory.createApi(1);
        api.operation("正在使用简单工厂");
    }
}
