package com.example.demo_rest.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_rest.exception.InvalidPlaceNameException;
import com.example.demo_rest.exception.InvalidTicketIDException;
import com.example.demo_rest.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer>{
	
	//Get all tickets with a specific from and to place
	//Derived Query Method
	public List<Ticket> findByFromplaceOrToplace(String from_place, String to_place);
	
	//Get all tickets with a specific from and to place, price less than an amount
	public List<Ticket> findByFromplaceAndToplaceAndPriceLessThan(String from_place, String to_place, float price);
	
	//JPQL
	//Custom Query Method
	@Query("SELECT w FROM Ticket w WHERE w.fromplace = :fromplace")
	List<Ticket> met(@Param("fromplace") String str);
	
	//SQL
	@Query(value = "SELECT * FROM ticket WHERE username = :uname", nativeQuery = true)
	List<Ticket> met9(@Param("uname") String username);
	
	@Modifying	  
	@Transactional
	@Query("UPDATE Ticket t SET t.price = t.price*0.9 WHERE t.username = :uname")
	void met10(@Param("uname") String username);
	
	//public List<Ticket> findByFromplaceContaining(String str);
	//public List<Ticket> findByFromPlaceStartingWith(String prefix)
	//List<Product> findByNameEndingWith(String suffix);
	//public List<Product> findByPriceLessThanEqual(float price);
	// List<Product> findByIdBetween(int startId, int endId);
	//void deleteById(Long id);
	//void deleteByIdGreaterThan(Long id);
	
	/*private HashMap<Integer, Ticket> tickets;

	public TicketRepository() {
		tickets = new HashMap<>();
		tickets.put(1, new Ticket(1,"Place1312","Place42342",111));
		tickets.put(2, new Ticket(2,"PlaceAAAA","PlaceCCCC",122));
		tickets.put(3, new Ticket(3,"PlaceDDDD","PlaceEEEE",241));
	}

	
	public Ticket getTicketRepo(int ticketid) {
		Ticket ticket = tickets.get(ticketid);
		return ticket;
	}
	
	public Ticket bookTicketRepo(Ticket ticket) {
		tickets.put(ticket.getId(), ticket);
		return ticket;
	}
	
	public Ticket updateTicketRepo(int tid, Ticket ticket) {
		tickets.replace(tid, ticket);
		return ticket;
	}
	
	public int cancelTicketRepo(int ticketid) {
		Ticket ticket = tickets.remove(ticketid);
		return ticketid;
	}	*/
	
	
	
	/*
	 * 
	 * // Find products by name using JPQL
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.name = :name") List<Product>
	 * findByName(@Param("name") String name);
	 * 
	 * // Find products by category using JPQL
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.category = :category") List<Product>
	 * findByCategory(@Param("category") String category);
	 * 
	 * // Find products with price less than a specified value using JPQL
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.price < :maxPrice") List<Product>
	 * findByPriceLessThan(@Param("maxPrice") Double maxPrice);
	 * 
	 * // Native SQL query to find products by name
	 * 
	 * @Query(value = "SELECT * FROM products WHERE name = :name", nativeQuery =
	 * true) List<Product> findByNameNative(@Param("name") String name);
	 * 
	 * // Find products with a price greater than a specified value
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.price > :minPrice") List<Product>
	 * findByPriceGreaterThan(@Param("minPrice") Double minPrice);
	 * 
	 * // Find products with a price less than a specified value
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.price < :maxPrice") List<Product>
	 * findByPriceLessThan(@Param("maxPrice") Double maxPrice);
	 * 
	 * // Find products with a quantity equal to a specified value
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.quantity = :quantity") List<Product>
	 * findByQuantity(@Param("quantity") Integer quantity);
	 * 
	 * // Find products with a quantity greater than or equal to a specified value
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.quantity >= :minQuantity")
	 * List<Product> findByQuantityGreaterThanEqual(@Param("minQuantity") Integer
	 * minQuantity);
	 * 
	 * // Find products with a price within a specified range
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice"
	 * ) List<Product> findByPriceBetween(@Param("minPrice") Double
	 * minPrice, @Param("maxPrice") Double maxPrice);
	 * 
	 * // Count products with a price greater than a specified value
	 * 
	 * @Query("SELECT COUNT(p) FROM Product p WHERE p.price > :minPrice") Long
	 * countByPriceGreaterThan(@Param("minPrice") Double minPrice);
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE Product p SET p.price = :newPrice WHERE p.id > :id") void
	 * updatePriceByIdGreaterThan(Long id, Double newPrice);
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE Product p SET p.price = :newPrice WHERE p.id = :id") void
	 * updateProductPriceById(Long id, Double newPrice);
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE Product p SET p.category = :newCategory WHERE p.price < :maxPrice"
	 * ) void updateProductCategoryByPriceLessThan(Double maxPrice, String
	 * newCategory);
	 * 
	 * 
	 */

	}
