package DigitalGroup.tienda_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DigitalGroup.tienda_app.model.Card;


public interface CardRepository extends JpaRepository<Card,Integer>{
    
}
