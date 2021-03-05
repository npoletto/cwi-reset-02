package br.com.cwi.resetflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioDesocupadoException extends RuntimeException {

    public UsuarioDesocupadoException(final String statusText) {
        super(statusText);
    }
}
