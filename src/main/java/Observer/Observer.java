package Observer;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-25 15:38
 **/
public interface Observer {

    /**
     * 更新的接口
     * @param subject 传入目标对象，好获取相应的目标对象的状态
     */
    public void update(Subject subject);
}
