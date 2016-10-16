package apaw.p2.sport.entities;

public class User {

    private int id;

    private String nick;
    
    private String email;

    public User() {
    }

    public User(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", nick=" + nick + ", email=" + email + "]";
	}

}
