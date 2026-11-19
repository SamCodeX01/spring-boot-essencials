package br.com.samuel.spring_boot_essencials.repository;

import br.com.samuel.spring_boot_essencials.model.ExerciciosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IExerciciosRepository extends JpaRepository<ExerciciosModel, UUID>{

    //Abaixo 3 Formas Diferentes de Fzer a Mesma Coisa:

    //Método
    List<ExerciciosModel> findAllByGrupoMuscular(String grupoMuscular);

    //Query Método
    @Query(value = "SELECT e FROM ExercicioxModel e WHERE UPPER(e.grupoMuscular) = UPPER(:grupoMuscular)")
    List<ExerciciosModel> findAllGrupoMuscularJpql(@Param("grupoMuscular") String grupoMuscular);

    //Query Nativa
    @NativeQuery(value = "SELECT e FROM exercicios e WHERE UPPER(:grupoMuscular)")
    List<ExerciciosModel> findAllGrupoMuscularNative(@Param("grupoMuscular") String grupoMuscular);

}
