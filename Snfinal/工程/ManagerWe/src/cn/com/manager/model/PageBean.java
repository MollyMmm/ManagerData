package cn.com.manager.model;

import java.util.List;
import java.util.Map;

public class PageBean {
	private int currentPage = 1;	//当前页,默认值=1
	private int totalPage = 1;			//总页数, 根据记录的总条数决定
	private int pageSize = 10;		//每页显示的记录数

	private int total = 0;				//总个数
	private String sql;				//原生sql语句
	private List<Map<String, Object>> list;		//承装页面内容的容器
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int count) {
		this.total = count;
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
	public void setTotalPage(int count) {
		this.totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = "select t1.* from (select t.* , rownum as r  from ("+ sql +") t where rownum <= "+ (currentPage * pageSize) +") t1 where r >= "+ ((currentPage - 1) * pageSize + 1) +"";
	}
	public void setNullsSql() {
		this.sql = "--";
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
}
