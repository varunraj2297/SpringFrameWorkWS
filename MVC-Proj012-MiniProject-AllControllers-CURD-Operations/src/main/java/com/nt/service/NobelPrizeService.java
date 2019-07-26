package com.nt.service;

import java.util.List;

import com.nt.dto.NobelPrizeDTO;

public interface NobelPrizeService {
   public String addNobelLaureate(NobelPrizeDTO dto);
   public List<NobelPrizeDTO> fetchAllNobelLaureates();
   public NobelPrizeDTO fetchNobelLaureateById(int id);
   public String modifyNobelLaureateDetails(NobelPrizeDTO dto);
   public String removeNobelLaureateDetailsById(int id);
}
