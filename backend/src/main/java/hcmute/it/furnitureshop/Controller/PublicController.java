package hcmute.it.furnitureshop.Controller;

import hcmute.it.furnitureshop.DAO.CategoryDAO;
import hcmute.it.furnitureshop.DAO.ProductDAO;
import hcmute.it.furnitureshop.DAO.RoomDAO;
import hcmute.it.furnitureshop.Entity.Category;
import hcmute.it.furnitureshop.Entity.Product;
import hcmute.it.furnitureshop.Entity.Room;
import hcmute.it.furnitureshop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PublicController {
    @Autowired
    RoomDAO roomDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    ProductDAO productDAO;
    @GetMapping("/room")
    public Iterable<Room> getAllRoom(){
        return roomDAO.getAll();
    }

    @RequestMapping("/room/categories/{id}")
    public Iterable<Category> getCategoriesByRoom(@PathVariable("id") Integer roomId){
        Optional<Room> roomById=roomDAO.getById(roomId);
        return categoryDAO.getCategoriesByRoom(roomById);
    }

    @RequestMapping("/category")
    public Iterable<Category> getAllCategory(){
        return categoryDAO.getAll();
    }

    @RequestMapping("/product/top8Product")
    public Iterable<Product> getTop8Product(){
        return productDAO.getTop8Product();
    }
}
