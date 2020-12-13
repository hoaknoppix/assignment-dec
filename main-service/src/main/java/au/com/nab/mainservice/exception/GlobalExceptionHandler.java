package au.com.nab.mainservice.exception;

import au.com.nab.mainservice.dto.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage<Object>> handleAllExceptions(Exception ex) {
        LOG.error("handleAllExceptions : {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorMessage<>("Something went wrong. Please contact Administrators!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TokenNotFoundException.class)
    public final ResponseEntity<ErrorMessage<Object>> handleTokenNotFoundException(TokenNotFoundException ex) {
        LOG.error("handleAllExceptions : {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorMessage<>("Token is not found with the input parameters"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VoucherServiceTimeoutException.class)
    public final ResponseEntity<ErrorMessage<Object>> handleVoucherReadTimeOutException(VoucherServiceTimeoutException ex) {
        LOG.error("handleAllExceptions : {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorMessage<>("The process is still on going, you will get the sms after"), HttpStatus.OK);
    }

}
