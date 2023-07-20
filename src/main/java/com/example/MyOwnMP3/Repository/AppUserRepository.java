package com.example.MyOwnMP3.Repository;

import com.example.MyOwnMP3.Model.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Integer> {

}
