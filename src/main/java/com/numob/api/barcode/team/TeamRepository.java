package com.numob.api.barcode.team;

import com.numob.api.barcode.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer>{
    Team findByUserId(Integer userId);
}
