package org.team.g2.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.team.g2.common.config.RootConfig;
import org.team.g2.fundboard.config.FundRootConfig;
import org.team.g2.fundboard.domain.FundBoard;
import org.team.g2.fundboard.mapper.FundBoardMapper;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {FundRootConfig.class, RootConfig.class} )
public class FundBoardMapperTests {
    
    @Autowired
    FundBoardMapper FundBoardMapper;

    @Test
    public void testDummies() {

        IntStream.rangeClosed(1,100).forEach(i -> {
            FundBoard board = FundBoard.builder()
                    .ftitle("펀딩 제목" + i)
                    .fcontent("펀딩 내용" + i)
                    .fwriter("펀딩 유저" + (i%10)) // user0 ~ user9
                    .build();
            FundBoardMapper.insert(board);
        });
    }

}
