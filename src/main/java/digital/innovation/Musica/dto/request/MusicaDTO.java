package digital.innovation.Musica.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicaDTO {

    private Long id;

    @NotEmpty
    private String nomeDaMusica;
}
