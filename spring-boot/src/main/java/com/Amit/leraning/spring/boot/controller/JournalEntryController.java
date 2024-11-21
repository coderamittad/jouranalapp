package com.Amit.leraning.spring.boot.controller;

import com.Amit.leraning.spring.boot.entity.JournalEntry;
import com.Amit.leraning.spring.boot.services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class JournalEntryController {

  @Autowired
    JournalEntryService journalEntryService;
    @GetMapping
    public List<JournalEntry> getAll() {
        return  journalEntryService.getAll();
    }

    @PostMapping
    public void addJournalEntry(@RequestBody JournalEntry journal) {
       journalEntryService.saveEntry(journal);
    }

    @GetMapping("/id/{id}")
    public JournalEntry getById(@PathVariable Long id) {
        return journalEntryService.getById(id); // Assuming this method exists in the service
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
       journalEntryService.deleteEntry(id); // Assuming this method exists in the service
    }

    @PutMapping("/id/{id}")
    public JournalEntry editJournalEntry(@PathVariable Long id, @RequestBody JournalEntry journal) {
        return journalEntryService.updateEntry(id, journal);// Assuming this method exists in the service
    }
}
