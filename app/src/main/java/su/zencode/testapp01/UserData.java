package su.zencode.testapp01;

public class UserData {
    private String name;
    private String patro;
    private String surname;

    public UserData(String name, String patro, String surname) {
        this.name = name;
        this.patro = patro;
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPatro(String patro) {
        this.patro = patro;
    }

    public String getPatro() {
        return patro;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }


}
