package com.mib.shop;

import lombok.RequiredArgsConstructor;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        item.title = title;
        item.price = price;
        itemRepository.save(item);
        return "redirect:/list";
    }

    @PostMapping("/items/map")
    String addMapItem(@RequestParam Map<String, String> formData){
        Item item = new Item();
        item.title = formData.get("title");
        item.price = Integer.valueOf(formData.get("price"));
        itemRepository.save(item);
        return "redirect:/list";
    }
}
