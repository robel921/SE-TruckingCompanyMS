package edu.miu.cs.cs425.studenmgmtapp.repository;

import edu.miu.cs.cs425.studenmgmtapp.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
}
