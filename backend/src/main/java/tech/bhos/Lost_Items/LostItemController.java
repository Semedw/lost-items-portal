package tech.bhos.Lost_Items;

import tech.bhos.Lost_Items.model.LostItem;
import tech.bhos.Lost_Items.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lost-items")
@CrossOrigin(origins = "http://localhost:3000")
public class LostItemController {

    @Autowired
    private LostItemService service;

    @GetMapping
    public List<LostItem> getAll() {
        return service.getAllLostItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LostItem> getById(@PathVariable Integer id) {
        return service.getLostItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public LostItem create(@RequestBody LostItem item) {
        return service.addLostItem(item);
    }

    @PutMapping("/{id}")
    public LostItem update(@PathVariable Integer id, @RequestBody LostItem item) {
        return service.updateLostItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteLostItem(id);
    }
}