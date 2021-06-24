package digital.innovation.Musica.services;

import digital.innovation.Musica.dto.mapper.CantorMapper;
import digital.innovation.Musica.dto.request.CantorDTO;
import digital.innovation.Musica.dto.response.MessageResponseDTO;
import digital.innovation.Musica.entities.Cantor;
import digital.innovation.Musica.exception.CantorNotFoundException;
import digital.innovation.Musica.repositories.CantorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CantorService {

    private final CantorRepository cantorRepository;

    private final CantorMapper cantorMapper;

    public MessageResponseDTO create (CantorDTO cantorDTO) {
        Cantor cantor = cantorMapper.toModel(cantorDTO);
        Cantor savedCantor = cantorRepository.save(cantor);

        MessageResponseDTO messageResponse = createMessageResponse("Cantor e música adicionado com sucesso ID: ",savedCantor.getId());

        return messageResponse;
    }
    public List<CantorDTO> listAll(){
        List<Cantor> cantores = cantorRepository.findAll();
        return cantores.stream()
                .map(cantorMapper::toDTO)
                .collect(Collectors.toList());

    }
        public CantorDTO findById(Long id) throws CantorNotFoundException {
            Cantor cantor = cantorRepository.findById(id)
                    .orElseThrow(() -> new CantorNotFoundException(id));
            return cantorMapper.toDTO(cantor);
        }

        public MessageResponseDTO update(Long id,CantorDTO cantorDTO) throws CantorNotFoundException{
            cantorRepository.findById(id)
                    .orElseThrow(() -> new CantorNotFoundException(id));
            Cantor updatedCantor = cantorMapper.toModel(cantorDTO);
            Cantor savedCantor = cantorRepository.save(updatedCantor);

            MessageResponseDTO messageResponse = createMessageResponse("Cantor e música atualizado com sucesso ID: ", savedCantor.getId());

            return messageResponse;
    }
    private MessageResponseDTO createMessageResponse(String message, Long id) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }
}
