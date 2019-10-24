package ChainOfResponsibility.upgrade;

import java.util.List;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-29 11:10
 **/
public interface StudyPrepareFilter {

    public void doFilter(PreparationList preparationList, FilterChain filterChain, List<String> resultList);
}
