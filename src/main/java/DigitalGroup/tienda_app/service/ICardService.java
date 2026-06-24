package DigitalGroup.tienda_app.service;

import java.util.List;

import DigitalGroup.tienda_app.model.Card;

public interface ICardService {
    public List<Card> listCards();
    public Card findCard(Integer idCard);
    public void saveCard(Card card);
    public void deleteCard(Card card);

}

