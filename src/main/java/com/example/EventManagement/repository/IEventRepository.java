package com.example.EventManagement.repository;

import com.example.EventManagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventRepository extends JpaRepository<Event,Integer> {
}
