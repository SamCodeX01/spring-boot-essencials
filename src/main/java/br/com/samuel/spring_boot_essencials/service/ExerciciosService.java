package br.com.samuel.spring_boot_essencials.service;

import br.com.samuel.spring_boot_essencials.model.ExerciciosModel;
import br.com.samuel.spring_boot_essencials.repository.IExerciciosRepository;
import dto.ExerciciosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //gera automaticamente um construtor que contenha apenas final, eliminando a necessidade de escrever o construtor manualmente.

public class ExerciciosService {
    private final IExerciciosRepository exerciciosRepository; //Declara a dependência do repositório que faz a comunicação direta com o banco de dados. Como tem o final o spring transforma em construtor fazendo a injeção de dependência

    public List<ExerciciosModel> findAll(){//método que retorna uma lista de objetos do tipo ExerciciosModel (que representa a tabela de exercícios no banco).
        return exerciciosRepository.findAll(); //Chama o método pronto findAll() do repositório (geralmente herdado do Spring Data JPA) para buscar todos os registros da tabela de exercícios e os retorna para quem chamou o serviço.
    }

    public void save(ExerciciosDTO exerciciosDTO){
        ExerciciosModel exercicios = ExerciciosModel.builder()
                .nome(exerciciosDTO.getNome()) // Pega o nome que veio no DTO e coloca no atributo nome do Model.
                .grupoMuscular(exerciciosDTO.getGrupoMuscular())
                .build(); //build(): Finaliza a montagem e entrega o objeto ExerciciosModel pronto e preenchido.

        exerciciosRepository.save(exercicios);//ExerciciosModel.builder(): Inicia a construção de um novo objeto ExerciciosModel.
    }

    public List<ExerciciosModel> getExerciciosByGroupMuscular(String grupoMuscular){
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }
}
