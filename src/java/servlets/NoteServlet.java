package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 807930
 */
public class NoteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/Note.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            
        String title = br.readLine();          
        String content = br.readLine();
        br.close();
        String edit = request.getParameter("edit");
        
        if(edit != null) {
            request.setAttribute("editTitle", title);
            request.setAttribute("editContent", content);
            getServletContext().getRequestDispatcher("/WEB-INF/EditNote.jsp").forward(request, response);
        }
        else {
            
            request.setAttribute("title", title);
            request.setAttribute("content", content);
            
            Note note = new Note (title, content);
            request.setAttribute("note", note);

            getServletContext().getRequestDispatcher("/WEB-INF/ViewNote.jsp").forward(request, response);
            
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/Note.txt");
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        String editTitle = request.getParameter("editTitle");
        String editContent = request.getParameter("editContent");
        
        Note note = new Note (editTitle, editContent);
        request.setAttribute("note", note);
        
        pw.println(note.getTitle());
        pw.println(note.getContent());
        pw.close();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();          
        String content = br.readLine();
        
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        
        getServletContext().getRequestDispatcher("/WEB-INF/ViewNote.jsp").forward(request, response);
        br.close();
    }

}