package com.example.zoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.Entities.Enclosure;
import com.example.zoo.Services.EnclosureService;
import java.util.List;

@Controller
@RequestMapping("/enclosures")
public class EnclosureController {

    @Autowired
    private EnclosureService enclosureService;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("enclosure", new Enclosure());
        return "add-enclosure";
    }

    @PostMapping("/add")
    public String addEnclosure(@ModelAttribute Enclosure enclosure) {
        enclosureService.addEnclosure(enclosure);
        return "redirect:/enclosures/all";
    }

    @GetMapping("/all")
    public String showAllEnclosures(Model model) {
        List<Enclosure> enclosures = enclosureService.findAll();
        model.addAttribute("enclosures", enclosures);
        return "enclosures-list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        List<Enclosure> enclosureList = enclosureService.findByID(id);
        if (enclosureList.isEmpty()) {
            throw new RuntimeException("Enclosure not found");
        }
        model.addAttribute("enclosure", enclosureList.get(0));
        return "edit-enclosure";
    }

    @PostMapping("/update/{id}")
    public String updateEnclosure(@PathVariable long id, 
                                @ModelAttribute Enclosure enclosure) {
        enclosure.setId(id);
        enclosureService.addEnclosure(enclosure); // Используем save для обновления
        return "redirect:/enclosures/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteEnclosure(@PathVariable long id) {
        enclosureService.deleteEnclusure(id);
        return "redirect:/enclosures/all";
    }
}
