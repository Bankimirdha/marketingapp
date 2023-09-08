package com.marketingapp5.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp5.Dto.LeadDto;
import com.marketingapp5.Repository.LeadRepository;
import com.marketingapp5.entities.Lead;

@RestController
@RequestMapping("/api/leads")
public class RestLeadController {

	@Autowired
	private LeadRepository leadRepository;
	
	//localhost:8080/api/leads
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepository.findAll();
		return leads;
		
	}
	//localhost:8080/api/leads
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		leadRepository.save(lead);
	}
	//localhost:8080/api/leads/{id}"
	@DeleteMapping("/{id}")
	public void deleteLeadById(@PathVariable("id") long id) {
		leadRepository.deleteById(id);
	}
	@PutMapping
	public void updateLead(@RequestBody LeadDto dto) {
		Lead lead = new Lead();
		lead.setId(dto.getId());
		lead.setFirstname(dto.getFirstname());
		lead.setLastname(dto.getLastname());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		
		leadRepository.save(lead);
	}
	//http://localhost:8080/api/leads/{id}
	
	@GetMapping("/{id}")
	public Lead getLeadById(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepository.findById(id);
		return findById.get();
	}
}
