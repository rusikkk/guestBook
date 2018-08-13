package com.rusya.guestBook.service;

import com.rusya.guestBook.dto.GuestDTO;

import java.awt.print.Pageable;
import java.util.List;


public interface GuestService {
    public void save(GuestDTO guestDTO);
    public List<GuestDTO> showAll();


}
