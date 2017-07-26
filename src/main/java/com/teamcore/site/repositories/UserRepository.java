package com.teamcore.site.repositories;

import com.teamcore.site.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by igoz on 26.07.17.
 */

public interface UserRepository extends CrudRepository<User, Integer> {
}
