package com.example.webapp.repositories;

import com.example.webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublishRepository extends CrudRepository<Publisher, Long> {
}
