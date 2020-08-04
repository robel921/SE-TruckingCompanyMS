package edu.miu.cs.cs425.studenmgmtapp.repository;

import edu.miu.cs.cs425.studenmgmtapp.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository  extends JpaRepository<ClassRoom, Long> {
}
