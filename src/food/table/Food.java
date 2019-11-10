package food.table;

public class Food {
	protected String fname;
	protected String kind;
	protected String material;
	
	public String getFname() {
		return fname;
	}
	public Food setFname(String fname) {
		this.fname = fname;
		return this;
	}
	public String getKind() {
		return kind;
	}
	public Food setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public String getMaterial() {
		return material;
	}
	public Food setMaterial(String material) {
		this.material = material;
		return this;
	}

}
