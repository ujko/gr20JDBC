package arrays;

public class Test {
    private int id;
    private String name;

    public Test() {

    }

    public Test setId(int id) {
        this.id = id;
        return this;
    }

    public Test setName(String name) {
        this.name = name;
        return this;
    }

    public Test(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
