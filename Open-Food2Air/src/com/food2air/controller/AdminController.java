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
import com.food2air.entity.AdminUser;
import com.food2air.entity.Bill;
import com.food2air.entity.OrderRecord;
import com.food2air.service.AdminUserService;
import com.food2air.service.BillService;
import com.food2air.service.FoodTableService;
import com.food2air.service.OrderRecordService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminUserService adminUserService;

	@Autowired
	private OrderRecordService orderRecordService;

	@Autowired
	private BillService billService;
	
	@Autowired
	private FoodTableService foodTableService;

	@RequestMapping(method = RequestMethod.GET)
	public String another(@ModelAttribute("errorMessage") String errorMessage, @ModelAttribute("out") boolean out,
			Model model) {
		model.addAttribute(errorMessage);
		model.addAttribute(out);
		return "admin/login";
	}

	@ModelAttribute("out")
	public boolean defaultOut() {
		return false;
	}

	@RequestMapping("logout")
	public ModelAndView login(RedirectAttributes redirect) {
		redirect.addFlashAttribute("out", true);
		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping("adminLogin")
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, RedirectAttributes redirect) {
		ModelAndView modelAndView = null;
		AdminUser adminUser = adminUserService.login(username, password);
		if (null != adminUser) {
			redirect.addFlashAttribute("adminUser", adminUser);
			modelAndView = new ModelAndView("redirect:/admin/oderList");
		} else {
			modelAndView = new ModelAndView("redirect:/admin");
			redirect.addFlashAttribute("errorMessage", "Login information are incorrect!");
		}
		return modelAndView;
	}

	@RequestMapping("oderList")
	public String oderList(@ModelAttribute("adminUser") AdminUser adminUser, @ModelAttribute("message") String message,
			@ModelAttribute("errorMessage") String errorMessage, Model model) {
		List<OrderRecord> list = orderRecordService.getOrderRecordList();
		model.addAttribute("list", list);
		model.addAttribute("adminUser", adminUser);
		model.addAttribute(errorMessage);
		model.addAttribute(message);
		return "admin/oderList";
	}

	@RequestMapping("billList")
	public String billList(@ModelAttribute("errorMessage") String errorMessage,
			@ModelAttribute("message") String message, Model model) {
		List<Bill> list = billService.getBills();
		model.addAttribute("list", list);
		model.addAttribute(errorMessage);
		model.addAttribute(message);
		return "admin/billList";
	}

	@RequestMapping("billDetail/{id}")
	public String billDetail(@PathVariable("id") long id, Model model) {
		Bill bill = billService.getBill(id);
		if (bill != null) {
			double total = billService.totalPrice(bill);
			double tax = BillUtility.getTax(total);
			total = BillUtility.totalBill(total);
			model.addAttribute("bill", bill);
			model.addAttribute("tax", tax);
			model.addAttribute("total", total);
			model.addAttribute("table_number", bill.getFood_table().getTable_number());
		}
		return "admin/billDetail";
	}

	@RequestMapping("confirnBill/{id}")
	public ModelAndView confirmBill(@PathVariable("id") long id, RedirectAttributes redirect) {
		Bill bill = billService.getBill(id);
		if (bill != null) {
			foodTableService.confirmBill(bill.getFood_table());
			redirect.addFlashAttribute("message", "Bill Id " + bill.getId() + " being confirmed!");
		} else {
			redirect.addFlashAttribute("errorMessage", "Can't be confirmed!");
		}
		return new ModelAndView("redirect:/admin/billList");
	}

	@RequestMapping("acceptOder/{id}")
	public ModelAndView acceptOrder(@PathVariable("id") long id, RedirectAttributes redirect) {
		OrderRecord orderRecord = orderRecordService.acceptRecord(id);
		if (null != orderRecord) {
			redirect.addFlashAttribute("message", "Order Id " + orderRecord.getId() + " being accept!");
		} else {
			redirect.addFlashAttribute("errorMessage", "Can't be accept!");
		}
		return new ModelAndView("redirect:/admin/oderList");
	}

	@RequestMapping("completeOder/{id}")
	public ModelAndView completeOrder(@PathVariable("id") long id, RedirectAttributes redirect) {
		OrderRecord orderRecord = orderRecordService.completeRecord(id);
		if (null != orderRecord) {
			redirect.addFlashAttribute("message", "Order Id " + orderRecord.getId() + " make complete!");
		} else {
			redirect.addFlashAttribute("errorMessage", "Can't make complete!");
		}
		return new ModelAndView("redirect:/admin/oderList");
	}

}
