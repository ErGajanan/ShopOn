package gajanan.ShopOn.controller;

import gajanan.ShopOn.dto.ProductRequestDTO;
import gajanan.ShopOn.dto.ProductResponseDTO;
import gajanan.ShopOn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public String addProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {

        return productService.addProduct(productRequestDTO);
    }
    @GetMapping("/getAllProducts")
    public List<ProductResponseDTO> getAllProducts()
    {
        return productService.getAllProducts();
    }
    @GetMapping("/search/{productName}")
    public List<ProductResponseDTO> searchProduct(@PathVariable String productName)
    {
        return productService.searchProduct(productName);
    }
    @GetMapping("/search")
    public List<ProductResponseDTO> searchProductByNameAndPrice(@RequestParam String productName,@RequestParam  int productPrice)
    {
        return productService.searchByNameAndPrice(productName,productPrice);
    }
    @DeleteMapping("/delete/{productName}")
    public String deleteProduct(@PathVariable String productName)
    {
        return productService.deleteProduct(productName);
    }

    @DeleteMapping("/deleteAllProducts")
    public String deleteProducts()
    {
        return productService.deleteAllProducts();
    }
  @PutMapping("/updateProduct/{productName}")
    public String updateAllProduct(@RequestBody ProductRequestDTO productRequestDTO, String productName)
  {
      return  productService.updateAllProduct(productRequestDTO,productName);
  }

  @PatchMapping("/patchProduct/{productName}")
    public String patchUpdate(@PathVariable  String productName,@RequestParam int productPrice)
  {
      return productService.patchProduct(productName,productPrice);
  }

}
