package com.marketingapp5.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp5.Dto.LeadDto;
import com.marketingapp5.Service.LeadService;
import com.marketingapp5.entities.Lead;
import com.marketingapp5.util.EmailService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	//localhost:8080/create

	@RequestMapping("/create")
	public String viewCreateLeadForm() {
		return "create_lead";
		
//	}
//	//localhost:8080/saveReg
//	@RequestMapping("/saveReg")
//	public String saveOneLead(@ModelAttribute Lead lead,Model model) {
//		model.addAttribute("msg", "leadSaved");
//		emailService.sendEmail(lead.getEmail(), "testing", "mind fuck");
//		leadService.saveReg(lead);
//		return "create_lead";
//	
//	}
	
//	@RequestMapping("/saveReg")
//public String saveOneLead(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("email") String email,@RequestParam("mobile") long mobile,ModelMap model) {
//		Lead l = new Lead();
//		l.setFirstname(firstname);
//		l.setLastname(lastname);
//		l.setEmail(email);
//	
//    l.setMobile(mobile);
//	model.addAttribute("msg", "Lead is Saved!");
//		leadService.saveReg(l);
//		return "create_lead";
//}
//	 @RequestMapping("/saveReg")
//	  public String saveOneLead(LeadDto dto) {
//		Lead lead = new Lead();
//		lead.setFirstname(dto.getFirstname());
//		lead.setLastname(dto.getLastname());
//		lead.setEmail(dto.getEmail());
//		lead.setMobile(dto.getMobile());
//		
//		leadService.saveReg(lead);
// 	return "create_lead";
	
}
	//localhost:8080/list
	@RequestMapping("/list")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.findAllLeads();
	    model.addAttribute("leads", leads);
		return "list_lead";
		
	}
	@RequestMapping("/delete")
	public String deleteById(@RequestParam ("id") long id,Model model) {
		leadService.deleteById(id);
		
		List<Lead> leads = leadService.findAllLeads();
	    model.addAttribute("leads", leads);
		return "list_lead";
	}
	@RequestMapping("/update")
	public String updateLead(@RequestParam("id") long id,Model model) {
		Lead lead =leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	@RequestMapping("/editReg")
	public String edidReg(LeadDto dto,Model model) {
		Lead lead = new Lead();
		lead.setId(dto.getId());
		lead.setFirstname(dto.getFirstname());
		lead.setLastname(dto.getLastname());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		
		leadService.saveReg(lead);
		
		
		List<Lead> leads = leadService.findAllLeads();
	    model.addAttribute("leads", leads);
		return "list_lead";
	}
}
