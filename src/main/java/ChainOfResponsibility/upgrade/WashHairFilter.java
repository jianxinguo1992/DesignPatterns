package ChainOfResponsibility.upgrade;

import java.util.List;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-29 11:16
 **/
public class WashHairFilter implements StudyPrepareFilter {
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain, List<String> resultList) {
        if (preparationList.isWashHair()) {
            System.out.println("洗完头发");
            resultList.add("洗完头发乐乐乐乐乐饿了");
        }
        filterChain.doFilter(preparationList, filterChain, resultList);
    }
}
