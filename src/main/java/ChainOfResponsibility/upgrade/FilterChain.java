package ChainOfResponsibility.upgrade;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-29 11:10
 **/
public class FilterChain implements StudyPrepareFilter {

    private int pos = 0;


    private List<StudyPrepareFilter> studyPrepareFilterList;



    public void addFilter(StudyPrepareFilter studyPrepareFilter) {
        if (studyPrepareFilterList == null) {
            studyPrepareFilterList = new ArrayList<StudyPrepareFilter>();
        }

        studyPrepareFilterList.add(studyPrepareFilter);
    }

    @Override
    public void doFilter(PreparationList thingList, FilterChain filterChain, List<String> resultList) {
        // 所有过滤器执行完毕
        if (pos == studyPrepareFilterList.size()) {
            return;
        }

        studyPrepareFilterList.get(pos++).doFilter(thingList, filterChain,resultList);
    }

}
