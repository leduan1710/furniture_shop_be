package hcmute.it.furnitureshop.Repository;

import hcmute.it.furnitureshop.Entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
    @Override
    Iterable<Room> findAll();

    @Override
    Optional<Room> findById(Integer integer);
}