package br.com.ideais.utils.web;

import java.util.List;

public class Pagination {
	private int page;

	private int pageSize;

	private int nearPagesRange;

	private Long itemCount;

	public int getFirstItemIndex() {
		return (getPage() - 1) * pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return (int) Math.ceil(getItemCount() / (double) pageSize);
	}

	public Long getItemCount() {
		return itemCount;
	}

	public int getPage() {
		if (page < 1)
			return 1;
		else if (page > getPageCount())
			return getPageCount();
		return page;
	}

	public boolean isLastPage() {
		return getPage() == getPageCount();
	}

	public boolean isFirstPage() {
		return getPage() == 1;
	}

	public boolean isNavigatorNeeded() {
		return getPageCount() > 1;
	}

	public boolean isEmptyResult() {
		return getItemCount() == 0;
	}

	public int getLowLimit() {

		int lowLimit = page - nearPagesRange;

		if (lowLimit < 1)
			return 1;

		return lowLimit;
	}

	public int getHighLimit() {

		if (page == 0)
			page = 1;

		int highLimit = page + nearPagesRange;

		if (highLimit > getPageCount())
			return getPageCount() == 0 ? 1 : getPageCount();

		return highLimit;
	}

	public int getPageUnchecked() {
		return page;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@SuppressWarnings("unchecked")
	public List slicePage(List list) {
		int offset = getFirstItemIndex();
		
		int size = getFirstItemIndex() + getPageSize();
		
		if(size > list.size()) {
		
			size = list.size();
		}
		
		return list.subList(offset, size);
	}

	public final int getCurrentPageSize() {
		return 0;
	};

	public void setNearPagesRange(int pageNumLimit) {
		this.nearPagesRange = pageNumLimit;
	}

	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}
}
