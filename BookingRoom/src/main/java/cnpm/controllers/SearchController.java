package cnpm.controllers;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.domain.District;
import cnpm.service.DistrictService;
import cnpm.service.ProvinceService;

@Controller
public class SearchController {
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private DistrictService districtService;
	
	
	
	/*@RequestMapping(value="/province")*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String index( Model model) {
		model.addAttribute("provinces", provinceService.findAll());
		return "search";
	}
	
	@RequestMapping(value = "/loadDistrict/{districtid}")
	public String loadDistrict(@PathVariable String districid, Model model) {
		model.addAttribute("district",districtService.findAllLimitDis() );
		return "redirect:/load-distritc";
				
	}
	/*@RequestMapping("/states")
	public List<District> getDistrictid(@PathVariabl String country) {
	    return districtService.getDistrictid(country) ;
	}*/
	
	/*Map <\string, string> udata = null;
	@RequestMapping(value = "ajaxAction0", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> findAllAgencies(
	        @RequestParam(value = "ptype", required = true) String ptype) {
	    udata = new HashMap<>();
	    EntityManager em = entityManagerFactory.createEntityManager();
	    em.getTransaction().begin();
	    List<UserRecord> user = em
	            .createNativeQuery("Select id, name, email from user_Record where id = :uid", UserRecord.class)
	            .setParameter("uid", ptype).getResultList();
	            for(UserRecord ur:user)     {
	        udata.put(ur.getEmail(), ur.getName());
	    }
	    return udata;   }*/
}