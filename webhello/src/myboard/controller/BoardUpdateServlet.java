package myboard.controller;

import myboard.entity.Board;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class BoardUpdateServlet extends HttpServlet{

    BoardRepository boardRepository = BoardMemoryRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String tmpid = request.getParameter("id");

        //1. model에서 데이터 조회
        Board board = (Board)boardRepository.searchBoard(Integer.parseInt(tmpid));

        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");
        String pw = request.getParameter("pw");


        //1. model에서 데이터 저장
        board.setTitle(new String(title.getBytes("8859_1"),"utf-8"));
        board.setWriter(new String(writer.getBytes("8859_1"),"utf-8"));
        board.setContent(new String(content.getBytes("8859_1"),"utf-8"));
        board.setPw(new String(pw.getBytes("8859_1"),"utf-8"));

        System.out.println("update board = " + board);

        //2. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/board/boardUpdateSave.jsp");
        view.forward(request, response);
    }
}
