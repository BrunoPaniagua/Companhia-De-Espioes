package repository;

import model.EspiaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspiaoRepository extends JpaRepository<EspiaoModel, Long> {
}
