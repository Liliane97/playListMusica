package digital.innovation.Musica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CantorNotFoundException extends  Exception{

    public  CantorNotFoundException(Long id){
        super(String.format("Cantor com ID %s não encontrado!", id));
    }
}
