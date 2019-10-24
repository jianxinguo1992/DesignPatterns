package ChainOfResponsibility.upgrade;

import java.util.List;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-29 11:16
 **/
public class WashFaceFilter implements StudyPrepareFilter {
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain, List<String> resultList) {
        if (preparationList.isWashFace()) {
            System.out.println("洗完脸");
            resultList.add("洗完脸乐乐乐乐乐饿了");
         }

        filterChain.doFilter(preparationList, filterChain, resultList);
    }
}
