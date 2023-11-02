import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
    private List<AccountServlet> accountList;
    private int currentPage;
    private int itemsPerPage;
    private int totalPages;

    public AccountServlet(List<AccountServlet> accountList, int currentPage, int itemsPerPage, int totalPages) {
        this.accountList = accountList;
        this.currentPage = currentPage;
        this.itemsPerPage = itemsPerPage;
        this.totalPages = totalPages;
    }

    @Override
    public void init() throws ServletException {
        accountList = new ArrayList<>();
        currentPage = 1;
        itemsPerPage = 20;

        // Tạo danh sách tài khoản mẫu
        accountList.add(new Account("email1@example.com", "User 1", "2022-01-01", "2023-10-30"));
        accountList.add(new Account("email2@example.com", "User 2", "2022-02-01", "2023-10-31"));
        accountList.add(new Account("email3@example.com", "User 3", "2022-03-01", "2023-11-01"));

        calculateTotalPages();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortParam = request.getParameter("sort");
        String prevPageParam = request.getParameter("prevPage");
        String nextPageParam = request.getParameter("nextPage");

        if (sortParam != null) {
            sortAccountList();
        } else if (prevPageParam != null) {
            prevPage();
        } else if (nextPageParam != null) {
            nextPage();
        }

        request.setAttribute("accountList", getAccountsForCurrentPage());
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void sortAccountList() {
        Collections.sort(accountList, Comparator.comparing(AccountServlet::getLastAccessTime).reversed());
        currentPage = 1;
        calculateTotalPages();
    }

    private void prevPage() {
        if (currentPage > 1) {
            currentPage--;
        }
    }

    private void nextPage() {
        if (currentPage < totalPages) {
            currentPage++;
        }
    }

    private List<AccountServlet> getAccountsForCurrentPage() {
        int startIndex = (currentPage - 1) * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, accountList.size());
        return accountList.subList(startIndex, endIndex);
    }

    private void calculateTotalPages() {
        totalPages = (int) Math.ceil((double) accountList.size() / itemsPerPage);
    }
}