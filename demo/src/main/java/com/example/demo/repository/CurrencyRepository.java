package com.example.demo.repository;

import com.example.demo.Entity.Currency;
import com.example.demo.Entity.Rates;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency,Integer> {
}
