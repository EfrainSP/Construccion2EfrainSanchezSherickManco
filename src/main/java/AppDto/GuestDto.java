
package AppDto;

public class GuestDto {
    private long id;
    private UserDto user;
    private PartnerDto Partner;
    private String Status;

    public GuestDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PartnerDto getPartner() {
        return Partner;
    }

    public void setPartner(PartnerDto Partner) {
        this.Partner = Partner;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    
}
