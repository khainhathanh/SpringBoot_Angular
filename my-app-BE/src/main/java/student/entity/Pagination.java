package student.entity;

import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Pagination<T> {
	private List<T> content;
	private int totalPage;
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
