package demo.app.bank.payment.charge.exception.handler;

import demo.app.bank.payment.charge.exception.DuplicateChargeEntryException;
import demo.app.bank.payment.charge.exception.NoSuchChargeException;
import demo.app.bank.payment.charge.model.error.ApplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalChargeExceptionHandler {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(NoSuchChargeException.class)
  public @ResponseBody ApplicationError handleWhenChargeIsNotFound(NoSuchChargeException noSuchChargeException) {
    return ApplicationError.of(HttpStatus.BAD_REQUEST.value(), noSuchChargeException.getMessage());
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(DuplicateChargeEntryException.class)
  public @ResponseBody ApplicationError handleWhenDuplicateEntryIsOccured(DuplicateChargeEntryException duplicateChargeEntryException) {
    return ApplicationError.of(HttpStatus.CONFLICT.value(), duplicateChargeEntryException.getMessage());
  }
}
