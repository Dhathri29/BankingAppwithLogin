package com.dhathri.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dhathri.demo.Repo.ItemRepository;
import com.dhathri.demo.model.Item;

@Service
@Transactional
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}
	
	public void saveMyUser(Item item) {
		itemRepository.save(item);
	}
	
	public List<Item> showAllUsers(){ 
		 List<Item> re=itemRepository.findAll();
		  return re;		 
	 }
	
	public Item findByUsernameAndPassword(String string, String password) {
		return itemRepository.findByUsernameAndPassword(string, password);
	}
	
	
}
