package br.com.samuel.spring_boot_essencials.repository;

import br.com.samuel.spring_boot_essencials.model.TreinosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IETreinoRepository extends JpaRepository<TreinosModel, UUID> {
}
