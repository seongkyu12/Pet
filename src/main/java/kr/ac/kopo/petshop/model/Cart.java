package kr.ac.kopo.petshop.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
private Map<Long, Integer> cart = new HashMap<Long, Integer>();
	
	public void setCart(Long dogId, Integer amount) {
		if(cart.containsKey(dogId))
			cart.put(dogId, cart.get(dogId) + amount);
		else
			cart.put(dogId, amount);			
	}
	
	public Map<Long, Integer> getCart() {
		return cart;
	}

	public void delete(Long dogId) {
		cart.remove(dogId);
	}
}
