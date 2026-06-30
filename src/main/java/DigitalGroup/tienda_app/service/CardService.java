package DigitalGroup.tienda_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DigitalGroup.tienda_app.model.Card;
import DigitalGroup.tienda_app.repository.CardRepository;

@Service
public class CardService implements ICardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> listCards() {
       List<Card> cards = cardRepository.findAll();
       return cards;
    }

    @Override
    public Card findCard(Integer idCard) {
        Card card = cardRepository.findById(idCard).orElse(null);
        return card;
    }

    @Override
    public void saveCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public void deleteCard(Card card) {
        cardRepository.delete(card);
    }

}
