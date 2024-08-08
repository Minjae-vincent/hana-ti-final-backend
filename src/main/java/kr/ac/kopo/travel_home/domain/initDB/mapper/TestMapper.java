package kr.ac.kopo.travel_home.domain.initDB.mapper;

import kr.ac.kopo.travel_home.domain.initDB.vo.ExchangeRate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    public List<String> getDBConnectionTest();

    void insertExchangeRate(ExchangeRate exchangeRate1);
}
