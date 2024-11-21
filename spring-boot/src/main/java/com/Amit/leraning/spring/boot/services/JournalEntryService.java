package com.Amit.leraning.spring.boot.services;

import com.Amit.leraning.spring.boot.entity.JournalEntry;
import com.Amit.leraning.spring.boot.repository.jounralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class JournalEntryService {

    @Autowired
    private jounralRepo journalEntryRepository;

    // Get all entries
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    // Get entry by ID
    public JournalEntry getById(Long id) {
        Optional<JournalEntry> optionalEntry = journalEntryRepository.findById(id);
        return optionalEntry.orElse(null);
    }

    // Add new entry
    public JournalEntry saveEntry(JournalEntry journalEntry) {
        return journalEntryRepository.save(journalEntry);
    }

    // Update an entry
    public JournalEntry updateEntry(Long id, JournalEntry journalEntry) {
        if (journalEntryRepository.existsById(id)) {
            journalEntry.setId(id); // Ensure the correct ID is set
            return journalEntryRepository.save(journalEntry);
        }
        return null; // Handle as needed
    }

    // Delete an entry
    public void deleteEntry(Long id) {
        journalEntryRepository.deleteById(id);
    }
}

