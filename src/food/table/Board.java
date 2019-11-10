package food.table;


public class Board {

	protected int bno;
	protected String title;
	protected String contents;
	protected String id;
	protected int views;
	protected String created;
	
	public int getBno() {
		return bno;
	}
	public Board setBno(int bno) {
		this.bno = bno;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Board setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContents() {
		return contents;
	}
	public Board setContents(String contents) {
		this.contents = contents;
		return this;
	}
	public String getId() {
		return id;
	}
	public Board setId(String id) {
		this.id = id;
		return this;
	}
	public int getViews() {
		return views;
	}
	public Board setViews(int views) {
		this.views = views;
		return this;
	}
	public String getCreated() {
		return created;
	}
	public Board setCreated(String created) {
		this.created = created;
		return this;
	}
	
}
