package cn.com.manager.model;

import java.util.List;
import java.util.Map;

public class PageBean {
	private int currentPage = 1;	//��ǰҳ,Ĭ��ֵ=1
	private int totalPage = 1;			//��ҳ��, ���ݼ�¼������������
	private int pageSize = 10;		//ÿҳ��ʾ�ļ�¼��

	private int total = 0;				//�ܸ���
	private String sql;				//ԭ��sql���
	private List<Map<String, Object>> list;		//��װҳ�����ݵ�����
	
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
