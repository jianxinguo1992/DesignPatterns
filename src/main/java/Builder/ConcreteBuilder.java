package Builder;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-15 14:21
 **/

/**
 * 具体的生成器实现对象
 */
public class ConcreteBuilder implements Builder{
    public void buildPart() {

    }

    /**
     * 生成器最终构建的产品对象
     */
    private Product resultProduct;
    /**
     * 获取生成器最终构建的产品对象
     * @return 生成器最终构建的产品对象
     */
    public Product getResult() {
        return resultProduct;
    }
}
