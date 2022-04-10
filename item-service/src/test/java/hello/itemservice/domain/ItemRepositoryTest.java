package hello.itemservice.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save(){
        // given
        Item itemA = new Item("itemA", 10000, 10);
        // when
        Item saveItem = itemRepository.save(itemA);
        // then
        Item findItem = itemRepository.findById(itemA.getId());
        assertThat(saveItem).isEqualTo(findItem);
    }

    @Test
    void findAll(){
        // given
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);

        itemRepository.save(item1);
        itemRepository.save(item2);

        // when
        List<Item> result = itemRepository.findAll();

        // then
        assertThat(result).size().isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    void update(){
        // given
        Item item1 = new Item("item1", 10000, 10);
        itemRepository.save(item1);
        Long item1Id = item1.getId();

        // when
        Item updateParam = new Item("item2", 20000, 20);
        itemRepository.update(item1Id, updateParam);

        // then
        assertThat(item1.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(item1.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(item1.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
}