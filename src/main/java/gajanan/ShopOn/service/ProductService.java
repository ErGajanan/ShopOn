package gajanan.ShopOn.service;

import gajanan.ShopOn.dto.ProductRequestDTO;
import gajanan.ShopOn.dto.ProductResponseDTO;
import gajanan.ShopOn.entity.Product;
import gajanan.ShopOn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService
{
    @Autowired
    ProductRepository productRepository;

    public String addProduct(ProductRequestDTO productRequestDTO)
    {

        Product products=new Product();
        products.setName(productRequestDTO.getName());
        products.setLocation(productRequestDTO.getLocation());
        products.setPrice(productRequestDTO.getPrice());
         productRepository.save(products);
        return "Product added successfully";
    }
    @Cacheable(value="getAllProducts")
    public List<ProductResponseDTO> getAllProducts()
    {
        List<ProductResponseDTO> productResponseDTOs=new ArrayList<>();
             List<Product> products=productRepository.findAll();
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
             for(Product product:products)
             {

                 productResponseDTO.setName(product.getName());
                 productResponseDTO.setPrice(product.getPrice());
                 productResponseDTO.setLocation(product.getLocation());
                 productResponseDTOs.add(productResponseDTO);
             }
             return productResponseDTOs;
    }
    @Cacheable(value="searchProduct")

    public List<ProductResponseDTO> searchProduct(String productName)
    {
             List<Product> products=productRepository.findByName(productName);
             List<ProductResponseDTO> productResponseDTOS=new ArrayList<>();
             for(Product product:products)
             {
                 ProductResponseDTO productResponseDTO=new ProductResponseDTO();
                 productResponseDTO.setName(product.getName());
                 productResponseDTO.setPrice(product.getPrice());
                 productResponseDTO.setLocation(product.getLocation());
                 productResponseDTOS.add(productResponseDTO);
             }
             return productResponseDTOS;
    }
    public List<ProductResponseDTO> searchByNameAndPrice(String productName,int productPrice)
    {
        List<ProductResponseDTO> productResponseDTO=new ArrayList<>();
                ProductResponseDTO productResponseDTO1=new ProductResponseDTO();
                List<Product> product=productRepository.findByNameAndPrice(productName,productPrice);
                for(Product product1:product)
                {
                    productResponseDTO1.setName(product1.getName());
                    productResponseDTO1.setPrice(product1.getPrice());
                    productResponseDTO1.setLocation(product1.getLocation());
                    productResponseDTO.add(productResponseDTO1);
                }
                return productResponseDTO;
    }
     public String deleteProduct(String productName)
     {
              List<Product> products=productRepository.findByName(productName);
              for(Product product:products)
              {
                  productRepository.delete(product);
              }
              return "Product deleted successfully";
     }
     public String deleteAllProducts()
     {
         productRepository.deleteAll();
         return "All Products Deleted Successfully";
     }
     public String updateAllProduct(ProductRequestDTO productRequestDTO,String productName)
     {
          List<Product> products= productRepository.findByName(productName);
          for(Product product:products)
          {
              product.setPrice(productRequestDTO.getPrice());
              product.setLocation(productRequestDTO.getLocation());
              productRepository.save(product);
          }
          return "product updated sussessfully";
     }
     public String patchProduct(String productName,int productPrice)
     {
           List<Product> product=productRepository.findByName(productName);
             for(Product p:product)
             {
                 p.setPrice(productPrice);
                 productRepository.save(p);
             }
             return "product patched successfully";
     }
}
