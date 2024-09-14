package com.example.fiap.challenge.plusoft.controller;

import com.example.fiap.challenge.plusoft.domainmodel.Client;
import com.example.fiap.challenge.plusoft.domainmodel.CreditCard;
import com.example.fiap.challenge.plusoft.service.CreditCardServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/creditCards")
public class CreditCardController {

    @Autowired
    private @Setter CreditCardServiceImpl service;

    @GetMapping("/creditCards")
    public String view(Model model) {
        List<CreditCard> cardList = this.service.findAllCards();
        model.addAttribute("allCardList", cardList);
        return "cardList";
    }

    @GetMapping("/addNew")
    public String addNew(Model model) {
        CreditCard creditCard = new CreditCard();
        model.addAttribute("creditCard", creditCard);
        return "newCreditCard";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("creditCard") CreditCard creditCard) {
        this.service.save(creditCard);
        return "redirect:/creditCards/creditCards";
    }

    @GetMapping("/delete/{id}")
    public String deleteThrougId(@PathVariable("id") Long id) {
        this.service.deleteById(id);
        return "redirect:/creditCards/creditCards";
    }

    @GetMapping("/show/{id}")
    public String show( @PathVariable("id") Long id, Model model){
        Optional<CreditCard> creditCard = this.service.findById(id);

        if( creditCard.isPresent() )
            model.addAttribute("creditCard", creditCard.get());
        else
            System.out.println("creditCard not found");
        return "showCreditCard";
    }

}
