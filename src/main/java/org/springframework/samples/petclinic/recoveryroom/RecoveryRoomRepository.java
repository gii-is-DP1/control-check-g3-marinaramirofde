package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    
	
	List<RecoveryRoom> findAll();
	
	// TEST 2
	@Query("SELECT rt FROM RecoveryRoomType rt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
	
	// TEST 6
    @Query("SELECT rt FROM RecoveryRoomType rt WHERE rt.name = ?1")
    RecoveryRoomType getRecoveryRoomType(String name);
    
    // TEST 8
    @Query("SELECT r FROM RecoveryRoom r WHERE r.size > ?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);

    
    // No hace falta con el CRUD:
    
    	//RecoveryRoom save(RecoveryRoom p);
	
		//Optional<RecoveryRoom> findById(int id);
    
    
}
