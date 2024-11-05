package AppDto;

public class UserDto {
    private long id;
    private PersonDto personId;
    private String Username;
    private String Rol;
    private String password;

    
    
    public UserDto() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public PersonDto getPersonId() {
        return personId;
    }

    public void setPersonId(PersonDto personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "UserDto{" + "id=" + id + ", personId=" + personId + ", Username=" + Username + ", Rol=" + Rol + ", password=" + password + '}';
    }

   
}
