package digital.innovation.Musica.dto.mapper;

import digital.innovation.Musica.dto.request.CantorDTO;
import digital.innovation.Musica.entities.Cantor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CantorMapper {
    @Mapping(target="anoDeLancamento ",source="anoDeLancamento",dateFormat = "dd-MM-yyyy")
    Cantor toModel(CantorDTO dto);

    CantorDTO toDTO(Cantor dto);
}
