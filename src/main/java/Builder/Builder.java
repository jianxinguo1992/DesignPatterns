package Builder;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-15 14:20
 **/

/**
 * 生成器接口，定义创建一个产品对象所需的各个部件的操作
 */
public interface Builder {

    /**
     * 示意方法，构建某个部件
     */
    public void buildPart();
}
