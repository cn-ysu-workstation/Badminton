package cn.yd.badminton.po;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class PageBean<T> {
	
	private PageInfo<T> info;
	private List<T> beanList;
	private String url;//搜索条件
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public PageInfo<T> getInfo() {
		return info;
	}
	public void setInfo(PageInfo<T> info) {
		this.info = info;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
	
}
