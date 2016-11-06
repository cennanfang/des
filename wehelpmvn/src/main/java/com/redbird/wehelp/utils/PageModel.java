package com.redbird.wehelp.utils;

import java.util.List;  

/**
 * 分页对象
 * @author cennanfang
 *
 * @param <T>
 */
public class PageModel<T> {  
  
    // 数据列表
    private List<T> list;  
      
    // 记录数
    private int totalRecords;  
      
    // 分页大小  
    private int pageSize;  
      
    // 页号
    private int pageNo;  
      
    public int getTotalPages() {  
        return (totalRecords + pageSize - 1) / pageSize;  
    }  
      
    public int getTopPageNo() {  
        return 1;  
    }  
      
    public int getPreviousPageNo() {  
        if (pageNo <= 1) {  
            return 1;  
        }  
        return pageNo - 1;  
    }  
      
    public int getNextPageNo() {  
        if (pageNo >= getBottomPageNo()) {  
            return getBottomPageNo();  
        }  
        return pageNo + 1;    
    }  
      
    public int getBottomPageNo() {  
        return getTotalPages();  
    }  
      
    public List<T> getList() {  
        return list;  
    }  
  
    public void setList(List<T> list) {  
        this.list = list;  
    }  
  
    public int getTotalRecords() {  
        return totalRecords;  
    }  
  
    public void setTotalRecords(int totalRecords) {  
        this.totalRecords = totalRecords;  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public int getPageNo() {  
        return pageNo;  
    }  
  
    public void setPageNo(int pageNo) {  
        this.pageNo = pageNo;  
    }  
}  

