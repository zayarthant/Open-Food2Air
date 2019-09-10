package com.food2air.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.food2air.dataAccess.utility.BillUtility;
import com.food2air.entity.Bill;
import com.food2air.entity.FoodItem;
import com.food2air.entity.FoodTable;
import com.food2air.entity.OrderRecord;
import com.food2air.service.BillService;
import com.food2air.service.FoodItemService;
import com.food2air.service.FoodTableService;
import com.food2air.service.OrderRecordService;

@Controller
@RequestMapping("/")
public class ApplicationController {

	@Autowired
	private FoodTableService foodTableService;

	@Autowired
	private FoodItemService foodItemService;

	@Autowired
	private OrderRecordService orderRecordService;

	@Autowired
	private BillService billService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "login";
	}

	@RequestMapping("about")
	public String about() {
		return "about";
	}

	@RequestMapping("login")
	public String login(@RequestParam(name = "out", required = false) boolean out, Model model) {
		if (out)
			model.addAttribute("out", true);
		return "login";
	}

	@RequestMapping("tableLogin")
	public String tableLogin(@RequestParam(name = "table_number") int table_number, Model model) {
		FoodTable foodTable = foodTableService.login(table_number);
		if (null != foodTable) {
			List<FoodItem> foodItemList = foodItemService.getAll();
			model.addAttribute("foodList", foodItemList);
			model.addAttribute("foodTable", foodTable);
			return "menu";
		} else {
			model.addAttribute("errorMessage", "The table you enter [ " + table_number + "] does not exist.");
			return "login";
		}
	}

	@RequestMapping("mainMenu")
	public String menu(Model model, @ModelAttribute("message") String message,
			@ModelAttribute("errorMessage") String errorMessage) {
		List<FoodItem> foodItemList = foodItemService.getAll();
		model.addAttribute("foodList", foodItemList);
		model.addAttribute(message);
		model.addAttribute(errorMessage);
		return "menu";
	}

	@RequestMapping("order/{id}")
	public String order(@PathVariable("id") long id, Model model) {
		FoodItem item = foodItemService.get(id);
		if (null != item)
			model.addAttribute("item", item);
		return "order";
	}

	@RequestMapping("makeOrder/{tableNumber}/{productId}")
	public ModelAndView makeOrder(@PathVariable("tableNumber") int tableNumber, @PathVariable("productId") long itemId,
			@RequestParam(name = "quantity") int quantity, RedirectAttributes redirect) {
		ModelAndView modelAndView = new ModelAndView("redirect:/mainMenu");
		FoodTable foodTable = foodTableService.login(tableNumber);
		FoodItem foodItem = foodItemService.get(itemId);
		if (null != foodTable && null != foodItem && 0 < quantity) {
			OrderRecord orderRecord = orderRecordService.insertRecord(foodItem, foodTable, quantity);
			redirect.addFlashAttribute("message", "Order Id " + orderRecord.getId() + " is in progress!");
		} else {
			redirect.addFlashAttribute("errorMessage", "Can't be order!");
		}
		return modelAndView;
	}

	@RequestMapping("oderList/{tableNumber}")
	public String oderList(@PathVariable("tableNumber") int tableNumber, Model model,
			@ModelAttribute("message") String message, @ModelAttribute("errorMessage") String errorMessage) {
		FoodTable table = foodTableService.login(tableNumber);
		if (null != table && null != table.getServing_bill()) {
			Bill bill = table.getServing_bill();
			List<OrderRecord> list = bill.getOrder_record_list();
			model.addAttribute("list", list);
			model.addAttribute(message);
			model.addAttribute(errorMessage);
		}
		return "oderList";
	}

	@RequestMapping("cancelOrder/{tableNumber}/{id}")
	public ModelAndView cancleOrder(@PathVariable("id") long id, @PathVariable("tableNumber") int tableNumber,
			Model model, RedirectAttributes redirect) {
		try {
			orderRecordService.cancelRecord(id);
			redirect.addFlashAttribute("message", "Order was cancel successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("errorMessage", "Can't cancel the order!" + e.getMessage());
		}
		return new ModelAndView("redirect:/oderList/" + tableNumber);
	}

	@RequestMapping("bill/{tableNumber}")
	public String bill(@PathVariable("tableNumber") int tableNumber, Model model) {
		FoodTable table = foodTableService.login(tableNumber);
		if (null != table && null != table.getServing_bill()) {
			Bill bill = table.getServing_bill();
			double total = billService.totalPrice(bill);
			double tax = BillUtility.getTax(total);
			total = BillUtility.totalBill(total);
			List<OrderRecord> list = bill.getOrder_record_list();
			model.addAttribute("recordList", list);
			model.addAttribute("tax", tax);
			model.addAttribute("total", total);
		}
		return "bill";
	}

}
