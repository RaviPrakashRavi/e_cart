package com.ravi.major.service;

import com.ravi.major.dto.requestentity.*;
import com.ravi.major.dto.responseentity.MerchantSignUpResponse;
import com.ravi.major.dto.responseentity.OrderViewDetail;
import com.ravi.major.dto.responseentity.ProductResponseDto;
import com.ravi.major.enums.OrderStatus;
import com.ravi.major.exception.MerchantException;
import com.ravi.major.exception.ProductException;
import com.ravi.major.exception.UserException;
import com.ravi.major.mappers.AddressMapper;
import com.ravi.major.mappers.MerchantMapper;
import com.ravi.major.mappers.OrderMapper;
import com.ravi.major.mappers.ProductMapper;
import com.ravi.major.model.*;
import com.ravi.major.repository.MerchantRepository;
import com.ravi.major.repository.OrderDetailsRepository;
import com.ravi.major.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderItemsServiceImpl orderItemsService;
    private Function<OrderItems, Order> O;

    public void saveMerchant(Merchant merchant) {
        merchantRepository.save(merchant);

    }

    public Merchant getMerchantByMerchantId(int merchantId) {

        Optional<Merchant> merchant = merchantRepository.findById(merchantId);
        if (merchant.isEmpty()) {
            throw new MerchantException("Merchant not found");
        }
        return merchant.get();
    }


    public void updateMerchant(MerchantUpdateRequest merchantUpdateRequest) {
        Merchant merchant = merchantMapper.merchantUpdateRequestDtoToMerchant(merchantUpdateRequest);
        merchantRepository.save(merchant);
    }

    public void deleteMerchantById(int merchantId) {
        merchantRepository.deleteById(merchantId);
    }

    public Merchant findMerchantByUserId(int userId) {
        Merchant merchant = merchantRepository.findMerchantByUserId(userId);
        if (Objects.isNull(merchant)) {
            throw new UserException("Sorry you can't add product,first sign up");
        }
        return merchant;
    }

    public ResponseEntity<MerchantSignUpResponse> signUpMerchant(MerchantSignUpRequest merchantDto) {
        User user = userRepository.findByUserName(merchantDto.getUserName());
        if (Objects.nonNull(user)) {
            throw new UserException("user already exists");
        }
        user = merchantMapper.merchantDtoToUser(merchantDto);
        User u = userRepository.save(user);
        MerchantSignUpResponse merchantSignUpResponse = merchantMapper.merchantDtoToMerchantSignUpResponse(merchantDto);
        return new ResponseEntity<>(merchantSignUpResponse, HttpStatus.ACCEPTED);
    }

    public List<ProductResponseDto> findProducts() {

        List<Product> products = productService.findAllProductOfMerchant();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        products.forEach(product -> {
            ProductResponseDto productResponseDto = productMapper.ProductToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        });
        return productResponseDtos;
    }

    public Merchant findMerchantById(int merchantId) {
        return merchantRepository.findById(merchantId).get();
    }

    public void addProduct(ProductAddRequest productRequestDto, int userId) {
        Product product = productMapper.productRequestDtoToProduct(productRequestDto, userId);
        productService.addProduct(product);
    }

    public void updateProduct(ProductUpdateRequest productUpdateRequest) {
        Product product = productMapper.productUpdateRequestToProduct(productUpdateRequest);
        productService.updateProduct(product);

    }

    public void addMerchantAddress(MerchantAddAddressRequest merchantAddressRequest, int userId) {

        Address address = addressMapper.merchantAddressRequestToAddress(merchantAddressRequest, userId);
        addressService.saveAddress(address);

    }

    public void updateAddress(MerchantUpdateAddressRequest merchantUpdateAddressRequest) {
        Address address = addressMapper.merchantUpdateAddressRequestToAddress(merchantUpdateAddressRequest);
        addressService.updateAddress(address);
    }

    public List<OrderViewDetail> viewOrders(int userId) {
        Merchant merchant = merchantRepository.findMerchantByUserId(userId);
        if (Objects.isNull(merchant)) {
            throw new UserException("Sorry!,You are not merchant");
        }
        Map<Order,List<OrderItems>> orderItems = orderDetailsRepository.findOrderItemsByMerchantIdAndStatus(merchant.getId(), OrderStatus.PLACED);

        System.out.println(orderItems);
//        if (orderItems.size() == 0) {
//            throw new ProductException("You don't have any order");
//        }
//        Map<Integer,List<OrderItems>>orderItem = new HashMap<>();
//        List<OrderViewDetail> orderViewDetails = new ArrayList<>();
//       orderItem= orderItems.stream().collect(Collectors.groupingBy(OrderItems::getCustomerId));
//
//      for(Integer key:orderItem.keySet()){
//          List<OrderItems> orderItems1 = orderItem.get(key);
//          OrderViewDetail orderViewDetail = orderMapper.orderItemsToOrderDetailView(orderItems1);
//          orderViewDetails.add(orderViewDetail);
//      }
//       //OrderViewDetail orderViewDetail = orderMapper.orderItemsToOrderDetailView();

        return new ArrayList<>();
    }

//    public void sendOrderItem(int userId) {
//        Merchant merchant = merchantRepository.findMerchantByUserId(userId);
//        int merchantId = merchant.getId();
//        List<OrderItems> items = orderDetailsRepository.findOrderItemsByMerchantIdandStatus(merchantId, OrderStatus.PLACED);
//        items.forEach(item -> {
//            if (item.getStatus().equals(OrderStatus.PLACED)) {
//                Product product = productService.getProductById(item.getProductId());
//                product.setQuantity(product.getQuantity() - item.getQuantity());
//                item.setStatus(OrderStatus.COMPLETED);
//                orderItemsService.updateOrderItem(item);
//                productService.updateProduct(product);
//            }
//        });
//    }

//    public void cancelOrder(int userId) {
//        Merchant merchant = merchantRepository.findMerchantByUserId(userId);
//        List<OrderItems> items = orderDetailsRepository.findOrderItemsByMerchantIdandStatus(merchant.getId(), OrderStatus.SUCCESS);
//        items.forEach(item -> item.setStatus(OrderStatus.CANCELED));
//        orderDetailsRepository.saveAll(items);
//    }
}

