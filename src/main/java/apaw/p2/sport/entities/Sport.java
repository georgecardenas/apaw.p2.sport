package apaw.p2.sport.entities;

public class Sport {

    private int id;

    private String name;
    

    public Sport() {
    }

    public Sport(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + "]";
	}

}
