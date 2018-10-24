package com.sap.hack.your.career.springdemo.controller;


import com.sap.hack.your.career.springdemo.entity.Beer;
import com.sap.hack.your.career.springdemo.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * CRUD REST controller for {@link Beer} entity
 */
@RestController
@RequestMapping("/beers")
public class BeerController {

    /**
     * Injected instance of a {@link BeerRepository} to operate {@link Beer} entity
     */
    @Autowired
    private BeerRepository beerRepository;

    /**
     * @return List of all {@link Beer} entities in the database
     */
    @GetMapping
    public List<Beer> getBeers() {
        return StreamSupport
                .stream(beerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Get {@link Beer} by provided id, if not found returns null
     *
     * @param id of a beer to get
     * @return {@link Beer} entity if such is present in database
     */
    @GetMapping("/{id}")
    public Beer getBeer(@PathVariable("id") final Long id) {
        return beerRepository.findById(id).orElse(null);
    }

    /**
     * Get {@link Beer} by provided name, if not found returns null
     *
     * @param name of a beer to get
     * @return {@link Beer} entity if such is present in database
     */
    @GetMapping("/name/{name}")
    public Beer getBeerByName(@PathVariable("name") final String name) {
        return beerRepository.findBeerByName(name);
    }

    /**
     * Removes {@link Beer} entity with provided id if such exist in database
     *
     * @param id of a beer to remove
     */
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") final Long id) {
        beerRepository.deleteById(id);
    }

    /**
     * Modify {@link Beer} with provided id if such exist in database, if such does not exist in database it is ignored
     *
     * @param id   of a beer to create
     * @param beer data that will be persisted to the database
     */
    @PutMapping("/{id}")
    public void modify(@PathVariable("id") final Long id, @RequestBody final Beer beer) {
        if (beerRepository.findById(id).isPresent()) {
            beer.setId(id);
            beerRepository.save(beer);
        }
    }

    /**
     * Save {@link Beer} entity in the database if such is valid.
     * @param beer data to create
     */
    @PostMapping
    public void create(@RequestBody final Beer beer) {
        beerRepository.save(beer);
    }

}
