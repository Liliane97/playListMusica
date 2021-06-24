package digital.innovation.Musica.controlles;

import digital.innovation.Musica.dto.request.CantorDTO;
import digital.innovation.Musica.dto.response.MessageResponseDTO;
import digital.innovation.Musica.exception.CantorNotFoundException;
import digital.innovation.Musica.services.CantorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/musica")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControllerMusica {

    private  final CantorService cantorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create (@RequestBody @Valid CantorDTO cantorDTO) {
        return  cantorService.create(cantorDTO);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CantorDTO> listAll(){
        return cantorService.listAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CantorDTO findById(@PathVariable Long id) throws CantorNotFoundException {
        return cantorService.findById(id);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update (@PathVariable Long id, @RequestBody @Valid CantorDTO cantorDTO) throws CantorNotFoundException {
        return cantorService.update(id, cantorDTO);
    }
    @DeleteMapping("{/id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id) throws CantorNotFoundException {
        cantorService.delete(id);
    }
}
