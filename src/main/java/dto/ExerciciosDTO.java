package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExerciciosDTO {

    @NotBlank //Nome nao pode se Nulo e nem Vazio
    private String nome;
    @NotBlank
    private String grupoMuscular;
}
