package com.ravi.major.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MyControllerException {


    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ProductionError> handleProductException(ProductException productException) {
        ProductionError productionError = new ProductionError(productException.getMessage());

        return new ResponseEntity<ProductionError>(productionError, HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<UserError> handleUserException(UserException userException) {
        UserError userError = new UserError(userException.getMessage());
        return new ResponseEntity<UserError>(userError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoItemSelected.class)
    public ResponseEntity<ItemError> handleNoItemSelectionException(NoItemSelected noItemSelected) {
        ItemError itemError = new ItemError(noItemSelected.getMessage());
        return new ResponseEntity<ItemError>(itemError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<OrderError> handleOrderException(OrderException orderException)
    {
        OrderError orderError=new OrderError(orderException.getMessage());
        return  new ResponseEntity<OrderError>(orderError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MerchantException.class)
    public ResponseEntity<MerchantError> handleMerchantException(MerchantException exception){
        MerchantError merchantError = new MerchantError(exception.getMessage());
        return new ResponseEntity<MerchantError>(merchantError,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }


}
