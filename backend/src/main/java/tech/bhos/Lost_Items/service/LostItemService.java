package tech.bhos.Lost_Items.service;

import tech.bhos.Lost_Items.model.LostItem;
import tech.bhos.Lost_Items.repository.LostItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LostItemService {

    private LostItemRepo repo;

    public LostItemRepo getRepo() { return repo; }

    @Autowired
    public void setRepo(LostItemRepo repo) {
        this.repo = repo;
    }


    public List<LostItem> getAllLostItems() {
        return repo.findAll();
    }

    public Optional<LostItem> getLostItemById(Integer id) {
        return repo.findById(id);
    }

    public LostItem addLostItem(LostItem item) {
        return repo.save(item);
    }

    public LostItem updateLostItem(Integer id, LostItem updatedItem) {
        updatedItem.setItemId(id);
        return repo.save(updatedItem);
    }

    public void deleteLostItem(Integer id) {
        repo.deleteById(id);
    }

}
