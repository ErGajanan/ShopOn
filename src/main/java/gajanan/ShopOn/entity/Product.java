package gajanan.ShopOn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;//here is changes are done...
    private String name;
    private int price;
    private String location;



}
