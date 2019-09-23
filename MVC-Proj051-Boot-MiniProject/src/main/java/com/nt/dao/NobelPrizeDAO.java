package com.nt.dao;

import java.util.List;

import com.nt.bo.NobelPrizeBO;

public interface NobelPrizeDAO {
   public int insertNobelLaureate(NobelPrizeBO bo);
   public List<NobelPrizeBO> getAllNobelLaureates();
   public NobelPrizeBO getNobelLaureateById(int id);
   public int updateNobelLaureateDetails(NobelPrizeBO bo);
   public int deleteNobelLaureateDetailsById(int id);
}
