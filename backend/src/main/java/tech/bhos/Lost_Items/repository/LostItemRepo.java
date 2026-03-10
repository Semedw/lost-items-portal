package tech.bhos.Lost_Items.repository;
import tech.bhos.Lost_Items.model.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostItemRepo extends JpaRepository<LostItem, Integer> {

}
