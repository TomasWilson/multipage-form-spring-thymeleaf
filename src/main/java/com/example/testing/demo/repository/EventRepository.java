package com.example.testing.demo.repository;

import com.example.testing.demo.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}
