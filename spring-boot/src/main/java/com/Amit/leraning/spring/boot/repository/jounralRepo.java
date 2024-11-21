package com.Amit.leraning.spring.boot.repository;

import com.Amit.leraning.spring.boot.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.jar.JarEntry;

public interface jounralRepo extends MongoRepository<JournalEntry,Long> {
}
