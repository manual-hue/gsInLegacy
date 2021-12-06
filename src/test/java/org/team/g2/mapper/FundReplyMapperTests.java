package org.team.g2.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.team.g2.common.config.RootConfig;
import org.team.g2.fundboard.config.FundRootConfig;
import org.team.g2.fundboard.domain.FundReply;
import org.team.g2.fundboard.mapper.FundReplyMapper;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {FundRootConfig.class, RootConfig.class})
public class FundReplyMapperTests {

    @Autowired(required = false) //스프링이로딩될때 Autowired가능한지 체크하지 않는다.
    FundReplyMapper replyMapper;

    @Test
    public void insertDummies() {
        long[] arr = {180L}; //5개 랜덤 번호 정함(게시물번호)

        IntStream.rangeClosed(1, 10).forEach(num -> {
//            long bno = arr[(int)(Math.random())*arr.length]; //0,1,2,3,4
            long fno = arr[(int) (Math.random() * 1000) % 5]; //0,1,2,3,4

            FundReply reply = FundReply.builder()
                    .fno(fno)
                    .freply("ㅇㅈ")
                    .freplyer("삼송 불주먹"+(num % 9)) //0~9까지
                    .build();

            replyMapper.insert(reply);
        });
    }

    @Test
    public void testList() {
        Long fno = 157L;

        replyMapper.getListWithFundBoard(fno).forEach(reply -> log.info(reply));
    }


}