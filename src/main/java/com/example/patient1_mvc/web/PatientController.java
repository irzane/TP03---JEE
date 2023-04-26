package com.example.patient1_mvc.web;

import com.example.patient1_mvc.entities.Patient;
import com.example.patient1_mvc.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller @AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String patients(Model model, @RequestParam(name="page",defaultValue = "0") int page, @RequestParam(name="size",defaultValue = "5") int size,
                           @RequestParam(name="keyword",defaultValue = "") String keyword){
        Page<Patient> l = patientRepository.findByNameContains(keyword,PageRequest.of(page,size));
        model.addAttribute("ListPatients",l.getContent());
        model.addAttribute("Pages",new int[l.getTotalPages()]);
        model.addAttribute("CurrentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }

    @GetMapping(path = "/delete")
    public String DeletePatient(Model model,Long id){
        patientRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping(path = "/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }

    @GetMapping(path = "/save")
    public String save(Model model,Patient patient){
        patientRepository.save(patient);
        return "redirect:/index";
    }


    @GetMapping("/Patients")
    @ResponseBody // Avoir le résultat format JSON (Approche cote client)
    public List<Patient> listPatients(){
        return patientRepository.findAll();
    }



}
