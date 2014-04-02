package com.mongo.util;

public class PageBean {
    
    public static final int PAGE_SIZE = 3;
    
    private int allPages;
    private int currentPage;
    private int allCount;
    private boolean hasNextPage;
    private boolean hasUpPage;
    public PageBean(int allCount,int curentPage){
        this.allCount = allCount;
        this.currentPage = curentPage;
        int allPage = allCount % PAGE_SIZE == 0 ? (allCount / PAGE_SIZE) : (allCount / PAGE_SIZE + 1);
        setAllPages(allPage);
        if(currentPage == 1){
            setHasUpPage(false);
        }else{
            setHasUpPage(true);
        }
        if(currentPage == 1){
            setHasUpPage(false);
        }else{
            setHasUpPage(true);
        }
        
        if(currentPage == allPage){
            setHasNextPage(false);
        }else{
            setHasNextPage(true);
        }
    }
    public int getAllCount() {
        return allCount;
    }
    public void setAllCount(int allCount) {
        this.allCount  =  allCount ;
    }
    public int getAllPages() {
        return allPages;
    }
    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public boolean isHasNextPage() {
        return hasNextPage;
    }
    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
    public boolean isHasUpPage() {
        return hasUpPage;
    }
    public void setHasUpPage(boolean hasUpPage) {
        this.hasUpPage = hasUpPage;
    }
    
    
}
