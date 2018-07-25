package cn.cj.util;

/**
 * Created by cj on 2018/6/23.
 */
public class DoPage {
    private static final int NUM=5;
    public static int getPages(int totalRows){
        return totalRows%NUM==0?totalRows/NUM :totalRows/NUM + 1;
    }
}
