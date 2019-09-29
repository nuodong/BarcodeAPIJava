package com.numob.api.barcode.user;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    User findById(long id);

    @Query("SELECT e FROM User e WHERE e.id >= :id")
    public List<User> listItemsWithPriceOver(@Param("id") long id);
}