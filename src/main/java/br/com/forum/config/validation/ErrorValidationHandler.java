package br.com.forum.config.validation;

import br.com.forum.dto.ErrorFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorValidationHandler {
    @Autowired
    private MessageSource messageSource;


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorFormDto> handle(MethodArgumentNotValidException exception) {
        List<ErrorFormDto> erros = new ArrayList();

        List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();


        fieldErros.forEach(error -> {
            String mensagemError = this.messageSource.getMessage(error, LocaleContextHolder.getLocale());
            ErrorFormDto erro = new ErrorFormDto(error.getField(), mensagemError);

            erros.add(erro);
        });

        return erros;
    }


}
