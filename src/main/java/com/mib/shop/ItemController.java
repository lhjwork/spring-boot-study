package com.mib.shop;

import lombok.RequiredArgsConstructor;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
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
    String addItem(@RequestParam String title, @RequestParam String price){
        System.out.println(title);
        System.out.println(price);
        return "redirect:/list";
    }

    @PostMapping("/items/map")
    String addMapItem (@RequestParam Map formData){
        HashMap<String, Object> test = new HashMap<>();
        test.put("name","kim");
        test.put("age",20);
        System.out.println(test);

        return "redirect:/list";
    }
}
