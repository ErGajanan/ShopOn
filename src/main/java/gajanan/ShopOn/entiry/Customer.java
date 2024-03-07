package gajanan.ShopOn.entiry;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Customer
{
    private int id;
    private String fname;
    private String lname;
    private String dob;
    private String phoneNumber;
    private String password;
    private String confirmPassword

}
