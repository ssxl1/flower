package com.ypf.cn.util;

public class PageUtil {
	private int pageSize ;//页的大小
	private int currentPage;//当前页的编号
	private int totalSize;// 设置总数据数量
	private int totalPage; 	// ͨ计算出页的总数
	private int startPos;// 开始位置从第几条数据开始查询
	private int max;
	private int min;
	
	public void setTotalSize(int totalSize) {
		// 设置总数据数量
		this.totalSize = totalSize;
		// ͨ计算出页的总数
		this.totalPage = this.totalSize % this.pageSize == 0 ? this.totalSize
				/ this.pageSize : (this.totalSize / this.pageSize + 1);
		// 对当前页的编号进行判断
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
	}
	
	
	public int getStartPos() {
		return (currentPage-1)*pageSize;
	}


	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
