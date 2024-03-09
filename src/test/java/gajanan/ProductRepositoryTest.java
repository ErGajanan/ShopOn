package gajanan;

import gajanan.ShopOn.dto.ProductResponseDTO;
import gajanan.ShopOn.entity.Product;
import gajanan.ShopOn.repository.ProductRepository;
import gajanan.ShopOn.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @Mock
    private ProductRepository mockProductRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void findProduct() {
        // Mocking the behavior of the productRepository for findByName
        when(mockProductRepository.findByName(any(String.class)))
                .thenReturn(createProduct());

        // Your test code
        List<ProductResponseDTO> result = productService.searchProduct("mouse");

        // Assertion
        assertEquals(1, result.size());
        assertEquals("mouse", result.get(0).getName());
        assertEquals("kolhapur", result.get(0).getLocation());
        assertEquals(20, result.get(0).getPrice());
    }

    private List<Product> createProduct() {
        Product product = new Product();
        product.setId(3);
        product.setName("mouse");
        product.setPrice(20);
        product.setLocation("kolhapur");
        return Collections.singletonList(product);
    }
}
