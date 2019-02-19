package tododo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String contents;
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setContents(String contents) {
		this.contents=contents;
	}
	
	public String getContents() {
		return contents;
	}
}
