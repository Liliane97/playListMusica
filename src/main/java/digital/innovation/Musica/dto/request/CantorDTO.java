package digital.innovation.Musica.dto.request;

import digital.innovation.Musica.entities.Musica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CantorDTO {
    private Long id;
    @NotEmpty
    private String nome;

    private LocalDate anoDeLancamento;
    @NotEmpty
    private List<Musica> musicas;
}
