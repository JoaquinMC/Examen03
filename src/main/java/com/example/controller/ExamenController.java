package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Alumno;
import com.example.repository.IAlumnoRepository;
import com.example.repository.ICarreraRepository;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


@Controller
public class ExamenController {
	
	@Autowired
	private IAlumnoRepository repoA;
	@Autowired
	private ICarreraRepository repoC;
	
	@GetMapping("/cargar")
	public String cargaPag(Model model) {
		model.addAttribute("alumno", new Alumno());
		model.addAttribute("lstcarrera",repoC.findAll());
		return "crudproductos";
	}
	
	@PostMapping("/grabar")
	public String grabarPag(@ModelAttribute Alumno alu, Model model) {
		System.out.println(alu);
		Alumno u = repoA.save(alu);
		model.addAttribute("lstcarrera",repoC.findAll());
		
		if(u == null) {model.addAttribute("mensaje","Alumno no registrado");
		  return "crudproductos";}
		
		else {model.addAttribute("mensaje","Alumno registrado");
			return "crudproductos";}
		
	} 
	
	
	@Autowired
	private DataSource dataSource;
	@RequestMapping("/{reportName}")
	public void demoReport1(@PathVariable("reportName") final String reportName,
	@RequestParam(required = false) Map<String, Object> parameters, HttpServletResponse response, HttpServletRequest request) throws Exception{
	parameters = parameters == null ? new HashMap<>() : parameters;
	ClassPathResource resource = new ClassPathResource("reportes" + File.separator + reportName + ".jasper");
	InputStream jasperStream = resource.getInputStream();
	JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());
	response.setContentType("application/pdf");
	response.setHeader("Content-Disposition", "inline;");
	final OutputStream outputStream = response.getOutputStream();
	JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}
	
}



























