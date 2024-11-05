package AppDto;

public class PersonDto {
    private long id;
    private long Cedula;
    private String name;
    private long celphone;

    public PersonDto() {}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCedula() {
        return Cedula;
    }

    public void setCedula(long Cedula) {
        this.Cedula = Cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCelphone() {
        return celphone;
    }

    public void setCelphone(long celphone) {
        this.celphone = celphone;
    }

}

