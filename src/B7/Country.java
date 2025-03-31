package B7;

public class Country {
    private int id;
    private String name;
    private String code;

    public Country(int id,String code, String name ) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "[" +
                "ID: " + id +
                "| NAME: '" + name + '\'' +
                "| CODE: '" + code + '\'' +
                ']';
    }
}