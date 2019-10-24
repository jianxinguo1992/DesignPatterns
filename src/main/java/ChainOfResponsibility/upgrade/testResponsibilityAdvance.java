package ChainOfResponsibility.upgrade;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-29 11:18
 **/
public class testResponsibilityAdvance {

    public static void main(String[] args) {
         PreparationList preparationList = new PreparationList();
         preparationList.setWashFace(true);
         preparationList.setWashHair(true);
         preparationList.setHaveBreakfast(true);


         StudyPrepareFilter washFaceFilter = new WashFaceFilter();
         StudyPrepareFilter washHairFilter = new WashHairFilter();
         StudyPrepareFilter haveBreakfastFilter = new HaveBreakfastFilter();

         FilterChain filterChain = new FilterChain();
         filterChain.addFilter(washFaceFilter);
         filterChain.addFilter(washHairFilter);
         filterChain.addFilter(haveBreakfastFilter);
         List<String> resultList = new ArrayList<String>();
         filterChain.doFilter(preparationList, filterChain, resultList);

         resultList.forEach(result ->{
              System.out.println(result);
         });
    }
}
