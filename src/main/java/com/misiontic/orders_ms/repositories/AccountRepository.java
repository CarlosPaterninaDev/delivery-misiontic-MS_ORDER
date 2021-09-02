package com.misiontic.orders_ms.repositories;

import com.misiontic.orders_ms.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository <Account, String> {
}
