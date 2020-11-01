package com.sxt.domain.utils;

public class PageBean {
    private Integer currentPage;
    private Integer pageSize=5;
    private Integer totalCount;
    private Integer totalPage;
    private Integer startIndex;


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        this.startIndex = (this.currentPage-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        //计算总页面
        //Math.ceil()  “向上取整”， 即小数部分直接舍去，并向正数部分进1
        this.totalPage=(int)Math.ceil((this.totalCount*1.0/this.pageSize));
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }
}
