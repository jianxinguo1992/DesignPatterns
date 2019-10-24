package Observer;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-25 15:37
 **/
public class ConcreteSubject extends Subject {

    /**
     * 示意，目标对象的状态
     */
    private String subjectState;
    public String getSubjectState() {
        return subjectState;
    }
    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        //状态发生了改变，通知各个观察者
        this.notifyObservers();
    }
}
