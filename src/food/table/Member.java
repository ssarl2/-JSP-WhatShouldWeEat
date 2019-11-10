package food.table;

public class Member {
	protected String id;
	protected String pw;
	protected int age;
	protected String sex;
	protected String selects;
	public String getId() {
		return id;
	}
	public Member setId(String id) {
		this.id = id;
		return this;
	}
	public String getPw() {
		return pw;
	}
	public Member setPw(String pw) {
		this.pw = pw;
		return this;
	}
	public int getAge() {
		return age;
	}
	public Member setAge(int age) {
		this.age = age;
		return this;
	}
	public String getSex() {
		return sex;
	}
	public Member setSex(String sex) {
		this.sex = sex;
		return this;
	}
	public String getSelects() {
		return selects;
	}
	public Member setSelects(String selects) {
		this.selects = selects;
		return this;
	}
	
}
