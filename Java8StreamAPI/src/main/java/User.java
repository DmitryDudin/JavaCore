public class User {
    enum UserrRole {ADMIN, USER, GUEST}

    private Long id;
    private String name;
    private UserrRole role;

    public User() {
    }

    public User(Long id, String name, UserrRole role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "[id=" + id + " name=" + name + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserrRole getRole() {
        return role;
    }

    public void setRole(UserrRole role) {
        this.role = role;
    }
}