package com.sxt.domain.utils;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable {

    private static final long serialVersionUID = -112561362681055398L;

    //每页显示记录条数
    private int pageSize;
    //当前第几页
    private int currentPage;
    //总页数
    private int totalPage;
    //总记录数
    private int totalRecord;
    //数据集合(要显示的数据)
    private  List<T> dataList;

    public Pager() {
        super();
    }

    public Pager(int pageNum, int pageSize, List<T> sourceList) {
        if (sourceList == null) {
            return;
        }

        //总记录条数
        this.totalRecord = sourceList.size();

        //每次显示多少条记录
        this.pageSize = pageSize;

        //获取总页数
        this.totalPage = this.totalRecord / this.pageSize;
        if (this.totalRecord % this.pageSize != 0) {
            this.totalPage = this.totalPage + 1;
        }

        //当前第几页数据
        this.currentPage= this.totalPage < pageNum?this.totalPage:pageNum;
//        if (this.totalPage < pageNum) {
//            this.currentPage = this.totalPage;
//        } else {
//            this.currentPage = pageNum;
//        }

        //起始索引
        int fromIndex = this.pageSize * (this.currentPage - 1);

        //结束索引
        int toIndex=this.pageSize * this.currentPage > this.totalRecord?this.totalRecord:this.pageSize * this.currentPage;
//        if (this.pageSize * this.currentPage > this.totalRecord) {
//            toIndex = this.totalRecord;
//        } else {
//            toIndex = this.pageSize * this.currentPage;
//        }
        this.dataList= sourceList.subList(fromIndex,toIndex);
    }

    public Pager(int pageSize, int currentPage, int totalPage, int totalRecord, List<T> dataList) {
        super();
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalRecord = totalRecord;
        this.dataList = dataList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
