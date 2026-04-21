package com.mib.shop;

import lombok.RequiredArgsConstructor;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

   private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
        var a = new Item();
        System.out.println(a.toString());
        model.addAttribute("items",  result );
        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/items")
    String addItem(@RequestParam String title, @RequestParam Integer price){
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect:/list";
    }

    @PostMapping("/items/map")
    String addMapItem(@RequestParam Map<String, String> formData){
        Item item = new Item();
        item.setTitle(formData.get("title"));
        item.setPrice(Integer.valueOf(formData.get("price")));
        itemRepository.save(item);
        return "redirect:/list";
    }

    @PostMapping("/items/modelattribute")
    String addModelItem(@ModelAttribute Item item){
        itemRepository.save(item);
        return "redirect:/list";
    }

    @GetMapping("/items/{id}")
    String viewItem(@PathVariable Integer id, Model model) {
        Optional<Item> result = itemRepository.findById(Long.valueOf(id));

        if (result.isPresent()) {
            model.addAttribute("item", result.get());
            return "detail.html";
        }

        return "error.html";

    }

}
