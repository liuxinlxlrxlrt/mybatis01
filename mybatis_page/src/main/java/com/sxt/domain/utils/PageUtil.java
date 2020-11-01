package com.sxt.domain.utils;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {
    public static int getStartDataNum(int pageSize, int currentPage) {
        int startDateNum = 0;
        startDateNum = pageSize * (currentPage - 1);
        if (startDateNum < 0) {
            startDateNum = 0;
        }
        return startDateNum;
    }

    public static int getEndDateNum(int pageSize, int currentPage, int totalDateNum) {
        int endDateNum = 0;
        endDateNum = pageSize * currentPage;
        if (endDateNum > totalDateNum) {
            endDateNum = totalDateNum;
        }
        return endDateNum;
    }

    public static int getTotalPageNum(int pageSize, int totalDateNum) {
        int totalPageNum = 0;
        if (totalDateNum % pageSize == 0) {
            totalDateNum = totalDateNum / pageSize;
        } else {
            totalPageNum = totalDateNum / pageSize + 1;
        }

        if (totalPageNum == 0) {
            totalPageNum = 1;
        }
        return totalPageNum;
    }

    public static List<Integer> getShowPages(int currentPage, int totalPageNum) {
        List<Integer> showPageList = new ArrayList<>();

        if (currentPage % 5 == 0) {
            for (int i = (currentPage - 4); i <= currentPage; i++) {
                showPageList.add(i);
            }
        } else {
            int start = currentPage / 5 * 5 + 1;
            int end = (start + 4) > totalPageNum ? totalPageNum : (start + 4);
            for (int i = start; i <= end; i++) {
                showPageList.add(i);
            }
        }
        return showPageList;
    }

    //查询类中的“构造方法"
//    public static void query(Integer pageSize,int pageNo){
//        if(pageSize!=null&&pageNo!=null){
//            this.pageNo = PageUtil.getStartDataNum();
//        }
//        if(pageSize!=null){
//            this.pageSize=pageSize;
//        }
//    }
}
