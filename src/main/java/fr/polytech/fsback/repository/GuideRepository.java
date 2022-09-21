package fr.polytech.fsback.repository;

import fr.polytech.fsback.entity.GuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends JpaRepository<GuideEntity, Integer> {
}
