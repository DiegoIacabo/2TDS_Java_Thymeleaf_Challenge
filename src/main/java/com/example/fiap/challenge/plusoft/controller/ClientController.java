package com.example.fiap.challenge.plusoft.controller;

import com.example.fiap.challenge.plusoft.domainmodel.Client;
import com.example.fiap.challenge.plusoft.service.ClientServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private @Setter ClientServiceImpl service;

    @GetMapping("/")
    public String viewHomePageAsList(Model model) {
        List<Client> clientList = this.service.findAllClients();
        model.addAttribute("allClientList", clientList);
        return "index";
    }

    @GetMapping("/addNew")
    public String addNew(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "newClient";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("client") Client client) {
        this.service.save(client);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable("id") Long id) {
        this.service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Optional<Client> client = this.service.findById(id);
        if(client.isPresent()) {
            model.addAttribute("client", client.get());
        }
        else
            System.out.println("Client not found");
        return "updateClient";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("client") Client client) {
        this.service.save(client);
        return "redirect:/";
    }

    @GetMapping("/show/{id}")
    public String show( @PathVariable("id") Long id, Model model){
        Optional<Client> client = this.service.findById(id);

        if( client.isPresent() )
            model.addAttribute("client", client.get());
        else
            System.out.println("Client not found");
        return "showClient";
    }

}
