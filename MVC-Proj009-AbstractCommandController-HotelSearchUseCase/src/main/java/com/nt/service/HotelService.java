package com.nt.service;

import java.util.List;

import com.nt.dto.HotelDTO;
import com.nt.dto.HotelResultDTO;

public interface HotelService {
   public List<HotelResultDTO> findHotels(HotelDTO dto);
}
