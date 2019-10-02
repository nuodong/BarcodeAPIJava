package com.numob.api.barcode.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExtensionRepository extends JpaRepository<UserExtension, Integer> {
    UserExtension findByUser(User user);
}
