package com.example.MyOwnMP3.Repository;

import com.example.MyOwnMP3.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

//    @Query(value = """
//            SELECT * From AppUser U where u.email = :username
//            """)
    Optional<AppUser> findByEmail(String username);
}
