package FactoryMethod;

/**
 * @author JIANXIN.GUO
 * @date 2019-03-12 17:15
 **/
public class ExportTxtFile implements ExportFileApi {
    public boolean export(String data) {
        //简单示意一下，这里需要操作文件
        System.out.println("导出数据"+data+"到文本文件");
        return true;
    }
}
