package gajanan.ShopOn.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductResponseDTO implements Serializable
{
    private String name;
    private int price;
    private String location;
}
