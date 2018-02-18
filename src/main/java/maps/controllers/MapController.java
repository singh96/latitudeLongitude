package maps.controllers;

import java.util.ArrayList;
import java.util.List;

import maps.dto.Geolocation;
import maps.utility.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class MapController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("MapsHome");
	}

	@RequestMapping(value = "/getLocation", method = RequestMethod.GET)
	public ModelAndView testRequest(@RequestParam("latitude") List<String> latitudes,
			@RequestParam("longitude") List<String> longitudes) {

		List<Geolocation> geoLocation = new ArrayList<>();
		for (int i = 0; i < latitudes.size(); i++) {
			geoLocation.add(new Geolocation(latitudes.get(i), longitudes.get(i),
					new Address().getAddress(latitudes.get(i), longitudes.get(i))));
		}
		return new ModelAndView("MapsResult", "geo", geoLocation);
	}
}