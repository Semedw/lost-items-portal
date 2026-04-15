package tech.bhos.Lost_Items.service;

import tech.bhos.Lost_Items.dto.LostItemRequest;
import tech.bhos.Lost_Items.exception.LostItemNotFoundException;
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

    public LostItem addLostItem(LostItemRequest request) {
        LostItem item = mapToEntity(request);
        return repo.save(item);
    }

    public LostItem updateLostItem(Integer id, LostItemRequest request) {
        LostItem existingItem = repo.findById(id)
                .orElseThrow(() -> new LostItemNotFoundException(id));

        existingItem.setItemName(request.itemName());
        existingItem.setItemDesc(request.itemDesc());
        existingItem.setItemLocation(request.itemLocation());
        existingItem.setFounderNumber(request.founderNumber());
        return repo.save(existingItem);
    }

    public void deleteLostItem(Integer id) {
        repo.deleteById(id);
    }

    private LostItem mapToEntity(LostItemRequest request) {
        return new LostItem(
                null,
                request.itemName(),
                request.itemDesc(),
                request.itemLocation(),
                request.founderNumber()
        );
    }
}
