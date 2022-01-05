package org.team.g2.fundboard.mapper;

import org.apache.ibatis.annotations.Param;
import org.team.g2.fundboard.domain.FundBoard;
import org.team.g2.fundboard.domain.FundBoardAttach;
import org.team.g2.fundboard.dto.PageRequestDTO;

import java.util.List;

public interface FundBoardMapper {
    void insert(FundBoard fundBoard);
    List<FundBoard> getList(PageRequestDTO pageRequestDTO);
    List<FundBoard> getEndList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);
    FundBoard select(long fno);
    int update(FundBoard fundBoard);
    void updateFundCnt(long fno);
    int delete(long fno);
    
    // 해시태그
    void insertHashtag(@Param("num") Long num, @Param("tags") String tags); // 입력
    List<String> selectHash(@Param("num") Long num); // 조회
    int deleteHashtag(@Param("num") Long num); // 삭제
}
