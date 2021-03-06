package org.zerock.sb.service;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.sb.dto.BoardDTO;
import org.zerock.sb.entity.Board;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testModify() {

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(201L)
                .title("한글제목")
                .content("한글내용")
                .build();

        boardService.modify(boardDTO);

    }

    @Test
    public void testRegister() {

        IntStream.rangeClosed(1,200).forEach(i -> {
            BoardDTO boardDTO = BoardDTO.builder()
                    .title("title..." + i)
                    .content("content..." + i)
                    .writer("user" + (i % 10 ))
                    .build();
           Long bno =  boardService.register(boardDTO);

           log.info("BNO:" + bno);

        });

    }

}
