package com.nus.invms;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nus.invms.domain.Inventory;
import com.nus.invms.repo.InventoryRepository;

@SpringBootTest
class InvMsApplicationTests {

	@Autowired
	InventoryRepository irepo;

	/*
	 * @Test void findByBrandName() { System.out.println("Reading from database");
	 * System.out.println("FindbyBrandNameLike"); ArrayList<Inventory> list = new
	 * ArrayList<Inventory>(); list = (ArrayList<Inventory>)
	 * irepo.findByBrandNameLike("%B%"); for (Iterator<Inventory> iterator =
	 * list.iterator(); iterator.hasNext();) { Inventory i = iterator.next();
	 * System.out.println(i.toString()); } }
	 */

//	@Test
//	void findByProductID() {
//		System.out.println("Reading from database");
//		System.out.println("FindbyProductID");
//		ArrayList<Inventory> list = new ArrayList<Inventory>();
//		list = (ArrayList<Inventory>) irepo.findByProductId(1001001);
//		for (Iterator<Inventory> iterator = list.iterator(); iterator.hasNext();) {
//			Inventory i = iterator.next();
//			System.out.println(i.toString());
//			}
//		}
	
//	@Test
//	void findInventory() {
//		System.out.println("Reading from database");
//		System.out.println("FindAll");
//		ArrayList<Inventory> list = new ArrayList<Inventory>();
//		list = (ArrayList<Inventory>) irepo.findInventoryItem("plug");
//		for (Iterator<Inventory> iterator = list.iterator(); iterator.hasNext();) {
//			Inventory i = iterator.next();
//			System.out.println(i.toString());
//		}
//	}
}
