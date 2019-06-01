package com.nt.service;

import java.util.List;

import com.nt.dto.PassengerDTO;

public interface PassengerService {
   public String groupTicketReservation(List<PassengerDTO> listDTOs);
}