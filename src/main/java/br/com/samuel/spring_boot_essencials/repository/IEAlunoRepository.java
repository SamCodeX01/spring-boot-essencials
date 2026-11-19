package br.com.samuel.spring_boot_essencials.repository;

import br.com.samuel.spring_boot_essencials.model.AlunosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IEAlunoRepository extends JpaRepository<AlunosModel, UUID> {
}
