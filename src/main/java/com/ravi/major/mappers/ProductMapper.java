package com.ravi.major.mappers;

import com.ravi.major.dto.requestentity.ProductAddRequest;
import com.ravi.major.dto.requestentity.ProductUpdateRequest;
import com.ravi.major.dto.responseentity.ProductResponseDto;
import com.ravi.major.exception.UserException;
import com.ravi.major.model.Merchant;
import com.ravi.major.model.Product;
import com.ravi.major.repository.ProductRepository;
import com.ravi.major.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductMapper {


    @Autowired
    private MerchantService merchantService;

    @Autowired
    private ProductRepository productRepository;

    public Product productRequestDtoToProduct(ProductAddRequest productRequestDto,int userId){

        Merchant merchant = merchantService.findMerchantByUserId(userId);
        if(Objects.isNull(merchant)){
            throw new UserException("You can't add product");
        }
        Product product = new Product();
        product.setMerchant(merchant);
        product.setPrice(productRequestDto.getPrice());
        product.setBrand(productRequestDto.getBrand());
        product.setQuantity(productRequestDto.getQuantity());
        product.setDescription(productRequestDto.getDescription());
        product.setName(productRequestDto.getProductName());
        product.setCategory(productRequestDto.getCategoryType());
        return product;
    }

    public ProductResponseDto ProductToProductResponseDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductName(product.getName());
        productResponseDto.setProductBrand(product.getBrand());
        productResponseDto.setCategory(product.getCategory());
        productResponseDto.setQuantity(product.getQuantity());
        return productResponseDto;

    }

    public Product productUpdateRequestToProduct(ProductUpdateRequest productUpdateRequest){
        Product product = productRepository.findById(productUpdateRequest.getId()).get();
        if(productUpdateRequest.getPrice()>0){
            product.setPrice(productUpdateRequest.getPrice());
        }
        if(productUpdateRequest.getQuantity()>0){
            product.setQuantity(productUpdateRequest.getQuantity());
        }
        return product;
    }

}
