package DigitalGroup.tienda_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DigitalGroup.tienda_app.model.Card;
import DigitalGroup.tienda_app.service.CardService;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins =  "*")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getCards(){
        return cardService.listCards();
    }
}

