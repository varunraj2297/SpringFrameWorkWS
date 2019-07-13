package com.nt.dao;

import java.util.List;

import com.nt.bo.HotelBO;
import com.nt.bo.HotelResultBO;

public interface HotelDAO {
   public List<HotelResultBO> searchHotels(HotelBO bo);
}
