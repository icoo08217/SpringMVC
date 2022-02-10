package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// WEB-INF 폴더 하위에 있는 파일들은 직접 부를 수 없다.
// 컨트롤러를 거쳐서 내부에서 호출을 해야 볼 수 있는 파일들을 넣는다.
@WebServlet(name = "mvcMemberFormServlet" , urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// 컨트롤러에서 뷰로 이동할 때 사용함.
        dispatcher.forward(request, response); // 다른 서블릿이나 JSP로 이동할 수 있는 기능

    }
}
