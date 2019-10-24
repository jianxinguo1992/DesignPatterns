package ChainOfResponsibility.upgrade;

import java.util.List;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-29 11:17
 **/
public class HaveBreakfastFilter implements StudyPrepareFilter {

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain, List<String> resultList) {
        if (preparationList.isHaveBreakfast()) {
            System.out.println("吃完早饭");
            resultList.add("吃完早饭了了了");
        }
        filterChain.doFilter(preparationList, filterChain, resultList);

     }
}
