package gajanan.ShopOn.dto;

import lombok.Data;

@Data
public class ProductRequestDTO
{
    private int id;
    private String name;
    private int price;
    private String location;
}
