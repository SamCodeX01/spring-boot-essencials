package br.com.samuel.spring_boot_essencials.controller;

import br.com.samuel.spring_boot_essencials.model.ExerciciosModel;
import br.com.samuel.spring_boot_essencials.service.ExerciciosService;
import dto.ExerciciosDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
@Validated
public class ExerciciosController {
    private final ExerciciosService exerciciosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveExercicio(@Valid @RequestBody ExerciciosDTO exerciciosDTO){
        exerciciosService.save(exerciciosDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosModel> findAll(){
        return exerciciosService.findAll();
    }

    @GetMapping("/grupo/{grupoMuscular}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosModel> getExerciciosByGrupoMuscular(@PathVariable String grupoMuscular){
        return exerciciosService.getExerciciosByGroupMuscular(grupoMuscular);
    }

}
