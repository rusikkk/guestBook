package com.rusya.guestBook.controller;


import com.rusya.guestBook.dto.GuestDTO;
import com.rusya.guestBook.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class GuestController {
    private List<GuestDTO> guestList = new ArrayList<>();

    @Autowired
    private GuestService guestService;




    @RequestMapping(value = "/listGuest" , method = RequestMethod.GET)
    public ModelAndView listGuest(@RequestParam(required = false)Integer page,
                                  ModelMap model)
    {
        GuestDTO guestDTO = new GuestDTO();
        model.addAttribute("guest", guestDTO);


        return  new ModelAndView("listGuest", "guests",
                guestService.showAll());
    }


    @RequestMapping(value = "/addGuest", method = RequestMethod.POST)
    public String addGuest(@ModelAttribute(value = "guest") GuestDTO guestDTO,  ModelMap map)
    {
        this.guestService.save(guestDTO);
        map.put("listGuest", guestService.showAll() );
        return "redirect:/listGuest";

    }

}
