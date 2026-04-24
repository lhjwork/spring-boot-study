package com.mib.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    public void saveItem(String title, Integer price) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("제목이 비어있습니다");
        }
        if (price == null || price < 0) {
            throw new IllegalArgumentException("가격이 잘못되었습니다");
        }
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }
}
