package gajanan.ShopOn.repository;

import gajanan.ShopOn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product ,Integer>
{
  List<Product> findByName(String productName);
//  List<Product> findByNameAndPrice(String productName,int productPrice);
//  @Query("SELECT  p FROM Product p where p.name=:productName And p.price=:productPrice")
//          List<Product> findByNameAndPrice(@Param("productName") String productName, @Param("productPrice")int productPrice);

    @Query(value = "SELECT * FROM Product p WHERE p.name = :productName AND p.price = :productPrice", nativeQuery = true)
    List<Product> findByNameAndPrice(@Param("productName") String productName, @Param("productPrice") int productPrice);

}
