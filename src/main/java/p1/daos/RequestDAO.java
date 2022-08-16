package p1.daos;

import p1.pojos.Request;
import p1.services.DataSourceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RequestDAO implements DataSourceCRUD<Request> {

    Connection connection;
    public RequestDAO() {
        this.connection = DataSourceService.ConnectionManager.getConnection();
    }

    @Override
    public void create(Request request) {
        try{
            String sql = "INSERT INTO requests (title, reimbursement_amount, message, employee_id, status) " +
                    "VALUES (?, ?, ?, ?, false)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, request.getTitle());
            pstmt.setFloat(2, request.getReimbursementAmount());
            pstmt.setString(3, request.getMessage());
            pstmt.setInt(4, request.getEmployeeId());

            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()) {
                keys.getInt("request_id");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Request read(int id) {
        Request request = new Request();
        try{
            String sql = "SELECT * FROM requests WHERE request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();

            if(results.next()) {
                request.setRequestId(results.getInt("request_id"));
                request.setTitle(results.getString("title"));
                request.setReimbursementAmount(results.getFloat("reimbursement_amount"));
                request.setMessage(results.getString("message"));
                request.setEmployeeId(results.getInt("employee_id"));
                request.setStatus(results.getBoolean("status"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return request;
    }
    public List<Request> readALL() {
        List<Request> requestList = new LinkedList<>();
        try{
            String sql = "SELECT * FROM requests";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet results = pstmt.executeQuery();

            while (results.next()) {
                Request request = new Request();
                request.setRequestId(results.getInt("request_id"));
                request.setTitle(results.getString("title"));
                request.setReimbursementAmount(results.getFloat("reimbursement_amount"));
                request.setMessage(results.getString("message"));
                request.setEmployeeId(results.getInt("employee_id"));
                request.setStatus(results.getBoolean("status"));
                requestList.add(request);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return requestList;
    }
    public Request getSingleRequestForEmployee(Integer requestId, Integer employeeId){
        Request request = new Request();
        try{
            String sql = "SELECT * FROM requests WHERE request_id = ? AND employee_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, requestId);
            pstmt.setInt(2, employeeId);
            ResultSet results = pstmt.executeQuery();

            if(results.next()) {
                request.setRequestId(results.getInt("request_id"));
                request.setTitle(results.getString("title"));
                request.setReimbursementAmount(results.getFloat("reimbursement_amount"));
                request.setMessage(results.getString("message"));
                request.setEmployeeId(results.getInt("employee_id"));
                request.setStatus(results.getBoolean("status"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return request;
    }
    public List<Request> readRequestByEmployee(Integer id){
        List<Request> requestList = new LinkedList<>();
        try{
            String sql = "SELECT * FROM requests WHERE employee_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();

            while(results.next()){
                Request request = new Request();
                request.setRequestId(results.getInt("request_id"));
                request.setTitle(results.getString("title"));
                request.setReimbursementAmount(results.getFloat("reimbursement_amount"));
                request.setMessage(results.getString("message"));
                request.setEmployeeId(results.getInt("employee_id"));
                request.setStatus(results.getBoolean("status"));
                requestList.add(request);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return requestList;
    }

    public List<Request> readStatus(Boolean status){
        List<Request> statusList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM requests WHERE status = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setBoolean(1, status);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return statusList;
    }



    @Override
    public void update(Request request, Integer requestId) {
        try{
            String sql = "UPDATE requests SET title = ?, reimbursement_amount = ?, message = ?, " +
                    "status = false WHERE request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, request.getTitle());
            pstmt.setFloat(2, request.getReimbursementAmount());
            pstmt.setString(3, request.getMessage());
            pstmt.setInt(4, requestId);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Request request, Integer requestId, Integer employeeId) {
        try{
            String sql = "UPDATE requests SET title = ?, reimbursement_amount = ?, message = ?, " +
                    "status = false WHERE request_id = ? AND employee_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, request.getTitle());
            pstmt.setFloat(2, request.getReimbursementAmount());
            pstmt.setString(3, request.getMessage());
            pstmt.setInt(4, requestId);
            pstmt.setInt(5, employeeId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        try{
            String sql = "DELETE FROM requests WHERE request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
